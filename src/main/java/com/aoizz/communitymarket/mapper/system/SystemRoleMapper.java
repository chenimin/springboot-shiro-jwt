package com.aoizz.communitymarket.mapper.system;

import com.aoizz.communitymarket.entity.system.SystemRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chd
 */
@Mapper
public interface SystemRoleMapper extends BaseMapper<SystemRole> {
    int updateBatch(List<SystemRole> list);

    int updateBatchSelective(List<SystemRole> list);

    int batchInsert(@Param("list") List<SystemRole> list);

    int insertOrUpdate(SystemRole record);

    int insertOrUpdateSelective(SystemRole record);
}