package com.example.springbootchatroom.code.service.impl;

import com.example.springbootchatroom.code.entity.po.Role;
import com.example.springbootchatroom.code.mapper.RoleMapper;
import com.example.springbootchatroom.code.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
