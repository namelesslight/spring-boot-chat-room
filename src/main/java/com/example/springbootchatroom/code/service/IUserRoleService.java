package com.example.springbootchatroom.code.service;

import com.example.springbootchatroom.code.entity.po.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
public interface IUserRoleService extends IService<UserRole> {
    /**
     * 添加用户角色
     * @param userId 用户id
     * @param role 用户角色
     * @return java.lang.Boolean
     */
    public Boolean addRole(String userId,String role);

    /**
     * 删除用户角色
     * @param userId 用户id
     * @param role 角色
     * @return java.lang.Boolean
     */
    public Boolean deleteRole(String userId,String role);

    /**
     * 恢复用户角色
     * @param userId 用户id
     * @param role 角色
     * @return java.lang.Boolean
     */
    public Boolean recoverRole(String userId,String role);

    /**
     * 根据用户id获取用户校色
     * @param userId 用户id
     * @return java.util.List
     */
    public List<String> listRoleByUserId(String userId);
}
