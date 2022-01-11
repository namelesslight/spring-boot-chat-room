package com.example.springbootchatroom.code.service.impl;

import com.example.springbootchatroom.code.entity.po.UserPermission;
import com.example.springbootchatroom.code.mapper.UserPermissionMapper;
import com.example.springbootchatroom.code.service.IUserPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Service
public class UserPermissionServiceImpl extends ServiceImpl<UserPermissionMapper, UserPermission> implements IUserPermissionService {

    @Resource
    private UserPermissionMapper userPermissionMapper;

    /**
     * 添加权限
     * @param userId 用户id
     * @param permission 用户权限
     * @return java.lang.Boolean
     */
    @Override
    public Boolean addPermission(String userId, String permission) {
        return userPermissionMapper.addPermission(userId,permission) == 1;
    }

    /**
     * 删除权限
     * @param userId 用户id
     * @param permission 用户权限
     * @return java.lang.Boolean
     */
    @Override
    public Boolean deletePermission(String userId, String permission) {
        return userPermissionMapper.deletePermission(userId,permission) == 1;
    }

    /**
     * 修改权限
     * @param userId 用户id
     * @param permission 用户权限
     * @return java.lang.Boolean
     */
    @Override
    public Boolean recoverPermission(String userId, String permission) {
        return userPermissionMapper.recoverPermission(userId,permission) == 1;
    }

    /**
     * 获取用户全部权限
     * @param userId 用户id
     * @return java.util.List
     */
    @Override
    public List<String> listPermissionByUserId(String userId) {
        return userPermissionMapper.listPermissionByUserId(userId);
    }

}
