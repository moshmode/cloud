package com.mosh.comment.service;

import com.mosh.comment.entity.CommentBlog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 博客评论 服务类
 * </p>
 *
 * @author mosh
 * @since 2021-11-18
 */
public interface CommentBlogService extends IService<CommentBlog> {
    Map<String, Object> getCommentByBlogId(String blogId, Integer current, Integer limit);
}
