package com.example.springbootchatroom.code.service.impl;

import com.example.springbootchatroom.code.entity.po.UserPasswd;
import com.example.springbootchatroom.code.mapper.UserPasswdMapper;
import com.example.springbootchatroom.code.service.IUserPasswdService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户密码表 服务实现类
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Service
public class UserPasswdServiceImpl extends ServiceImpl<UserPasswdMapper, UserPasswd> implements IUserPasswdService {

    @Resource
    private UserPasswdMapper userPasswdMapper;

    /**
     * 添加用户和密码
     * @param id 用户id
     * @param password 用户密码
     * @return java.lang.Boolean
     */
    @Override
    public Boolean insertUserPassword(String id, String password) {
        return userPasswdMapper.insertUserPassword(id,password) == 1;
    }

    /**
     * 修改用户密码
     * @param id 用户id
     * @param newPassword 用户新密码
     * @return java.lang.Boolean
     */
    @Override
    public Boolean updateUserPassword(String id, String newPassword) {
        return userPasswdMapper.updateUserPassword(id,newPassword) == 1;
    }

    /**
     * 通过用户名和密码查询是否有
     * @param username 用户名
     * @param password 密码
     * @return java.lang.Boolean
     */
    @Override
    public Boolean queryUserCount(String username, String password) {
        return userPasswdMapper.queryUserCount(username,password) == 1;
    }

    /**
     * 根据用户id和密码查询用户
     * @param id 用户名
     * @param password 密码
     * @return java.lang.Boolean
     */
    @Override
    public Boolean queryUserCountById(String id, String password) {
        return userPasswdMapper.queryUserCountById(id, password) == 1;
    }
}
