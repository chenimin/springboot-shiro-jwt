package com.aoizz.communitymarket.common.security;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @version 1.0
 * @description token类
 */
public class JwtToken implements AuthenticationToken {
    private final String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
