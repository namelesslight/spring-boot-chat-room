package com.example.springbootchatroom.code.entity.vo;

import com.example.springbootchatroom.code.entity.po.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 有关用户及其权限的相关信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    /**
     * 用户信息
     */
    private User user;

    /**
     * 用户角色
     */
    private List<String> role;

    /**
     * 用户权限
     */
    private List<String> userPermissions;
}
