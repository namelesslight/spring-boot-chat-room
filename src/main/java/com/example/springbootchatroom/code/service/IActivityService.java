package com.example.springbootchatroom.code.service;

import com.example.springbootchatroom.code.entity.bean.PageBean;
import com.example.springbootchatroom.code.entity.po.Activity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 动态表 服务类
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
public interface IActivityService extends IService<Activity> {
    /**
     * 添加动态
     * @param activityId 动态id
     * @param content 动态内容
     * @param userId 用户id
     * @return java.lang.Boolean
     */
    public Boolean addActivity(String activityId, String content, String userId);

    /**
     * 逻辑删除动态
     * @param activityId 动态id
     * @return java.lang.Boolean
     */
    public Boolean logicalDeleteActivity(String activityId);

    /**
     * 物理删除动态
     * @param activityId 动态id
     * @return java.lang.Boolean
     */
    public Boolean physicalDeleteActivity(String activityId);

    /**
     * 恢复动态
     * @param activityId 动态id
     * @return java.lang.Boolean
     */
    public Boolean recoverActivity(String activityId);

    /**
     * 更新动态
     * @param activityId 动态id
     * @param content 动态内容
     * @return java.lang.Boolean
     */
    public Boolean updateActivity(String activityId, String content);

    /**
     * 通过用户id查询动态数量
     * @param userId 用户id
     * @return java.lang.Integer
     */
    public Integer queryActivityCountByUser(String userId);

    /**
     * 通过用户获取动态
     * @param userId 用户id
     * @param start 开始位置
     * @param size 获取数量
     * @return java.util.List
     */
    public List<Activity> listActivityByUser(String userId, Integer start, Integer size);

    /**
     * 通过用户id查询删除动态数量
     * @param userId 用户id
     * @return java.lang.Integer
     */
    public Integer queryDeleteActivityCountByUser(String userId);

    /**
     * 通过用户获取已删除的动态，用做垃圾箱，垃圾箱内可修改动态或彻底删除动态
     * @param userId 用户id
     * @param start 开始位置
     * @param size 获取数量
     * @return java.util.List
     */
    public List<Activity> listDeleteActivityByUser(String userId, Integer start, Integer size);

    /**
     * 查询所有未删除的动态
     * @return java.lang.Integer
     */
    public Integer queryAllActivityCount();

    /**
     * 首页获取动态，信息根据时间排序
     * @param start 开始位置
     * @param size 获取数量
     * @return java.util.List
     */
    public List<Activity> listActivityByTime(Integer start, Integer size);
}
