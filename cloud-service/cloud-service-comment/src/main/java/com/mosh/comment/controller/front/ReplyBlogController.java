package com.mosh.comment.controller.front;


import com.mosh.comment.entity.ReplyBlog;
import com.mosh.comment.service.ReplyBlogService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * <p>
 * 博客回复 前端控制器
 * </p>
 *
 * @author mosh
 * @since 2021-11-18
 */
@RestController
@RequestMapping("/comment/reply/front/blog")
public class ReplyBlogController {
    @Resource
    ReplyBlogService replyService;

    @PostMapping
    public ResponseEntity addComment(@RequestBody ReplyBlog reply) {
        replyService.save(reply);
        return ResponseEntity.success();
    }
}

