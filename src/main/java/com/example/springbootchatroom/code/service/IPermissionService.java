package com.example.springbootchatroom.code.service;

import com.example.springbootchatroom.code.entity.po.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
public interface IPermissionService extends IService<Permission> {
    /**
     * 通过角色获取权限
     * @param role 权限名
     * @return java.util.List
     */
    public List<String> listPermissionByRole(String role);
}
