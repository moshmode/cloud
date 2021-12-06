package com.mosh.comment.controller.front;


import com.mosh.comment.entity.CommentBlog;
import com.mosh.comment.entity.CommentCourse;
import com.mosh.comment.service.CommentBlogService;
import com.mosh.comment.service.CommentCourseService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 博客评论 前端控制器
 * </p>
 *
 * @author mosh
 * @since 2021-11-18
 */
@RestController
@RequestMapping("/comment/blog/front")
public class CommentBlogController {
    @Resource
    CommentBlogService commentService;

    @GetMapping("{blogId}/{current}/{limit}")
    public ResponseEntity getCommentByCourseId(@PathVariable("blogId") String blogId,
                                               @PathVariable("current") Integer current,
                                               @PathVariable("limit") Integer limit) {

        Map<String, Object> map = commentService.getCommentByBlogId(blogId, current, limit);
        return ResponseEntity.success().data("total", map.get("total")).data("rows", map.get("rows"));
    }

    @PostMapping
    public ResponseEntity addComment(@RequestBody CommentBlog comment) {
        commentService.save(comment);
        return ResponseEntity.success();
    }
}

