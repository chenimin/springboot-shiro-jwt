package com.aoizz.communitymarket.controller.system;

import com.aoizz.communitymarket.entity.system.SystemUserRole;
import com.aoizz.communitymarket.service.system.SystemUserRoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (system_user_role)表控制层
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("system_user_role")
public class SystemUserRoleController {
    /**
     * 服务对象
     */
    @Resource
    private SystemUserRoleService systemUserRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SystemUserRole selectOne(Integer id) {
        return systemUserRoleService.getById(id);
    }

}
