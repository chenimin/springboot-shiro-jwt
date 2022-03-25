package com.aoizz.communitymarket.service.system;

import com.aoizz.communitymarket.entity.system.SystemUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author chd
 */
public interface SystemUserService extends IService<SystemUser> {


    int updateBatch(List<SystemUser> list);

    int updateBatchSelective(List<SystemUser> list);

    int batchInsert(List<SystemUser> list);

    int insertOrUpdate(SystemUser record);

    int insertOrUpdateSelective(SystemUser record);

    /**
     * 通过登录账号来获取用户,根据账号类型判断是手机号/邮箱/用户名
     *
     * @param account
     * @return
     */
    SystemUser getByAccount(String account);

}
