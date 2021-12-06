package com.mosh.forum.controller.front;


import com.mosh.forum.entity.Question;
import com.mosh.forum.entity.query.QuestionQuery;
import com.mosh.forum.entity.vo.QuestionVo;
import com.mosh.forum.service.QuestionService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 论坛 前端控制器
 * </p>
 *
 * @author mosh
 * @since 2021-11-15
 */
@RestController
@RequestMapping("/forum/question/front")
public class QuestionController {

    @Resource
    QuestionService questionService;

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param limit   页大小
     * @param query   查询条件
     * @return 查询数据
     */
    @PostMapping("page/{current}/{limit}")
    public ResponseEntity getQuestionByPage(@PathVariable("current") Integer current,
                                            @PathVariable("limit") Integer limit,
                                            @RequestBody QuestionQuery query) {
        Map<String, Object> map = questionService.getQuestionByPage(current, limit, query);
        return ResponseEntity.success().data(map);
    }

    /**
     * 通过questionId获取questionVo
     *
     * @param id 问题id
     * @return questionVo
     */
    @GetMapping("{id}")
    public ResponseEntity getQuestionById(@PathVariable("id") String id) {
        QuestionVo question = questionService.getQuestionById(id);
        return ResponseEntity.success().data("question", question);
    }

    /**
     * 添加或更新问题
     *
     * @param questionVo 添加或更新的对象
     * @return success
     */
    @PostMapping
    public ResponseEntity addQuestion(@RequestBody QuestionVo questionVo) {
        questionService.addQuestion(questionVo);
        return ResponseEntity.success();
    }

    /**
     * 通过questionId删除问题及其问题与标签的关系
     *
     * @param questionId 问题id
     * @return success
     */
    @DeleteMapping("{questionId}")
    public ResponseEntity deleteQuestionById(@PathVariable("questionId") String questionId) {
        questionService.deleteQuestionById(questionId);
        return ResponseEntity.success();
    }

    /**
     * 通过用户id分页获取其收藏问题
     *
     * @param current  当前页
     * @param limit    页大小
     * @param memberId 用户id
     * @return 博客列表和列表大小
     */
    @GetMapping("collected/{current}/{limit}/{memberId}")
    public ResponseEntity getQuestionCollectedPageByMemberId(@PathVariable("current") Integer current,
                                                             @PathVariable("limit") Integer limit,
                                                             @PathVariable("memberId") String memberId) {
        return ResponseEntity.success().data(questionService.getQuestionCollectedPageByMemberId(current, limit, memberId));
    }
}

