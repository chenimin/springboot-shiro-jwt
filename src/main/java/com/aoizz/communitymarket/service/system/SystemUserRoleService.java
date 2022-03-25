package com.aoizz.communitymarket.service.system;

import com.aoizz.communitymarket.entity.system.SystemUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author chd
 */
public interface SystemUserRoleService extends IService<SystemUserRole> {


    int updateBatch(List<SystemUserRole> list);

    int updateBatchSelective(List<SystemUserRole> list);

    int batchInsert(List<SystemUserRole> list);

    int insertOrUpdate(SystemUserRole record);

    int insertOrUpdateSelective(SystemUserRole record);

}
