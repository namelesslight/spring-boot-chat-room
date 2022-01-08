package com.example.springbootchatroom.code.mapper;

import com.example.springbootchatroom.code.entity.bean.PageBean;
import com.example.springbootchatroom.code.entity.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 添加用户
     * @param id 用户id
     * @param username 用户名
     * @param path 用户头像图片路径路径
     * @return java.lang.Integer
     */
    public Integer insertUser(String id,String username,String path);

    /**
     * 通过用户id删除用户
     * @param id 用户id
     * @return java.lang.Integer
     */
    public Integer deleteUserById(String id);

    /**
     * 修改用户头像
     * @param id 用户id
     * @param path 用户头像图片路径路径
     * @return java.lang.Integer
     */
    public Integer updateUserImage(String id,String path);

    /**
     * 通过用户名查询用户数量
     * @param username 用户名
     * @return java.lang.Integer
     */
    public Integer queryCountByUsername(String username);

    /**
     * 通过id查询用户
     * @param id 用户id
     * @return com.example.springbootchatroom.code.entity.vo.User
     */
    public User queryOneUserById(String id);

    /**
     * 通过用户名查询用户
     * @param username 用户名
     * @return com.example.springbootchatroom.code.entity.vo.User
     */
    public User queryOneUserByUsername(String username);

    /**
     * 分页查询用户
     * @param start 开始查询的位置
     * @param size 查询个数
     * @return java.util.List
     */
    public PageBean<User> listUserByPage(Integer start, Integer size);

    /**
     * 查询所有未删除的用户总数
     * @return java.lang.Integer
     */
    public Integer queryTotalCount();

}
