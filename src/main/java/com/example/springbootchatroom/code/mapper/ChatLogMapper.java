package com.example.springbootchatroom.code.mapper;

import com.example.springbootchatroom.code.entity.po.ChatLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 聊天记录表 Mapper 接口
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Repository
public interface ChatLogMapper extends BaseMapper<ChatLog> {

}
