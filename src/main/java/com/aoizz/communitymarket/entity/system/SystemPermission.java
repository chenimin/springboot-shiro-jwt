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
 * 权限
 */
@ApiModel(value = "权限")
@Data
@AllArgsConstructor
@TableName(value = "system_permission")
public class SystemPermission implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "")
    private Long id;
    /**
     * 权限名称
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value = "权限名称")
    private String name;
    /**
     * 权限介绍
     */
    @TableField(value = "description")
    @ApiModelProperty(value = "权限介绍")
    private String description;
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
    /**
     * 0
     */
    @TableField(value = "del_flag")
    @ApiModelProperty(value = "0")
    private Boolean delFlag;
}