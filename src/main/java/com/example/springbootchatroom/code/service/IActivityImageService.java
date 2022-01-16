package com.example.springbootchatroom.code.service;

import com.example.springbootchatroom.code.entity.po.ActivityImage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 动态图片表 服务类
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
public interface IActivityImageService extends IService<ActivityImage> {

    /**
     * 添加图片
     * @param activityId 动态id
     * @param imageId 图片id
     * @return java.lang.Boolean
     */
    public Boolean addActivityImage(String activityId,String imageId);

    /**
     * 删除图片
     * @param activityId 动态id
     * @param imageId 图片id
     * @return java.lang.Boolean
     */
    public Boolean deleteImage(String activityId,String imageId);

    /**
     * 通过动态id获取图片
     * @param activityId 动态id
     * @return java.util.List
     */
    public List<String> listImageByActivity(String activityId);

}
