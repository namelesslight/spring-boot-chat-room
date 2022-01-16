package com.example.springbootchatroom.code.mapper;

import com.example.springbootchatroom.code.entity.po.UserPasswd;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户密码表 Mapper 接口
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Repository
public interface UserPasswdMapper extends BaseMapper<UserPasswd> {

    /**
     * 添加用户和密码
     * @param id 用户id
     * @param password 用户密码
     * @return java.lang.Integer
     */
    public Integer insertUserPassword(String id,String password);

    /**
     * 修改用户密码
     * @param id 用户id
     * @param newPassword 用户新密码
     * @return java.lang.Integer
     */
    public Integer updateUserPassword(String id,String newPassword);

    /**
     * 通过用户名和密码查询用户
     * @param username 用户名
     * @param password 密码
     * @return java.lang.Integer
     */
    public Integer queryUserCount(String username,String password);


    /**
     * 根据用户id和密码查询用户
     * @param id 用户名
     * @param password 密码
     * @return java.lang.Integer
     */
    public Integer queryUserCountById(String id, String password);
}
