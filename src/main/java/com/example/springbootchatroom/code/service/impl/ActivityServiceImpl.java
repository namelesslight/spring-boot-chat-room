package com.example.springbootchatroom.code.service.impl;

import com.example.springbootchatroom.code.entity.po.Activity;
import com.example.springbootchatroom.code.mapper.ActivityMapper;
import com.example.springbootchatroom.code.service.IActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 动态表 服务实现类
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements IActivityService {

}
