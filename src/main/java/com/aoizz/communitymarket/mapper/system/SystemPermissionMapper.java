package com.aoizz.communitymarket.mapper.system;

import com.aoizz.communitymarket.entity.system.SystemPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chd
 */
@Mapper
public interface SystemPermissionMapper extends BaseMapper<SystemPermission> {
    int updateBatch(List<SystemPermission> list);

    int updateBatchSelective(List<SystemPermission> list);

    int batchInsert(@Param("list") List<SystemPermission> list);

    int insertOrUpdate(SystemPermission record);

    int insertOrUpdateSelective(SystemPermission record);
}