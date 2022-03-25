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
 * 用户表
 */
@ApiModel(value = "用户表")
@Data
@AllArgsConstructor
@TableName(value = "`system_user`")
public class SystemUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "")
    private Long id;
    /**
     * 昵称
     */
    @TableField(value = "nickname")
    @ApiModelProperty(value = "昵称")
    private String nickname;
    /**
     * 用户名
     */
    @TableField(value = "username")
    @ApiModelProperty(value = "用户名")
    private String username;
    /**
     * 密码
     */
    @TableField(value = "`password`")
    @ApiModelProperty(value = "密码")
    private String password;
    /**
     * 邮箱
     */
    @TableField(value = "email")
    @ApiModelProperty(value = "邮箱")
    private String email;
    /**
     * 手机号
     */
    @TableField(value = "phone")
    @ApiModelProperty(value = "手机号")
    private String phone;
    /**
     * 性别 male/female
     */
    @TableField(value = "gender")
    @ApiModelProperty(value = "性别 male/female")
    private String gender;
    /**
     * 用户简介
     */
    @TableField(value = "description")
    @ApiModelProperty(value = "用户简介")
    private String description;
    /**
     * 头像
     */
    @TableField(value = "avatar")
    @ApiModelProperty(value = "头像")
    private String avatar;

    /**
     * 创建时间
     */
    /**
     * 盐
     */
    @TableField(value = "salt")
    @ApiModelProperty(value = "盐")
    private String salt;
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
    /**
     * 用户状态 0:正常 1:暂时冻结
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value = "用户状态 0:正常 1:暂时冻结")
    private Integer status;
}