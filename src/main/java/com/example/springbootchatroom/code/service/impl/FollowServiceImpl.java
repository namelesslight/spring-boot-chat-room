package com.example.springbootchatroom.code.service.impl;

import com.example.springbootchatroom.code.entity.po.Follow;
import com.example.springbootchatroom.code.mapper.FollowMapper;
import com.example.springbootchatroom.code.service.IFollowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 关注表 服务实现类
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow> implements IFollowService {

}