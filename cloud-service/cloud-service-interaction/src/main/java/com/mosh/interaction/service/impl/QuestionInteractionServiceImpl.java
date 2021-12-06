package com.mosh.interaction.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mosh.interaction.entity.BlogInteraction;
import com.mosh.interaction.entity.QuestionInteraction;
import com.mosh.interaction.mapper.QuestionInteractionMapper;
import com.mosh.interaction.service.QuestionInteractionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mosh.interaction.utils.MapperUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 问题互动 服务实现类
 * </p>
 *
 * @author mosh
 * @since 2021-12-03
 */
@Service
public class QuestionInteractionServiceImpl extends ServiceImpl<QuestionInteractionMapper, QuestionInteraction> implements QuestionInteractionService {

    @Resource
    QuestionInteractionMapper questionInteractionMapper;

    @Override
    public String addInteraction(QuestionInteraction questionInteraction) {
        return MapperUtils.addInteraction(questionInteractionMapper, questionInteraction, "question_id", questionInteraction.getQuestionId());
    }

    @Override
    public QuestionInteraction getInteraction(String questionId, String memberId) {
        return questionInteractionMapper.selectOne(new QueryWrapper<QuestionInteraction>().eq("question_id", questionId).eq("member_id", memberId));
    }

    @Override
    public Map<String, Object> countInteraction(String questionId) {
        return MapperUtils.countInteraction(questionInteractionMapper, "question_id", questionId);
    }

    @Override
    public Integer deleteInteraction(String questionId) {
        return questionInteractionMapper.delete(new QueryWrapper<QuestionInteraction>().eq("question_id", questionId));
    }

    @Override
    public List<String> getCollectedByMemberId(String memberId) {
        return questionInteractionMapper.getCollectedByMemberId(memberId);
    }
}
