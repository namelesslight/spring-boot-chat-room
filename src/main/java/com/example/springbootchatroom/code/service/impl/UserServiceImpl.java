package com.example.springbootchatroom.code.service.impl;

import com.example.springbootchatroom.code.entity.bean.PageBean;
import com.example.springbootchatroom.code.entity.po.User;
import com.example.springbootchatroom.code.mapper.UserMapper;
import com.example.springbootchatroom.code.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 添加用户
     * @param id 用户id
     * @param username 用户名
     * @param path 用户头像图片路径路径
     * @return java.lang.Boolean
     */
    @Override
    public Boolean insertUser(String id, String username, String path) {
        return userMapper.insertUser(id,username,path) == 1;
    }

    /**
     * 通过用户id删除用户
     * @param id 用户id
     * @return java.lang.Boolean
     */
    @Override
    public Boolean deleteUserById(String id) {
        return userMapper.deleteUserById(id) == 1;
    }

    /**
     * 修改用户头像
     * @param id 用户id
     * @param path 用户头像图片路径路径
     * @return java.lang.Boolean
     */
    @Override
    public Boolean updateUserImage(String id, String path) {
        return userMapper.updateUserImage(id,path) == 1;
    }

    /**
     * 通过用户名查询用户数量
     * @param username 用户名
     * @return java.lang.Boolean
     */
    @Override
    public Boolean queryCountByUsername(String username) {
        return userMapper.queryCountByUsername(username) == 1;
    }

    /**
     * 通过id查询用户
     * @param id 用户id
     * @return com.example.springbootchatroom.code.entity.vo.User
     */
    @Override
    public User queryOneUserById(String id) {
        return userMapper.queryOneUserById(id);
    }

    /**
     * 通过用户名查询用户
     * @param username 用户名
     * @return com.example.springbootchatroom.code.entity.vo.User
     */
    @Override
    public User queryOneUserByUsername(String username) {
        return userMapper.queryOneUserByUsername(username);
    }

    /**
     * 分页查询用户
     * @param start 开始查询的位置
     * @param size 查询个数
     * @return java.util.List
     */
    @Override
    public PageBean<User> listUserByPage(Integer start, Integer size) {
        return userMapper.listUserByPage(start,size);
    }

    /**
     * 查询所有未删除的用户总数
     * @return java.lang.Integer
     */
    @Override
    public Integer queryTotalCount() {
        return userMapper.queryTotalCount();
    }
}
