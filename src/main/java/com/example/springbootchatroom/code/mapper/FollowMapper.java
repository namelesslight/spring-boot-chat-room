package com.example.springbootchatroom.code.mapper;

import com.example.springbootchatroom.code.entity.po.Follow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootchatroom.code.entity.po.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 关注表 Mapper 接口
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Repository
public interface FollowMapper extends BaseMapper<Follow> {


    /**
     * 添加关注
     * @param followId 关注编号
     * @param userId 要关注的人的id
     * @param followerId 关注者的id
     * @return java.lang.Integer
     */
    public Integer addFollow(String followId,String userId,String followerId);

    /**
     * 取消关注
     * @param userId 用户id
     * @param followerId 正在关注的人的id
     * @return java.lang.Integer
     */
    public Integer deleteFollow(String userId,String followerId);

    /**
     * 根据用户的id查询关注他的人的人数
     * @param userId 用户id
     * @return java.lang.Integer
     */
    public Integer queryFollowerCountByUserId(String userId);

    /**
     * 根据用户的id查询关注他的人
     * @param userId 用户id
     * @return java.util.List
     */
    public List<User> listFollower(String userId);

    /**
     * 根据用户id查询他关注的人的人数
     * @param userId 用户id
     * @return java.lang.Integer
     */
    public Integer queryFollowingCountByUserId(String userId);

    /**
     * 根据用户id查询他关注的人
     * @param userId 用户id
     * @return java.util.List
     */
    public List<User> listFollowing(String userId);
}
