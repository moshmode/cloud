package com.mosh.interaction.mapper;

import com.mosh.interaction.entity.BlogInteraction;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 博客互动 Mapper 接口
 * </p>
 *
 * @author mosh
 * @since 2021-11-23
 */
@Mapper
public interface BlogInteractionMapper extends BaseMapper<BlogInteraction> {
    List<String> getCollectedByMemberId(String memberId);
}
