package com.example.springbootchatroom.code.stencil.impl;

import com.example.springbootchatroom.code.entity.bean.PageBean;
import com.example.springbootchatroom.code.entity.po.Activity;
import com.example.springbootchatroom.code.entity.po.Image;
import com.example.springbootchatroom.code.entity.po.User;
import com.example.springbootchatroom.code.result.Result;
import com.example.springbootchatroom.code.service.*;
import com.example.springbootchatroom.code.stencil.UserStencil;
import com.example.springbootchatroom.code.util.ImageUtil;
import com.example.springbootchatroom.code.util.JWTUtil;
import com.example.springbootchatroom.code.util.UUIDUtil;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户模板实现类
 */
@Service
public class UserStencilImpl implements UserStencil {

    @Resource
    private IUserService userService;

    @Resource
    private IUserPasswdService userPasswdService;

    @Resource IImageService imageService;

    @Resource
    private IActivityService activityService;

    @Resource
    private IActivityImageService activityImageService;

    @Resource
    private IFollowService followService;

    /**
     * 修改密码
     * @param token 验证token
     * @param userId 用户id
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    @Override
    public Result updateUserPassword(String token, String userId, String oldPassword, String newPassword, String url) {
        Map<String,Object> result = new HashMap<>();
        if (JWTUtil.verify(token)){
            String tokenId = JWTUtil.getString("token","id");
            if (tokenId.equals(userId)){
                if (userPasswdService.queryUserCountById(userId,oldPassword)){
                    if (userPasswdService.updateUserPassword(userId,newPassword)){
                        result.put("info","update_password_success");
                    } else {
                        result.put("info","update_password_fail");
                    }
                }  else {
                    result.put("info","update_old_password_error");
                }
            } else {
                result.put("info","no_permission");
            }
        } else {
            result.put("info","verify_error");

        }
        return new Result().result200(result,url);
    }

    /**
     * 更新头像
     * @param token 验证token
     * @param imageFile 图片文件
     * @param userId 用户id
     * @param imagePath 图片路径
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    @Override
    public Result updateHeadImage(String token, MultipartFile imageFile, String userId, String imagePath, String url) {
        Map<String,Object> result = new HashMap<>();
        if (JWTUtil.verify(token)){
            String tokenId = JWTUtil.getString("token","id");
            if (tokenId.equals(userId)){
                try {
                    ImageUtil.downloadImage(imageFile,imagePath,userId);
                    result.put("info","download_success");
                } catch (IOException e) {
                    result.put("info","download_error");
                }
            } else {
                result.put("info","no_permission");
            }
        } else {
            result.put("info","verify_error");

        }
        return new Result().result200(result,url);
    }

    /**
     * 添加动态
     * @param token 验证token
     * @param content 内容
     * @param userId 用户名
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    @Override
    public Result addActivity(String token, String content, String userId, String url) {
        Map<String,Object> result = new HashMap<>();
        if (JWTUtil.verify(token)){
            String tokenId = JWTUtil.getString("token","id");
            if (tokenId.equals(userId)){
                String activityId = UUIDUtil.getUUID();
                Boolean addActivity = activityService.addActivity(activityId,content,userId);
                if (addActivity){
                    result.put("info","add_activity_success");
                } else {
                    result.put("info","add_activity_fail");
                }
            } else {
                result.put("info","no_permission");
            }
        } else {
            result.put("info","verify_error");

        }
        return new Result().result200(result,url);
    }

    /**
     * 添加动态图片
     * @param token 验证token
     * @param activityId id编号
     * @param imagePath 图片id
     * @param userId 用户id
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    @Override
    public Result addActivityImage(String token,MultipartFile imageFile, String activityId, String imagePath, String userId, String url) {
        Map<String,Object> result = new HashMap<>();
        if (JWTUtil.verify(token)){
            String tokenId = JWTUtil.getString("token","id");
            if (tokenId.equals(userId)){
                String imageId = UUIDUtil.getUUID();
                String path = imagePath + "/" + activityId;
                try {
                    ImageUtil.downloadImage(imageFile,path,imageId);
                    imageService.addImage(imageId,imageId + ".jpg", path + "/" + imageId + ".jpg");
                    activityImageService.addActivityImage(activityId,imageId);
                    result.put("info","image_add_success");
                } catch (IOException e) {
                    result.put("info","image_add_fail");
                }
            } else {
                result.put("info","no_permission");
            }
        } else {
            result.put("info","verify_error");

        }
        return new Result().result200(result,url);
    }

    /**
     * 删除动态图片
     * @param token 验证token
     * @param userId 用户id
     * @param activityId 动态id
     * @param imageId 图片id
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    @Transactional
    @Override
    public Result deleteImage(String token, String userId, String activityId, String imageId, String url) {
        Map<String,Object> result = new HashMap<>();
        if (JWTUtil.verify(token)){
            String tokenId = JWTUtil.getString("token","id");
            if (tokenId.equals(userId)){
                Boolean deleteActivityImage = activityImageService.deleteImage(activityId,imageId);
                Boolean deleteImage = imageService.deleteImage(imageId);
                if (deleteActivityImage && deleteImage){
                    result.put("info","delete_image_success");
                } else {
                    result.put("info","delete_image_fail");
                }
            } else {
                result.put("info","no_permission");
            }
        } else {
            result.put("info","verify_error");
        }
        return new Result().result200(result,url);
    }

    /**
     * 通过动态获取图片
     * @param token 验证token
     * @param activityId 动态id
     * @param url 图片id
     * @return com.example.springbootchatroom.code.result.Result
     */
    @Override
    public Result listImageByActivity(String token, String activityId, String url) {
        Map<String,Object> result = new HashMap<>();
        if (JWTUtil.verify(token)){
            List<String > list = activityImageService.listImageByActivity(activityId);
            result.put("info",list);
        } else {
            result.put("info","verify_error");
        }
        return new Result().result200(result,url);
    }

