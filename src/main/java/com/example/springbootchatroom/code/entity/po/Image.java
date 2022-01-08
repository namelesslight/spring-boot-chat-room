package com.example.springbootchatroom.code.entity.po;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 图片表
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 图片名
     */
    private String name;

    /**
     * 图片路径
     */
    private String path;

    /**
     * 逻辑删除
     */
    private Boolean isDelete;


}
