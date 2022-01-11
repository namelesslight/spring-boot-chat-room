package com.example.springbootchatroom.code.mapper;

import com.example.springbootchatroom.code.entity.po.UserRole;
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
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 添加用户角色
     * @param userId 用户id
     * @param role 用户角色
     * @return java.lang.Integer
     */
    public Integer addRole(String userId,String role);

    /**
     * 删除用户角色
     * @param userId 用户id
     * @param role 角色
     * @return java.lang.Integer
     */
    public Integer deleteRole(String userId,String role);

    /**
     * 恢复用户角色
     * @param userId 用户id
     * @param role 角色
     * @return java.lang.Integer
     */
    public Integer recoverRole(String userId,String role);

    /**
     * 根据用户id获取用户校色
     * @param userId 用户id
     * @return java.util.List
     */
    public List<String> listRoleByUserId(String userId);

}
