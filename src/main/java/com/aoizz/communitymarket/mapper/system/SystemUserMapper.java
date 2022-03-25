package com.aoizz.communitymarket.mapper.system;

import com.aoizz.communitymarket.entity.system.SystemUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chd
 */
@Mapper
public interface SystemUserMapper extends BaseMapper<SystemUser> {
    int updateBatch(List<SystemUser> list);

    int updateBatchSelective(List<SystemUser> list);

    int batchInsert(@Param("list") List<SystemUser> list);

    int insertOrUpdate(SystemUser record);

    int insertOrUpdateSelective(SystemUser record);
}