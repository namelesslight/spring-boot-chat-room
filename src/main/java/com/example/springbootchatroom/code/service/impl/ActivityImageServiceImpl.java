package com.example.springbootchatroom.code.service.impl;

import com.example.springbootchatroom.code.entity.po.ActivityImage;
import com.example.springbootchatroom.code.mapper.ActivityImageMapper;
import com.example.springbootchatroom.code.service.IActivityImageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 动态图片表 服务实现类
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Service
public class ActivityImageServiceImpl extends ServiceImpl<ActivityImageMapper, ActivityImage> implements IActivityImageService {

    @Resource
    private ActivityImageMapper activityImageMapper;

    /**
     * 添加图片
     * @param activityId 动态id
     * @param imageId 图片id
     * @return java.lang.Boolean
     */
    @Override
    public Boolean addActivityImage(String activityId, String imageId) {
        return activityImageMapper.addActivityImage(activityId, imageId) == 1;
    }

    /**
     * 删除图片
     * @param activityId 动态id
     * @param imageId 图片id
     * @return java.lang.Boolean
     */
    @Override
    public Boolean deleteImage(String activityId, String imageId) {
        return activityImageMapper.addActivityImage(activityId, imageId) == 1;
    }

    /**
     * 通过动态id获取图片
     * @param activityId 动态id
     * @return java.util.List
     */
    @Override
    public List<String> listImageByActivity(String activityId) {
        return activityImageMapper.listImageByActivity(activityId);
    }
}
