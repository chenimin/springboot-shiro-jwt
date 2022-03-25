package com.aoizz.communitymarket.controller.system;

import com.aoizz.communitymarket.entity.system.SystemPermission;
import com.aoizz.communitymarket.service.system.SystemPermissionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (system_permission)表控制层
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("system_permission")
public class SystemPermissionController {
    /**
     * 服务对象
     */
    @Resource
    private SystemPermissionService systemPermissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SystemPermission selectOne(Integer id) {
        return systemPermissionService.getById(id);
    }

}
