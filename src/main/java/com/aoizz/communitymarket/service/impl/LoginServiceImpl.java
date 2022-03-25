package com.aoizz.communitymarket.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.aoizz.communitymarket.common.dto.PermissionDto;
import com.aoizz.communitymarket.common.dto.RoleDto;
import com.aoizz.communitymarket.common.dto.UserDto;
import com.aoizz.communitymarket.entity.system.*;
import com.aoizz.communitymarket.service.LoginService;
import com.aoizz.communitymarket.service.system.*;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private SystemPermissionService systemPermissionService;
    @Resource
    private SystemUserService systemUserService;
    @Resource
    private SystemRoleService systemRoleService;
    @Resource
    private SystemRolePermissionService systemRolePermissionRelService;
    @Resource
    private SystemUserRoleService systemUserRoleService;

    public UserDto getUserByUsername(Long id) {
        SystemUser user = systemUserService.getById(id);
        UserDto userDto = BeanUtil.copyProperties(user, UserDto.class);
        List<SystemUserRole> userRoleList = systemUserRoleService.list(Wrappers.<SystemUserRole>lambdaQuery()
                .eq(SystemUserRole::getUserId, user.getId())
        );

        List<Long> roleIdList = userRoleList.stream().map(SystemUserRole::getRoleId).distinct().collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(roleIdList)) {
            List<SystemRole> systemRoleList = systemRoleService.listByIds(roleIdList);

            List<RoleDto> roleDtoList = BeanUtil.copyToList(systemRoleList, RoleDto.class);
            List<Long> systemRoleIdList = systemRoleList.stream().map(SystemRole::getId).collect(Collectors.toList());
            //获取角色对应的权限
            if (CollectionUtil.isNotEmpty(systemRoleIdList)) {
                List<SystemRolePermission> permissionRelList = systemRolePermissionRelService.list(Wrappers.<SystemRolePermission>lambdaQuery()
                        .in(SystemRolePermission::getRoleId, systemRoleIdList)
                );
                List<Long> permissionIdList = permissionRelList.stream().map(SystemRolePermission::getPermissionId).distinct().collect(Collectors.toList());
                Map<Long, List<SystemRolePermission>> roleRelMap = permissionRelList.stream().collect(Collectors.groupingBy(SystemRolePermission::getRoleId));
                if (CollectionUtil.isNotEmpty(permissionIdList)) {
                    List<SystemPermission> systemPermissionList = systemPermissionService.listByIds(permissionIdList);
                    Map<Long, SystemPermission> permissionMap = systemPermissionList.stream().collect(Collectors.toMap(SystemPermission::getId, e -> e));
                    roleDtoList.forEach(role -> {
                        List<SystemRolePermission> permissionRels = roleRelMap.get(role.getId());
                        if (CollectionUtil.isNotEmpty(permissionRels)) {
                            List<PermissionDto> permissionDtoList = permissionRels.stream().map(permissionRel ->
                                    permissionMap.get(permissionRel.getPermissionId())).filter(ObjectUtil::isNotNull)
                                    .map(systemPermission -> BeanUtil.copyProperties(systemPermission, PermissionDto.class)).collect(Collectors.toList());
                            role.setPermissions(permissionDtoList);
                        }
                    });
                }
            }
            userDto.setRoleDtoList(roleDtoList);
        }
        return userDto;
    }


}
