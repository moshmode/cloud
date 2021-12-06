package com.mosh.interaction.service;

import com.mosh.interaction.entity.QuestionInteraction;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 问题互动 服务类
 * </p>
 *
 * @author mosh
 * @since 2021-12-03
 */
public interface QuestionInteractionService extends IService<QuestionInteraction> {
    String addInteraction(QuestionInteraction questionInteraction);

    QuestionInteraction getInteraction(String questionId,String memberId);

    Map<String, Object> countInteraction(String questionId);

    Integer deleteInteraction(String questionId);

    List<String> getCollectedByMemberId(String memberId);
}
