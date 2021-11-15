package com.mosh.comment.mapper;

import com.mosh.comment.entity.Reply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 回复 Mapper 接口
 * </p>
 *
 * @author mosh
 * @since 2021-11-09
 */
@Mapper
public interface ReplyMapper extends BaseMapper<Reply> {

}
