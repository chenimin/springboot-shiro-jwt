package com.aoizz.communitymarket.controller.system;

import com.aoizz.communitymarket.entity.system.SystemRolePermission;
import com.aoizz.communitymarket.service.system.SystemRolePermissionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (system_role_permission)表控制层
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("system_role_permission")
public class SystemRolePermissionController {
    /**
     * 服务对象
     */
    @Resource
    private SystemRolePermissionService systemRolePermissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SystemRolePermission selectOne(Integer id) {
        return systemRolePermissionService.getById(id);
    }

}
