package com.mosh.comment.mapper;

import com.mosh.comment.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 评论 Mapper 接口
 * </p>
 *
 * @author mosh
 * @since 2021-11-09
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}
