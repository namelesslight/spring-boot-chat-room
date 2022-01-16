package com.example.springbootchatroom.code.entity.dto;

import lombok.Data;

@Data
public class UpdatePasswordDto {

    private String userId;

    private String oldPassword;

    private String newPassword;

}
