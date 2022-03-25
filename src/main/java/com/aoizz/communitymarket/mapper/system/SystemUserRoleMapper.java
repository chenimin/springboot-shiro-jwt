package com.aoizz.communitymarket.mapper.system;

import com.aoizz.communitymarket.entity.system.SystemUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chd
 */
@Mapper
public interface SystemUserRoleMapper extends BaseMapper<SystemUserRole> {
    int updateBatch(List<SystemUserRole> list);

    int updateBatchSelective(List<SystemUserRole> list);

    int batchInsert(@Param("list") List<SystemUserRole> list);

    int insertOrUpdate(SystemUserRole record);

    int insertOrUpdateSelective(SystemUserRole record);
}