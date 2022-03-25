package com.aoizz.communitymarket.service.system;

import com.aoizz.communitymarket.entity.system.SystemRolePermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author chd
 */
public interface SystemRolePermissionService extends IService<SystemRolePermission> {


    int updateBatch(List<SystemRolePermission> list);

    int updateBatchSelective(List<SystemRolePermission> list);

    int batchInsert(List<SystemRolePermission> list);

    int insertOrUpdate(SystemRolePermission record);

    int insertOrUpdateSelective(SystemRolePermission record);

}
