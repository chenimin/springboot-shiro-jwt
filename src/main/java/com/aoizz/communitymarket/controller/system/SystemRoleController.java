package com.aoizz.communitymarket.controller.system;

import com.aoizz.communitymarket.entity.system.SystemRole;
import com.aoizz.communitymarket.service.system.SystemRoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (system_role)表控制层
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("system_role")
public class SystemRoleController {
    /**
     * 服务对象
     */
    @Resource
    private SystemRoleService systemRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SystemRole selectOne(Integer id) {
        return systemRoleService.getById(id);
    }

}
