package com.mosh.interaction.entity;

import com.baomidou.mybatisplus.annotation.*;


/**
 * <p>
 * 博客互动
 * </p>
 *
 * @author mosh
 * @since 2021-11-23
 */
@TableName("interaction_blog")
public class BlogInteraction extends Interaction {

    /**
     * 博客id
     */
    private String blogId;

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }
}
