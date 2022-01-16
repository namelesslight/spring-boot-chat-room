package com.example.springbootchatroom.code.service.impl;

import com.example.springbootchatroom.code.entity.bean.PageBean;
import com.example.springbootchatroom.code.entity.po.Activity;
import com.example.springbootchatroom.code.mapper.ActivityMapper;
import com.example.springbootchatroom.code.service.IActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 动态表 服务实现类
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements IActivityService {

    @Resource
    private ActivityMapper activityMapper;

    /**
     * 添加动态
     * @param activityId 动态id
     * @param content 动态内容
     * @param userId 用户id
     * @return
     */
    @Override
    public Boolean addActivity(String activityId, String content, String userId) {
        return activityMapper.addActivity(activityId, content, userId) == 1;
    }

    /**
     * 逻辑删除
     * @param activityId 动态id
     * @return java.lang.Boolean
     */
    @Override
    public Boolean logicalDeleteActivity(String activityId) {
        return activityMapper.logicalDeleteActivity(activityId) == 1;
    }

    /**
     * 物理删除
     * @param activityId 动态id
     * @return java.lang.Boolean
     */
    @Override
    public Boolean physicalDeleteActivity(String activityId) {
        return activityMapper.physicalDeleteActivity(activityId) == 1;
    }

    /**
     * 恢复动态
     * @param activityId 动态id
     * @return java.lang.Boolean
     */
    @Override
    public Boolean recoverActivity(String activityId) {
        return activityMapper.recoverActivity(activityId) == 1;
    }

    /**
     * 更新动态
     * @param activityId 动态id
     * @param content 动态内容
     * @return java.lang.Boolean
     */
    @Override
    public Boolean updateActivity(String activityId, String content) {
        return activityMapper.updateActivity(activityId, content) == 1;
    }

    /**
     * 通过用户id查询动态数量
     * @param userId 用户id
     * @return java.lang.Integer
     */
    @Override
    public Integer queryActivityCountByUser(String userId) {
        return activityMapper.queryActivityCountByUser(userId);
    }

    /**
     * 根据用户分页查询动态
     * @param userId 用户id
     * @param start 开始位置
     * @param size 获取数量
     * @return java.util.List
     */
    @Override
    public List<Activity> listActivityByUser(String userId, Integer start, Integer size) {
        return activityMapper.listActivityByUser(userId, start, size);
    }

    @Override
    public Integer queryDeleteActivityCountByUser(String userId) {
        return activityMapper.queryDeleteActivityCountByUser(userId);
    }

    /**
     * 跟据用户分页查询他逻辑删除的动态
     * @param userId 用户id
     * @param start 开始位置
     * @param size 获取数量
     * @return java.util.List
     */
    @Override
    public List<Activity> listDeleteActivityByUser(String userId, Integer start, Integer size) {
        return activityMapper.listDeleteActivityByUser(userId, start, size);
    }

    @Override
    public Integer queryAllActivityCount() {
        return activityMapper.queryAllActivityCount();
    }

    /**
     * 根据时间顺序来分页查询查询动态
     * @param start 开始位置
     * @param size 获取数量
     * @return java.util.List
     */
    @Override
    public List<Activity> listActivityByTime(Integer start, Integer size) {
        return activityMapper.listActivityByTime(start, size);
    }
}
