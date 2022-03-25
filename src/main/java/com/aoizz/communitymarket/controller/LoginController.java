package com.aoizz.communitymarket.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import com.aoizz.communitymarket.common.dto.LoginDto;
import com.aoizz.communitymarket.common.response.RestfulResponse;
import com.aoizz.communitymarket.entity.system.SystemUser;
import com.aoizz.communitymarket.service.system.SystemUserService;
import com.aoizz.communitymarket.util.EncryptionUtil;
import com.aoizz.communitymarket.util.JwtUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chd
 */
@RestController
public class LoginController {

    @Resource
    private SystemUserService systemUserService;
    @Resource
    private JwtUtil jwtUtil;

    /**
     * @description: 首次登录，无需认证，直接验证密码并生成token，并于请求头添加token
     */
    @PostMapping("/login")
    public RestfulResponse login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response) {

        SystemUser user = systemUserService.getByAccount(loginDto.getAccount());
        Assert.notNull(user, "用户不存在");
        if (!EncryptionUtil.shiroEncryption(loginDto.getPassword(), user.getSalt()).equals(user.getPassword())) {
            return RestfulResponse.fail(400, "密码错误");
        }
        // 密码正确则登录成功并设置token
        String token = jwtUtil.createToken(String.valueOf(user.getId()));
        response.setHeader("auth", token);
        response.setHeader("Access-Control-Expose-Headers", "auth");
        return RestfulResponse.success(MapUtil.builder()
                .put("userName", user.getUsername())
                .put("userEmail", user.getEmail())
                .map()
        );
    }

    /**
     * @description: 退出登录操作，前端要进行删除token操作并退回登录页面，后端删除认证信息
     * 注意：
     * 1. 如果token并没有过期，postman中前端在带着原来的token访问还是可以访问成功并生成新的认证信息
     * 2. 在一次session中，用户第一次登录成功只给前端返回token，前端每次发送请求都会在请求头中携带token，
     * 只要后端检查到token则会进行校验，校验成功则生成一次session中的认证信息。
     * 在这一次session中，后端保留了认证信息，这时前端即使不带token也可以访问成功，
     * 即可以成功通过@RequiresAuthentication, 但logout后删除了认证信息，不带token则访问失败
     */
    @GetMapping("/logout")
    public RestfulResponse logout() {
        SecurityUtils.getSubject().logout();
        return RestfulResponse.success();
    }
}
