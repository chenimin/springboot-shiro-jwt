package com.aoizz.communitymarket.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String phone;
    private String password;
    private String salt;
    /**
     * 用户对应的角色集合
     */
    private List<RoleDto> roleDtoList;
}
