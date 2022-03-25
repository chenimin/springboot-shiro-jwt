package com.aoizz.communitymarket.service.impl.system;

import com.aoizz.communitymarket.entity.system.SystemRolePermission;
import com.aoizz.communitymarket.mapper.system.SystemRolePermissionMapper;
import com.aoizz.communitymarket.service.system.SystemRolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chd
 */
@Service
public class SystemRolePermissionServiceImpl extends ServiceImpl<SystemRolePermissionMapper, SystemRolePermission> implements SystemRolePermissionService {

    @Override
    public int updateBatch(List<SystemRolePermission> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<SystemRolePermission> list) {
        return baseMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<SystemRolePermission> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(SystemRolePermission record) {
        return baseMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SystemRolePermission record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}

