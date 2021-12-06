package com.mosh.comment.controller.front;


import com.mosh.comment.entity.CommentCourse;
import com.mosh.comment.entity.CommentForum;
import com.mosh.comment.service.CommentForumService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 论坛评论 前端控制器
 * </p>
 *
 * @author mosh
 * @since 2021-11-17
 */
@RestController
@RequestMapping("/comment/forum/front")
public class CommentForumController {

    @Resource
    CommentForumService commentForumService;

    @GetMapping("{questionId}/{current}/{limit}")
    public ResponseEntity getCommentByQuestionId(@PathVariable("questionId") String questionId,
                                                 @PathVariable("current") Integer current,
                                                 @PathVariable("limit") Integer limit) {

        Map<String, Object> map = commentForumService.getCommentByQuestionId(questionId, current, limit);
        return ResponseEntity.success().data("total", map.get("total")).data("rows", map.get("rows"));
    }

    @PostMapping
    public ResponseEntity addComment(@RequestBody CommentForum comment) {
        commentForumService.save(comment);
        return ResponseEntity.success();
    }
}

