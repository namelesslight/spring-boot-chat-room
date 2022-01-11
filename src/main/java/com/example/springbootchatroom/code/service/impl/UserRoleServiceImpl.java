package com.example.springbootchatroom.code.service.impl;

import com.example.springbootchatroom.code.entity.po.UserRole;
import com.example.springbootchatroom.code.mapper.UserRoleMapper;
import com.example.springbootchatroom.code.service.IUserRoleService;
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
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

    /**
     * 添加角色
     * @param userId 用户id
     * @param role 用户角色
     * @return java.lang.Boolean
     */
    @Override
    public Boolean addRole(String userId, String role) {
        return userRoleMapper.addRole(userId,role) == 1;
    }

    /**
     * 删除角色
     * @param userId 用户id
     * @param role 角色
     * @return java.lang.Boolean
     */
    @Override
    public Boolean deleteRole(String userId, String role) {
        return userRoleMapper.deleteRole(userId, role) == 1;
    }

    /**
     * 恢复角色
     * @param userId 用户id
     * @param role 角色
     * @return java.lang.Boolean
     */
    @Override
    public Boolean recoverRole(String userId, String role) {
        return userRoleMapper.recoverRole(userId, role) == 1;
    }

    /**
     * 根据用户id获取全部角色
     * @param userId 用户id
     * @return java.lang.List
     */
    @Override
    public List<String> listRoleByUserId(String userId) {
        return userRoleMapper.listRoleByUserId(userId);
    }
}
