package com.mosh.comment.mapper;

import com.mosh.comment.entity.CommentForum;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 论坛评论 Mapper 接口
 * </p>
 *
 * @author mosh
 * @since 2021-11-17
 */
@Mapper
public interface CommentForumMapper extends BaseMapper<CommentForum> {

}
