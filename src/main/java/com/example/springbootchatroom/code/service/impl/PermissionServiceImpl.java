package com.example.springbootchatroom.code.service.impl;

import com.example.springbootchatroom.code.entity.po.Permission;
import com.example.springbootchatroom.code.mapper.PermissionMapper;
import com.example.springbootchatroom.code.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
