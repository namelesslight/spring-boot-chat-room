package com.example.springbootchatroom.code.stencil.impl;

import com.example.springbootchatroom.code.result.Result;
import com.example.springbootchatroom.code.service.IUserPasswdService;
import com.example.springbootchatroom.code.service.IUserService;
import com.example.springbootchatroom.code.stencil.BaseStencil;
import com.example.springbootchatroom.code.util.JWTUtil;
import com.example.springbootchatroom.code.util.SecretUtil;
import com.example.springbootchatroom.code.util.UUIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 基础通用模板实体类
 * @author ZCL
 * @since 2022/1/8
 */
@Service
public class BaseStencilImpl implements BaseStencil {

    @Resource
    private IUserService userService;

    @Resource
    private IUserPasswdService userPasswdService;


    /**
     * 注册
     * @param username 用户名
     * @param password 密码
     * @param image 头像图片路径
     * @param path url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    @Override
    @Transactional
    public Result register(String username, String password, String image,String path) {
        Map<String,Object> result = new HashMap<>();
        if (userService.queryCountByUsername(username)){
            result.put("info","username_repeat");
            return new Result().result200(result,path);
        }
        //获取不重复随机主键
        String id = UUIDUtil.getUUID();
        //密码加密
        String secretPassword = SecretUtil.secretString(password);
        Boolean insertUser = userService.insertUser(id,username,image);
        Boolean insertPassword = userPasswdService.insertUserPassword(id,secretPassword);
        if (insertUser && insertPassword){
            result.put("info","register_success");
            return new Result().result200(result,path);
        }
        result.put("info","register_fail");
        return new Result().result200(result,path);
    }

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @param path url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    @Override
    public Result login(String username, String password, String path) {
        Map<String,Object> result = new HashMap<>();
        String secretPassword = SecretUtil.secretString(password);
        if (userPasswdService.queryUserCount(username,secretPassword)){
            Map<String,String> tokenClaims = new HashMap<>();
            tokenClaims.put("username",username);
            tokenClaims.put("id",userService.queryOneUserByUsername(username).getId());
            String token = JWTUtil.createToken(tokenClaims);
            result.put("info","login_success");
            result.put("token",token);
            return new Result().result200(result,path);
        }
        result.put("info","login_fail");
        return new Result().result200(result,path);
    }
}
