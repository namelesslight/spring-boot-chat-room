package com.example.springbootchatroom.code.entity.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 动态图片表
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ActivityImage implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 动态编号
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;
    /**
     * 动态图片编号
     */
    private String image;

    /**
     * 逻辑删除
     */
    private Boolean isDelete;


}
