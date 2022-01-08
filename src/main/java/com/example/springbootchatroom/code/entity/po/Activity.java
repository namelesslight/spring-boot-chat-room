package com.example.springbootchatroom.code.entity.po;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 动态表
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 活动编号
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 动态内容
     */
    private String content;

    /**
     * 动态用户编号
     */
    private String user;

    /**
     * 动态发送日期
     */
    private LocalDateTime sendDate;

    /**
     * 逻辑删除
     */
    private Integer isDelete;


}
