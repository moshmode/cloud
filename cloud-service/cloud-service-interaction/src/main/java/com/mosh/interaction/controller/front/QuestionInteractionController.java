package com.mosh.interaction.controller.front;


import com.mosh.interaction.entity.QuestionInteraction;
import com.mosh.interaction.service.QuestionInteractionService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 问题互动 前端控制器
 * </p>
 *
 * @author mosh
 * @since 2021-12-03
 */
@RestController
@RequestMapping("/interaction/question/front")
public class QuestionInteractionController {

    @Resource
    QuestionInteractionService questionInteractionService;


    /**
     * 添加或更新问题互动
     * @param questionInteraction 问题的互动实体
     * @return 问题互动实体的id
     */
    @PostMapping
    public ResponseEntity addInteraction(@RequestBody QuestionInteraction questionInteraction) {
        return ResponseEntity.success().data("questionInteractionId", questionInteractionService.addInteraction(questionInteraction));
    }

    /**
     * 通过问题的id和用户id获取该用户对该博客的互动信息
     * @param questionId    问题id
     * @param memberId  用户id
     * @return  该用户对该问题的互动信息
     */
    @GetMapping("{questionId}/{memberId}")
    public ResponseEntity getInteraction(@PathVariable("questionId") String questionId,
                                         @PathVariable("memberId") String memberId) {
        return ResponseEntity.success().data("questionInteraction", questionInteractionService.getInteraction(questionId, memberId));
    }

    /**
     * 统计问题的点赞数和收藏数
     * @param questionId 问题id
     * @return  问题的点赞数和收藏数
     */
    @GetMapping("count/{questionId}")
    public ResponseEntity countInteraction(@PathVariable("questionId") String questionId) {
        return ResponseEntity.success().data( questionInteractionService.countInteraction(questionId));
    }


}

