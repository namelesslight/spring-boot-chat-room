package com.example.springbootchatroom.code.stencil;

import com.example.springbootchatroom.code.result.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    public Result register(String username, String password,String image,String url);

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    public Result login(String username,String password, String url);


    /**
     * 下载图片
     * @param imageFile 图片文件
     * @param imagePath 图片路径
     * @param imageName 图片名
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    public Result imageDownload(MultipartFile imageFile,String imagePath,String imageName,String url);
}
