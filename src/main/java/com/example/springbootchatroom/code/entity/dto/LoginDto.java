package com.example.springbootchatroom.code.entity.dto;

import lombok.Data;

/**
 * loginDto
 */
@Data
public class LoginDto {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
