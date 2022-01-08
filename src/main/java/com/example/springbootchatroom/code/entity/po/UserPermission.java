package com.example.springbootchatroom.code.entity.po;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限名
     */
    private String permission;

    /**
     * 逻辑删除
     */
    private Boolean isDelete;


}
