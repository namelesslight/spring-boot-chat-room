package com.example.springbootchatroom.code.stencil;

import com.example.springbootchatroom.code.result.Result;

/**
 * 基础通用模板接口
 * @author ZCL
 * @since 2022/1/8
 */
public interface BaseStencil {

    /**
     * 注册
     * @param username 用户名
     * @param password 密码
     * @param image 头像图片路径
     * @param path url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    public Result register(String username, String password,String image,String path);

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @param path url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    public Result login(String username,String password, String path);
}
