package com.mosh.comment.controller.front;


import com.mosh.comment.entity.ReplyCourse;
import com.mosh.comment.service.ReplyCourseService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 回复 前端控制器
 * </p>
 *
 * @author mosh
 * @since 2021-11-09
 */
@RestController
@RequestMapping("/comment/reply/front/course")
public class ReplyCourseController {
    @Resource
    ReplyCourseService replyService;

    @PostMapping
    public ResponseEntity addComment(@RequestBody ReplyCourse reply) {
        replyService.save(reply);
        return ResponseEntity.success();
    }
}

