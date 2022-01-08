package com.example.springbootchatroom.code.entity.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 对应头像的图片编号
     */
    private String image;

    /**
     * 逻辑删除
     */
    private Boolean isDelete;


}
