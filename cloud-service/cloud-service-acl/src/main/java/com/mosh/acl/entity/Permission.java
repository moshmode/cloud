package com.mosh.acl.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限
 * </p>
 *
 * @author testjava
 * @since 2020-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("acl_permission")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    private String pid;

    private String name;

    private Integer type;

    private String permissionValue;

    private String path;

    private String component;

    private String icon;

    private Integer status;

    @TableField(exist = false)
    private Integer level;

    @TableField(exist = false)
    private List<Permission> children;

    @TableField(exist = false)
    private boolean isSelect;


    private Boolean isDeleted;

    private Date gmtCreate;

    private Date gmtModified;


}
