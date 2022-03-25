package com.aoizz.communitymarket.common.security;

import cn.hutool.json.JSONUtil;
import com.aoizz.communitymarket.common.dto.PermissionDto;
import com.aoizz.communitymarket.common.dto.RoleDto;
import com.aoizz.communitymarket.common.dto.UserDto;
import com.aoizz.communitymarket.entity.system.SystemUser;
import com.aoizz.communitymarket.service.LoginService;
import com.aoizz.communitymarket.service.system.SystemUserService;
import com.aoizz.communitymarket.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @description 用于向数据库查询验证账户以及权限校验信息的注册
 */
@Component
public class AccountRealm extends AuthorizingRealm {
    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private LoginService loginService;
    @Resource
    private SystemUserService systemUserService;


    /**
     * @description: 必须添加，设置支持于自己指定的JwtToken
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * @description: 认证校验
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) authenticationToken;
        Claims claims = jwtUtil.getClaimsByToken((String) jwtToken.getPrincipal());

        String id = claims.getSubject();
        SystemUser user = systemUserService.getById(id);
        if (user == null) {
            throw new UnknownAccountException("用户不存在");
        }
        // 所有对象统一为AccountProfile内置属性rid作为统一redis缓存id
        AccountProfile profile = new AccountProfile();
        profile.setId(user.getId());
        return new SimpleAuthenticationInfo(profile, jwtToken.getCredentials(), this.getClass().getName());
    }

    /**
     * @description: 权限校验
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Object principal = principalCollection.getPrimaryPrincipal();
        // 这里从redis获取的信息不能被反序列化导致无法直接强转为AccountProfile
        AccountProfile profile = JSONUtil.parse(principal).toBean(AccountProfile.class);
        UserDto user = loginService.getUserByUsername(profile.getId());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (RoleDto roleDto : user.getRoleDtoList()) {
            //添加角色
            simpleAuthorizationInfo.addRole(roleDto.getName());
            //添加权限
            for (PermissionDto permissionDto : roleDto.getPermissions()) {
                simpleAuthorizationInfo.addStringPermission(permissionDto.getName());
            }
        }
        return simpleAuthorizationInfo;
    }
}
