package com.example.springbootchatroom.code.service;

import com.example.springbootchatroom.code.entity.po.UserPermission;
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
public interface IUserPermissionService extends IService<UserPermission> {
    /**
     * 添加权限
     * @param userId 用户id
     * @param permission 用户权限
     * @return java.lang.Boolean
     */
    public Boolean addPermission(String userId, String permission);

    /**
     * 删除权限
     * @param userId 用户id
     * @param permission 用户权限
     * @return java.lang.Boolean
     */
    public Boolean deletePermission(String userId, String permission);

    /**
     * 恢复权限
     * @param userId 用户id
     * @param permission 用户权限
     * @return java.lang.Boolean
     */
    public Boolean recoverPermission(String userId,String permission);

    /**
     * 通过用户id获取权限
     * @param userId 用户id
     * @return java.util.List
     */
    public List<String> listPermissionByUserId(String userId);
}
