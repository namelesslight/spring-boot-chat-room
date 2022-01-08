package com.example.springbootchatroom.code.entity.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户密码表
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserPasswd implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 用户密码
     */
    private String passwd;

    /**
     * 逻辑删除
     */
    private Boolean isDelete;


}
