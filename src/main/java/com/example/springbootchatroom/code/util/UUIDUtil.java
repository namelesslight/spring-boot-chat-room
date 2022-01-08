package com.example.springbootchatroom.code.util;

import java.util.UUID;

/**
 * UUID字符串生成工具类
 */
public class UUIDUtil {
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().replace("-","");
        return uuid;
    }
}
