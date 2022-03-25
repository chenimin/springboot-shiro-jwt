package com.aoizz.communitymarket.entity.system;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author chd
 */

/**
 * 角色权限关联表
 */
@ApiModel(value = "角色权限关联表")
@Data
@AllArgsConstructor
@TableName(value = "system_role_permission")
public class SystemRolePermission implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "")
    private Long id;
    /**
     * 角色ID
     */
    @TableField(value = "role_id")
    @ApiModelProperty(value = "角色ID")
    private Long roleId;
    /**
     * 权限ID
     */
    @TableField(value = "permission_id")
    @ApiModelProperty(value = "权限ID")
    private Long permissionId;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "")
    private LocalDateTime updateTime;
    @TableField(value = "del_flag")
    @ApiModelProperty(value = "")
    private Boolean delFlag;
}