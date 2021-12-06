package com.mosh.comment.controller.front;


import com.mosh.comment.entity.CommentCourse;
import com.mosh.comment.service.CommentCourseService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
@RequestMapping("/comment/course/front")
public class CommentCourseController {
    @Resource
    CommentCourseService commentService;

    @GetMapping("{courseId}/{current}/{limit}")
    public ResponseEntity getCommentByCourseId(@PathVariable("courseId") String courseId,
                                               @PathVariable("current") Integer current,
                                               @PathVariable("limit") Integer limit) {

        Map<String, Object> map = commentService.getCommentByCourseId(courseId, current, limit);
        return ResponseEntity.success().data("total", map.get("total")).data("rows", map.get("rows"));
    }

    @PostMapping
    public ResponseEntity addComment(@RequestBody CommentCourse comment) {
        commentService.save(comment);
        return ResponseEntity.success();
    }

}

