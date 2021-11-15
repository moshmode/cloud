package com.mosh.comment.controller;


import com.mosh.comment.entity.Comment;
import com.mosh.comment.entity.vo.CommentVo;
import com.mosh.comment.service.CommentService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 评论 前端控制器
 * </p>
 *
 * @author mosh
 * @since 2021-11-09
 */
@RestController
@RequestMapping("/comment/comment")
public class CommentController {
    @Resource
    CommentService commentService;

    @GetMapping("course/{courseId}/{current}/{limit}")
    public ResponseEntity getCommentByCourseId(@PathVariable("courseId") String courseId,
                                               @PathVariable("current") Integer current,
                                               @PathVariable("limit") Integer limit) {

        Map<String, Object> map = commentService.getCommentByCourseId(courseId, current, limit);
        return ResponseEntity.success().data("total", map.get("total")).data("rows", map.get("rows"));
    }

    @PostMapping
    public ResponseEntity addComment(@RequestBody Comment comment) {
        commentService.save(comment);
        return ResponseEntity.success();
    }

}

