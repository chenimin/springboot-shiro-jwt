package com.aoizz.communitymarket.service.impl.system;

import cn.hutool.core.lang.Validator;
import com.aoizz.communitymarket.entity.system.SystemUser;
import com.aoizz.communitymarket.mapper.system.SystemUserMapper;
import com.aoizz.communitymarket.service.system.SystemUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chd
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser> implements SystemUserService {

    @Override
    public int updateBatch(List<SystemUser> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<SystemUser> list) {
        return baseMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<SystemUser> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(SystemUser record) {
        return baseMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SystemUser record) {
        return baseMapper.insertOrUpdateSelective(record);
    }

    @Override
    public SystemUser getByAccount(String account) {
        QueryWrapper<SystemUser> wrapper = new QueryWrapper<>();
        if (Validator.isMobile(account)) {
            wrapper.eq("phone", account);
        } else if (Validator.isEmail(account)) {
            wrapper.eq("email", account);
        } else {
            wrapper.eq("username", account);
        }
        return this.getOne(wrapper, false);
    }
}

