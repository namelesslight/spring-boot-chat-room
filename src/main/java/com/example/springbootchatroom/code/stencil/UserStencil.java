package com.example.springbootchatroom.code.stencil;

import com.example.springbootchatroom.code.result.Result;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 用户通用模板接口
 * @author ZCL
 * @since 2022/1/8
 */
public interface UserStencil {

    /**
     * 修改密码
     * @param token 验证token
     * @param userId 用户id
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    public Result updateUserPassword(String token, String userId, String oldPassword, String newPassword, String url);

    /**
     * 更新头像
     * @param token 验证token
     * @param imageFile 图片文件
     * @param userId 用户名
     * @param imagePath 图片路径
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    public Result updateHeadImage(String token, MultipartFile imageFile, String userId, String imagePath, String url);

    /**
     * 添加动态
     * @param token 验证token
     * @param content 内容
     * @param userId 用户名
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    public Result addActivity(String token, String content, String userId, String url);

    /**
     * 添加动态图片
     * @param token 验证token
     * @param imageFile 图片文件
     * @param activityId id编号
     * @param userId 用户id
     * @param imagePath 图片id
     * @param url url路径
     * @return
     */
    public Result addActivityImage(String token, MultipartFile imageFile, String activityId,String imagePath,String userId,String url);

    /**
     * 删除图片
     * @param token 验证token
     * @param activityId 动态id
     * @param userId 用户id
     * @param imageId 图片id
     * @return java.lang.Boolean
     */
    public Result deleteImage(String token,String userId, String activityId,String imageId, String url);

    /**
     * 通过动态id获取图片
     * @param token 验证token
     * @param activityId 动态id
     * @return java.util.List
     */
    public Result listImageByActivity(String token, String activityId, String url);

    /**
     * 逻辑删除动态
     * @param token 验证token
     * @param userId 用户id
     * @param activityId 动态id
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    public Result logicalDeleteActivity(String token, String userId, String activityId, String url);

    /**
     * 物理删除
     * @param token 验证token
     * @param userId 用户id
     * @param activityId 动态id
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    public Result physicalDeleteActivity(String token, String userId, String activityId, String url);

    /**
     * 恢复动态
     * @param token 验证token
     * @param userId 用户id
     * @param activityId 动态id
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    public Result recoverActivity(String token, String userId, String activityId, String url);

    /**
     * 根据用户名分页该用户已删除的动态
     * @param token 验证token
     * @param userId 用户id
     * @param currentPage 页数
     * @param size 查询数量
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    public Result listDeleteActivityByUser(String token, String userId, Integer currentPage, Integer size, String url);

    /**
     * 添加关注
     * @param token 验证token
     * @param userId 用户id
     * @param followerId 关注该用户的人的id
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    public Result addFollow(String token, String userId, String followerId, String url);

    /**
     * 取消关注
     * @param token 验证token
     * @param userId 用户id
     * @param followerId 关注该用户的人的id
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    public Result deleteFollow(String token, String userId,String followerId, String url);


}
