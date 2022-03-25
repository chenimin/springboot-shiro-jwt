package com.aoizz.communitymarket.controller.system;

import com.aoizz.communitymarket.entity.system.SystemUser;
import com.aoizz.communitymarket.service.system.SystemUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (`system_user`)表控制层
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("`system_user`")
public class SystemUserController {
    /**
     * 服务对象
     */
    @Resource
    private SystemUserService systemUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SystemUser selectOne(Integer id) {
        return systemUserService.getById(id);
    }

}
