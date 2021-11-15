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
 * @since 2021-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 博客ID
     */
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 作者ID
     */
    private String memberId;

    /**
     * 专业ID
     */
    private String subjectId;

    /**
     * 专业父级ID
     */
    private String subjectParentId;

    /**
     * 专业名字
     */
    private String subjectTitle;

    /**
     * 作者名字
     */
    private String name;

    /**
     * 作者头像
     */
    private String avatar;

    /**
     * 标题
     */
    private String title;

    /**
     * 封面图片路径
     */
    private String cover;

    /**
     * 简介
     */
    private String brief;

    /**
     * 浏览数量
     */
    private Long viewCount;

    /**
     * 乐观锁
     */
    private Long version;

    /**
     * 课程状态 Draft未发布  Normal已发布
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
