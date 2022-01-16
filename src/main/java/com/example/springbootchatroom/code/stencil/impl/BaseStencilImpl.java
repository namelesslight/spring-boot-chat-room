package com.example.springbootchatroom.code.stencil.impl;

import com.example.springbootchatroom.code.entity.bean.PageBean;
import com.example.springbootchatroom.code.entity.po.Activity;
import com.example.springbootchatroom.code.entity.po.User;
import com.example.springbootchatroom.code.entity.vo.UserInfo;
import com.example.springbootchatroom.code.exception.RegisterException;
import com.example.springbootchatroom.code.result.Result;
import com.example.springbootchatroom.code.service.*;
import com.example.springbootchatroom.code.stencil.BaseStencil;
import com.example.springbootchatroom.code.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 用户通用模板实体类
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

    @Resource
    private IActivityService activityService;

    @Resource
    private IFollowService followService;

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
            User user = userService.queryOneUserByUsername(username);
            List<String> roles = userRoleService.listRoleByUserId(user.getId());
            List<String> permissions = userPermissionService.listPermissionByUserId(user.getId());
            UserInfo userInfo = new UserInfo(user,roles,permissions);
            tokenClaims.put("username",username);
            tokenClaims.put("id",user.getId());
            String token = JWTUtil.createToken(tokenClaims);
            RedisUtil.save(token,userInfo,7L, TimeUnit.DAYS);
            result.put("info","login_success");
            result.put("userInfo",userInfo);
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

    /**
     * 通过用户查询动态
     * @param userId 用户id
     * @param currentPage 当前页数
     * @param size 查询数量
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    @Override
    public Result listActivityByUser(String userId, Integer currentPage, Integer size, String url) {
        Integer totalCount = activityService.queryActivityCountByUser(userId);
        Integer totalPage = PageBean.getTotalPage(size,totalCount);
        Integer start = (currentPage - 1) * size;
        List<Activity> activities = activityService.listActivityByUser(userId,start,size);
        PageBean<Activity> pageBean = new PageBean<>(totalCount, currentPage, totalPage, start, activities);
        Map<String,Object> result = new HashMap<>();
        result.put("result",pageBean);
        return new Result().result200(result, url);
    }

    /**
     * 通过时间查询动态
     * @param currentPage 当前页数
     * @param size 查询数量
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    @Override
    public Result listActivityByTime(Integer currentPage, Integer size, String url) {
        Integer totalCount = activityService.queryAllActivityCount();
        Integer totalPage = PageBean.getTotalPage(size,totalCount);
        Integer start = (currentPage - 1) * size;
        List<Activity> activities = activityService.listActivityByTime(start,size);
        PageBean<Activity> pageBean = new PageBean<>(totalCount, currentPage, totalPage, start, activities);
        Map<String,Object> result = new HashMap<>();
        result.put("result",pageBean);
        return new Result().result200(result, url);
    }

    /**
     * 查询关注该用户的人的数量
     * @param userId 用户id
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    @Override
    public Result queryFollowerCountByUserId(String userId, String url) {
        Map<String,Object> result = new HashMap<>();
        Integer followersCount = followService.queryFollowerCountByUserId(userId);
        Map<String ,Object> followersMap = new HashMap<>();
        followersMap.put("followersCount",followersCount);
        result.put("info",followersMap);
        return new Result().result200(result,url);
    }

    /**
     * 查询关注该用户的人
     * @param userId 用户id
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    @Override
    public Result listFollower(String userId, String url) {
        Map<String,Object> result = new HashMap<>();
        List<User> followers = followService.listFollower(userId);
        Map<String ,Object> followersMap = new HashMap<>();
        followersMap.put("followers",followers);
        result.put("info",followersMap);
        return new Result().result200(result,url);
    }

    /**
     * 查询该用户关注的人的人数
     * @param userId 用户id
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    @Override
    public Result queryFollowingCountByUserId(String userId, String url) {
        Map<String,Object> result = new HashMap<>();
        Integer followingCount = followService.queryFollowingCountByUserId(userId);
        Map<String ,Object> followingMap = new HashMap<>();
        followingMap.put("followingMap",followingCount);
        result.put("info",followingMap);
        return new Result().result200(result,url);
    }

    /**
     * 查询该用户关注的人
     * @param userId 用户id
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    @Override
    public Result listFollowing(String userId, String url) {
        Map<String,Object> result = new HashMap<>();
        List<User> following = followService.listFollowing(userId);
        Map<String ,Object> followingMap = new HashMap<>();
        followingMap.put("followers",following);
        result.put("info",followingMap);
        return new Result().result200(result,url);
    }
}
