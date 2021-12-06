package com.mosh.interaction.entity;

import com.baomidou.mybatisplus.annotation.*;

/**
 * <p>
 * 问题互动
 * </p>
 *
 * @author mosh
 * @since 2021-12-03
 */
@TableName("interaction_question")
public class QuestionInteraction extends Interaction {
    /**
     * 问题id
     */
    private String questionId;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }
}
