package com.mosh.interaction.controller.feign;

import com.mosh.interaction.service.QuestionInteractionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description
 * 问题互动关系的feign控制器
 *
 * @author mosh
 * @date 2021/12/4 12:26
 */
@RestController
@RequestMapping("/interaction/question/feign")
public class QuestionFeignController {
    @Resource
    QuestionInteractionService questionInteractionService;

    /**
     * 根据问题id删除该博客所有互动关系
     *
     * @param questionId 问题id
     * @return 删除的互动条数
     */
    @DeleteMapping("{questionId}")
    public Integer deleteInteractionByBlogId(@PathVariable("questionId") String questionId) {
        return questionInteractionService.deleteInteraction(questionId);
    }

    /**
     * 根据用户id获取其收藏的所有问题id
     *
     * @param memberId 用户id
     * @return 问题id列表
     */
    @GetMapping("collected/{memberId}")
    public List<String> getCollectedByMemberId(@PathVariable("memberId") String memberId) {
        return questionInteractionService.getCollectedByMemberId(memberId);
    }
}
