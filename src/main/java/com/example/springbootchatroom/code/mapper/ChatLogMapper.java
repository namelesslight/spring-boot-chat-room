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

    /**
     * 添加聊天记录
     * @param logId
     * @param userId
     * @param path
     * @return
     */
    public Integer addLog(String logId,String userId,String path);

    /**
     * 通过用户id获取聊天记录路径
     * @return
     */
    public String getLogByUserId();
}
