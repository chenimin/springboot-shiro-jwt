package com.aoizz.communitymarket.mapper.system;

import com.aoizz.communitymarket.entity.system.SystemRolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chd
 */
@Mapper
public interface SystemRolePermissionMapper extends BaseMapper<SystemRolePermission> {
    int updateBatch(List<SystemRolePermission> list);

    int updateBatchSelective(List<SystemRolePermission> list);

    int batchInsert(@Param("list") List<SystemRolePermission> list);

    int insertOrUpdate(SystemRolePermission record);

    int insertOrUpdateSelective(SystemRolePermission record);
}