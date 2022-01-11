package com.example.springbootchatroom.code.mapper;

import com.example.springbootchatroom.code.entity.po.UserPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Repository
public interface UserPermissionMapper extends BaseMapper<UserPermission> {

    /**
     * 添加权限
     * @param userId 用户id
     * @param permission 用户权限
     * @return java.lang.Integer
     */
    public Integer addPermission(String userId, String permission);

    /**
     * 删除权限
     * @param userId 用户id
     * @param permission 用户权限
     * @return java.lang.Integer
     */
    public Integer deletePermission(String userId, String permission);

    /**
     * 恢复权限
     * @param userId 用户id
     * @param permission 用户权限
     * @return java.lang.Integer
     */
    public Integer recoverPermission(String userId,String permission);

    /**
     * 通过用户id获取权限
     * @param userId 用户id
     * @return java.util.List
     */
    public List<String> listPermissionByUserId(String userId);

}
