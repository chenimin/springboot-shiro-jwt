package com.aoizz.communitymarket.service.system;

import com.aoizz.communitymarket.entity.system.SystemPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author chd
 */
public interface SystemPermissionService extends IService<SystemPermission> {


    int updateBatch(List<SystemPermission> list);

    int updateBatchSelective(List<SystemPermission> list);

    int batchInsert(List<SystemPermission> list);

    int insertOrUpdate(SystemPermission record);

    int insertOrUpdateSelective(SystemPermission record);

}
