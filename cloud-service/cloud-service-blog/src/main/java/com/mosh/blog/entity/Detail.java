package com.mosh.blog.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 博客
 * </p>
 *
 * @author mosh
 * @since 2021-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("blog_detail")
public class Detail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 详情ID
     */
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 博客ID
     */
    private String blogId;

    /**
     * 作者ID
     */
    private String memberId;

    /**
     * 内容
     */
    private String content;

    /**
     * 状态 Draft未发布  Normal已发布
     */
    private String status;

    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    @TableLogic
    private Integer isDeleted;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
