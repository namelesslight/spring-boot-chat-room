package com.example.springbootchatroom.code.entity.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 关注表
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Follow implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 关注编号
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 用户的编号
     */
    private String user;

    /**
     * 关注该用户的人的编号
     */
    private String follower;
    /**
     * 逻辑删除
     */
    private Boolean isDelete;


}
