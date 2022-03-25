package com.aoizz.communitymarket.service.impl.system;

import com.aoizz.communitymarket.entity.system.SystemPermission;
import com.aoizz.communitymarket.mapper.system.SystemPermissionMapper;
import com.aoizz.communitymarket.service.system.SystemPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chd
 */
@Service
public class SystemPermissionServiceImpl extends ServiceImpl<SystemPermissionMapper, SystemPermission> implements SystemPermissionService {

    @Override
    public int updateBatch(List<SystemPermission> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<SystemPermission> list) {
        return baseMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<SystemPermission> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(SystemPermission record) {
        return baseMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SystemPermission record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}

