package com.aoizz.communitymarket.common.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @version 1.0
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountProfile implements Serializable {
    private Long id;
}
