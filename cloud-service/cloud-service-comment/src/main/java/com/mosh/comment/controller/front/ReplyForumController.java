package com.mosh.comment.controller.front;


import com.mosh.comment.entity.ReplyCourse;
import com.mosh.comment.entity.ReplyForum;
import com.mosh.comment.service.ReplyCourseService;
import com.mosh.comment.service.ReplyForumService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 论坛回复 前端控制器
 * </p>
 *
 * @author mosh
 * @since 2021-11-18
 */
@RestController
@RequestMapping("/comment/reply/front/forum")
public class ReplyForumController {
    @Resource
    ReplyForumService replyService;

    @PostMapping
    public ResponseEntity addComment(@RequestBody ReplyForum reply) {
        replyService.save(reply);
        return ResponseEntity.success();
    }
}

