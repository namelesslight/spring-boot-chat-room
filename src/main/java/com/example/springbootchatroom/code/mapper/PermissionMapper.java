package com.example.springbootchatroom.code.mapper;

import com.example.springbootchatroom.code.entity.po.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 通过角色获取权限
     * @param role 权限名
     * @return java.util.List
     */
    public List<String> listPermissionByRole(String role);
}
