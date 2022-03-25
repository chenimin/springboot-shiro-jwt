package com.aoizz.communitymarket.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RoleDto {
    private Long id;
    private String name;
    /**
     * 角色对应权限集合
     */
    private List<PermissionDto> permissions;
}
