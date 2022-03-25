package com.aoizz.communitymarket.util;

import org.apache.shiro.crypto.hash.SimpleHash;

public class EncryptionUtil {

    /**
     * 对用户的密码进行MD5加密
     *
     * @param password
     * @param salt     shiro 自带的工具类生成salt
     *                 String salt = new SecureRandomNumberGenerator().nextBytes().toString();
     * @return
     */
    public static String shiroEncryption(String password, String salt) {
        // 加密次数
        int times = 2;
        // 算法名称
        String algorithmName = "md5";
        // 返回加密后的密码
        return new SimpleHash(algorithmName, password, salt, times).toString();


    }
}