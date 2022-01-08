package com.example.springbootchatroom.code.entity.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 聊天记录表
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ChatLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 聊天记录编号
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 聊天记录对应用户编号
     */
    private String user;

    /**
     * 聊天记录对应的路径
     */
    private String path;

    /**
     * 逻辑删除
     */
    private Boolean isDelete;


}
