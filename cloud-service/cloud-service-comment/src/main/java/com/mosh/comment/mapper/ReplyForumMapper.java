package com.mosh.comment.mapper;

import com.mosh.comment.entity.ReplyForum;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 论坛回复 Mapper 接口
 * </p>
 *
 * @author mosh
 * @since 2021-11-18
 */
@Mapper
public interface ReplyForumMapper extends BaseMapper<ReplyForum> {

}
