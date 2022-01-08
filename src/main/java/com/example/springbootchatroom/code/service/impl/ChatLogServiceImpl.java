package com.example.springbootchatroom.code.service.impl;

import com.example.springbootchatroom.code.entity.po.ChatLog;
import com.example.springbootchatroom.code.mapper.ChatLogMapper;
import com.example.springbootchatroom.code.service.IChatLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 聊天记录表 服务实现类
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Service
public class ChatLogServiceImpl extends ServiceImpl<ChatLogMapper, ChatLog> implements IChatLogService {

}
