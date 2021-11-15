package com.mosh.comment.controller;


import com.mosh.comment.entity.Comment;
import com.mosh.comment.entity.Reply;
import com.mosh.comment.service.ReplyService;
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
@RequestMapping("/comment/reply")
public class ReplyController {
    @Resource
    ReplyService replyService;

    @PostMapping
    public ResponseEntity addComment(@RequestBody Reply reply) {
        replyService.save(reply);
        return ResponseEntity.success();
    }
}

