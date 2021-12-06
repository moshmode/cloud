package com.mosh.interaction.mapper;

import com.mosh.interaction.entity.QuestionInteraction;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 问题互动 Mapper 接口
 * </p>
 *
 * @author mosh
 * @since 2021-12-03
 */
@Mapper
public interface QuestionInteractionMapper extends BaseMapper<QuestionInteraction> {
    List<String> getCollectedByMemberId(String memberId);
}