    /**
     * 逻辑删除动态
     * @param token 验证token
     * @param userId 用户id
     * @param activityId 动态id
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    @Override
    public Result logicalDeleteActivity(String token, String userId, String activityId, String url) {
        Map<String,Object> result = new HashMap<>();
        if (JWTUtil.verify(token)){
            String tokenId = JWTUtil.getString("token","id");
            if (tokenId.equals(userId)){
                Boolean logicalDeleteActivity = activityService.logicalDeleteActivity(activityId);
                if (logicalDeleteActivity){
                    result.put("info","logical_delete_activity_success");
                } else {
                    result.put("info","logical_delete_activity_fail");
                }
            } else {
                result.put("info","no_permission");
            }
        } else {
            result.put("info","verify_error");
        }
        return new Result().result200(result,url);
    }

    /**
     * 物理删除
     * @param token 验证token
     * @param userId 用户id
     * @param activityId 动态id
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    @Override
    public Result physicalDeleteActivity(String token, String userId, String activityId, String url) {
        Map<String,Object> result = new HashMap<>();
        if (JWTUtil.verify(token)){
            String tokenId = JWTUtil.getString("token","id");
            if (tokenId.equals(userId)){
                Boolean physicalDeleteActivity = activityService.physicalDeleteActivity(activityId);
                if (physicalDeleteActivity){
                    result.put("info","physical_delete_activity_success");
                } else {
                    result.put("info","physical_delete_activity_fail");
                }
            } else {
                result.put("info","no_permission");
            }
        } else {
            result.put("info","verify_error");
        }
        return new Result().result200(result,url);
    }

    /**
     * 恢复动态
     * @param token 验证token
     * @param userId 用户id
     * @param activityId 动态id
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    @Override
    public Result recoverActivity(String token,String userId,  String activityId, String url) {
        Map<String,Object> result = new HashMap<>();
        if (JWTUtil.verify(token)){
            String tokenId = JWTUtil.getString("token","id");
            if (tokenId.equals(userId)){
                Boolean recoverActivity = activityService.recoverActivity(activityId);
                if (recoverActivity){
                    result.put("info","recover_activity_success");
                } else {
                    result.put("info","recover_activity_fail");
                }
            } else {
                result.put("info","no_permission");
            }
        } else {
            result.put("info","verify_error");
        }
        return new Result().result200(result,url);
    }

    /**
     * 根据用户名分页该用户已删除的动态
     * @param token 验证token
     * @param userId 用户id
     * @param currentPage 页数
     * @param size 查询数量
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    @Override
    public Result listDeleteActivityByUser(String token, String userId, Integer currentPage, Integer size, String url) {
        Map<String,Object> result = new HashMap<>();
        if (JWTUtil.verify(token)){
            String tokenId = JWTUtil.getString("token","id");
            if (tokenId.equals(userId)){
                Integer totalCount = activityService.queryDeleteActivityCountByUser(userId);
                Integer totalPage = PageBean.getTotalPage(size,totalCount);
                Integer start = (currentPage - 1) * size;
                List<Activity> activities = activityService.listDeleteActivityByUser(userId,start,size);
                PageBean<Activity> activityPageBean = new PageBean<>(totalCount, currentPage, totalPage, size, activities);
                result.put("info",activityPageBean);
            } else {
                result.put("info","no_permission");
            }
        } else {
            result.put("info","verify_error");
        }
        return new Result().result200(result,url);
    }

    /**
     * 添加关注
     * @param token 验证token
     * @param userId 用户id
     * @param followerId 关注该用户的人的id
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    @Override
    public Result addFollow(String token, String userId, String followerId, String url) {
        Map<String,Object> result = new HashMap<>();
        if (JWTUtil.verify(token)){
            String tokenId = JWTUtil.getString("token","id");
            if (tokenId.equals(followerId)){
              String followId = UUIDUtil.getUUID();
              Boolean addFollow = followService.addFollow(followId, userId, followerId);
              if (addFollow){
                  result.put("info","add_follow_success");
              } else {
                  result.put("info","add_follow_fail");
              }
            } else {
                result.put("info","no_permission");
            }
        } else {
            result.put("info","verify_error");
        }
        return new Result().result200(result,url);
    }

    /**
     * 取消关注
     * @param token 验证token
     * @param userId 用户id
     * @param followerId 关注该用户的人的id
     * @param url url路径
     * @return com.example.springbootchatroom.code.result.Result
     */
    @Override
    public Result deleteFollow(String token, String userId, String followerId, String url) {
        Map<String,Object> result = new HashMap<>();
        if (JWTUtil.verify(token)){
            String tokenId = JWTUtil.getString("token","id");
            if (tokenId.equals(followerId)){
                String followId = UUIDUtil.getUUID();
                Boolean deleteFollow = followService.deleteFollow(userId, followerId);
                if (deleteFollow){
                    result.put("info","delete_follow_success");
                } else {
                    result.put("info","delete_follow_fail");
                }
            } else {
                result.put("info","no_permission");
            }
        } else {
            result.put("info","verify_error");
        }
        return new Result().result200(result,url);
    }

}
