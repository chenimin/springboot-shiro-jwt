package com.aoizz.communitymarket.controller;

import com.aoizz.communitymarket.common.response.RestfulResponse;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @description User控制器
 */
@RestController
public class IndexController {


    /**
     * @description: app初始界面
     */
    @GetMapping("/")
    public RestfulResponse init() {
        return RestfulResponse.success();
    }

    /**
     * @description: 前往admin初始页面
     */
    @RequiresAuthentication
    @RequiresRoles("admin")
    @GetMapping("/admin/index")
    public RestfulResponse admin_index() {
        return RestfulResponse.success();
    }

    /**
     * @description: 前往admin编辑页面
     */
    @RequiresAuthentication
    @RequiresRoles("admin")
    @RequiresPermissions(logical = Logical.AND, value = {"view", "edit"})
    @GetMapping("/admin/edit")
    public RestfulResponse admin_edit() {
        return RestfulResponse.success();
    }

    /**
     * @description: 前往student初始页面
     */
    @RequiresAuthentication
    @RequiresRoles("normal")
    @GetMapping("/student/index")
    public RestfulResponse student_index() {
        return RestfulResponse.success();
    }

    /**
     * @description: 前往teacher初始页面
     */
    @RequiresAuthentication
    @RequiresRoles("normal")
    @GetMapping("/teacher/index")
    public RestfulResponse teacher_index() {
        return RestfulResponse.success();
    }


}
