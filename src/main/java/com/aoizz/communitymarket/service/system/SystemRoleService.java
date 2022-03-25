package com.aoizz.communitymarket.service.system;

import com.aoizz.communitymarket.entity.system.SystemRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author chd
 */
public interface SystemRoleService extends IService<SystemRole> {


    int updateBatch(List<SystemRole> list);

    int updateBatchSelective(List<SystemRole> list);

    int batchInsert(List<SystemRole> list);

    int insertOrUpdate(SystemRole record);

    int insertOrUpdateSelective(SystemRole record);

}
