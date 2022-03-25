package com.aoizz.communitymarket.service.impl.system;

import com.aoizz.communitymarket.entity.system.SystemUserRole;
import com.aoizz.communitymarket.mapper.system.SystemUserRoleMapper;
import com.aoizz.communitymarket.service.system.SystemUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chd
 */
@Service
public class SystemUserRoleServiceImpl extends ServiceImpl<SystemUserRoleMapper, SystemUserRole> implements SystemUserRoleService {

    @Override
    public int updateBatch(List<SystemUserRole> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<SystemUserRole> list) {
        return baseMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<SystemUserRole> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(SystemUserRole record) {
        return baseMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SystemUserRole record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}

