package com.aoizz.communitymarket.service.impl.system;

import com.aoizz.communitymarket.entity.system.SystemRole;
import com.aoizz.communitymarket.mapper.system.SystemRoleMapper;
import com.aoizz.communitymarket.service.system.SystemRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chd
 */
@Service
public class SystemRoleServiceImpl extends ServiceImpl<SystemRoleMapper, SystemRole> implements SystemRoleService {

    @Override
    public int updateBatch(List<SystemRole> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<SystemRole> list) {
        return baseMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<SystemRole> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(SystemRole record) {
        return baseMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SystemRole record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}

