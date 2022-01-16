package com.example.springbootchatroom.code.service.impl;

import com.example.springbootchatroom.code.entity.po.Follow;
import com.example.springbootchatroom.code.entity.po.User;
import com.example.springbootchatroom.code.mapper.FollowMapper;
import com.example.springbootchatroom.code.service.IFollowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 关注表 服务实现类
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow> implements IFollowService {

    @Resource
    private FollowMapper followMapper;

    /**
     * 添加关注
     * @param followId 关注编号
     * @param userId 要关注的人的id
     * @param followerId 关注者的id
     * @return java.lang.Boolean
     */
    @Override
    public Boolean addFollow(String followId, String userId, String followerId) {
        return followMapper.addFollow(followId,userId,followerId) == 1;
    }

    /**
     * 取消关注
     * @param userId 用户id
     * @param followerId 正在关注的人的id
     * @return java.lang.Boolean
     */
    @Override
    public Boolean deleteFollow(String userId, String followerId) {
        return followMapper.deleteFollow(userId, followerId) == 1;
    }

    /**
     * 根据用户的id查询关注他的人的人数
     * @param userId 用户id
     * @return java.lang.Integer
     */
    @Override
    public Integer queryFollowerCountByUserId(String userId) {
        return followMapper.queryFollowerCountByUserId(userId);
    }

    /**
     * 根据用户的id查询关注他的人
     * @param userId 用户id
     * @return java.util.List
     */
    @Override
    public List<User> listFollower(String userId) {
        return followMapper.listFollower(userId);
    }

    /**
     * 根据用户id查询他关注的人的人数
     * @param userId 用户id
     * @return java.lang.Integer
     */
    @Override
    public Integer queryFollowingCountByUserId(String userId) {
        return followMapper.queryFollowingCountByUserId(userId);
    }

    /**
     * 根据用户id查询他关注的人
     * @param userId 用户id
     * @return java.util.List
     */
    @Override
    public List<User> listFollowing(String userId) {
        return followMapper.listFollowing(userId);
    }
}
