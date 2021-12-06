package com.mosh.forum.service;

import com.mosh.forum.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mosh.forum.entity.query.QuestionQuery;
import com.mosh.forum.entity.vo.QuestionVo;

import java.util.Map;

/**
 * <p>
 * 论坛 服务类
 * </p>
 *
 * @author mosh
 * @since 2021-11-15
 */
public interface QuestionService extends IService<Question> {

    Map<String, Object> getQuestionByPage(Integer current, Integer limit, QuestionQuery query);

    void addQuestion(QuestionVo questionVo);

    QuestionVo getQuestionById(String id);

    void deleteQuestionById(String questionId);

    Map<String, Object> getQuestionCollectedPageByMemberId(Integer current, Integer limit, String memberId);
}
