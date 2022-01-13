package com.example.springbootchatroom.code.mapper;

import com.example.springbootchatroom.code.entity.po.ActivityImage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 动态图片表 Mapper 接口
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Repository
public interface ActivityImageMapper extends BaseMapper<ActivityImage> {

    /**
     * 添加图片
     * @param activityId 动态id
     * @param imageId 图片id
     * @return java.lang.Integer
     */
    public Integer addActivityImage(String activityId,String imageId);

    /**
     * 删除图片
     * @param activityId 动态id
     * @param imageId 图片id
     * @return java.lang.Integer
     */
    public Integer deleteImage(String activityId,String imageId);

    /**
     * 通过动态id获取图片
     * @param activityId 动态id
     * @return java.util.List
     */
    public List<String> listImageByActivity(String activityId);
}
