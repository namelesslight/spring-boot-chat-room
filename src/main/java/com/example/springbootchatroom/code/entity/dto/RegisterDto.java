package com.example.springbootchatroom.code.entity.dto;

import lombok.Data;

/**
 * registerDto
 */
@Data
public class RegisterDto {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 图片路径
     */
    private String imagePath;
}
