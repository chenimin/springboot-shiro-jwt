package com.aoizz.communitymarket.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @version 1.0
 * @description Jwt工具包
 */
@Data
@Component
@Slf4j
@ConfigurationProperties(prefix = "auth.jwt")
public class JwtUtil {
    private String secret;
    private int expire;

    /**
     * @description: 生成token
     */
    public String createToken(String email) {
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + expire * 1000L); // 乘上1000ms
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(email)
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    /**
     * @description: 根据用户的token获取claims用于校验token
     */
    public Claims getClaimsByToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.error("token error: {}", e.getMessage());
            return null;
        }
    }

    /**
     * @description: 校验token是否过期
     */
    public boolean isTokenExpired(Date expireDate) {
        return expireDate.before(new Date());
    }
}
