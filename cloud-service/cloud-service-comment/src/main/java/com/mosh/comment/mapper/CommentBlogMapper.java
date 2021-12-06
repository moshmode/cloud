package com.mosh.comment.mapper;

import com.mosh.comment.entity.CommentBlog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 博客评论 Mapper 接口
 * </p>
 *
 * @author mosh
 * @since 2021-11-18
 */
@Mapper
public interface CommentBlogMapper extends BaseMapper<CommentBlog> {

}
