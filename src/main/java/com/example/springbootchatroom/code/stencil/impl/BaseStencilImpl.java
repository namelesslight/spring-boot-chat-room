package com.example.springbootchatroom.code.stencil.impl;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.example.springbootchatroom.code.exception.RegisterException;
import com.example.springbootchatroom.code.result.Result;
import com.example.springbootchatroom.code.service.*;
import com.example.springbootchatroom.code.stencil.BaseStencil;
import com.example.springbootchatroom.code.util.ImageUtil;
import com.example.springbootchatroom.code.util.JWTUtil;
import com.example.springbootchatroom.code.util.SecretUtil;
import com.example.springbootchatroom.code.util.UUIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
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

    @Resource
    private IUserPermissionService userPermissionService;

    @Resource
    private IUserRoleService userRoleService;

    @Resource
    private IPermissionService permissionService;

    @Resource
    private IImageService imageService;

    /**
     * 注册
     * @param username 用户名
     * @param password 密码
     * @param image 头像图片路径
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    @Override
    @Transactional
    public Result register(String username, String password, String image,String url) {
        Map<String,Object> result = new HashMap<>();
        if (userService.queryCountByUsername(username)){
            result.put("info","username_repeat");
            return new Result().result200(result,url);
        }
        //获取不重复随机主键
        String id = UUIDUtil.getUUID();
        //密码加密
        String secretPassword = SecretUtil.secretString(password);
        Boolean insertUser = userService.insertUser(id,username,image);
        Boolean insertPassword = userPasswdService.insertUserPassword(id,secretPassword);
        Boolean addRole = userRoleService.addRole(id,"user");
        List<String> permissions = permissionService.listPermissionByRole("user");
        Boolean addPermission = true;
        for (String permission: permissions) {
            addPermission =  addPermission && userPermissionService.addPermission(id,permission);
        }
        if (insertUser && insertPassword && addRole && addPermission){
            result.put("info","register_success");
            return new Result().result200(result,url);
        } else {
            try{
                throw new RegisterException("register_fail");
            } catch (RegisterException e){
                e.printStackTrace();
            } finally {
                result.put("info","register_fail");
                return new Result().result200(result,url);
            }
        }
    }

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    @Override
    public Result login(String username, String password, String url) {
        Map<String,Object> result = new HashMap<>();
        String secretPassword = SecretUtil.secretString(password);
        if (userPasswdService.queryUserCount(username,secretPassword)){
            Map<String,String> tokenClaims = new HashMap<>();
            tokenClaims.put("username",username);
            tokenClaims.put("id",userService.queryOneUserByUsername(username).getId());
            String token = JWTUtil.createToken(tokenClaims);
            result.put("info","login_success");
            result.put("token",token);
        } else {
            result.put("info","login_fail");
        }
        return new Result().result200(result,url);
    }

    /**
     * 下载图片
     * @param imageFile 图片文件
     * @param imagePath 图片路径
     * @param imageName 图片名
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    @Override
    public Result imageDownload(MultipartFile imageFile, String imagePath, String imageName, String url){
        Map<String,Object> result = new HashMap<>();
        try {
            ImageUtil.downloadImage(imageFile, imagePath, imageName);
            String id = UUIDUtil.getUUID();
            String path = imagePath + imageName;
            Boolean addImage = imageService.addImage(id,imageName,path);
            if (addImage){
                result.put("info","add_image_success");
            } else {
                result.put("info","add_image_fail");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        result.put("info","add_image_fail");
        return new Result().result200(result,url);
    }

}
