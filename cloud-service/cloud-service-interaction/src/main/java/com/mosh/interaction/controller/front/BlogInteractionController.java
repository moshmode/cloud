package com.mosh.interaction.controller.front;

import com.mosh.interaction.entity.BlogInteraction;
import com.mosh.interaction.service.BlogInteractionService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 博客互动 前端控制器
 * </p>
 *
 * @author mosh
 * @since 2021-11-23
 */
@RestController
@RequestMapping("/interaction/blog/front")
public class BlogInteractionController {

    @Resource
    BlogInteractionService blogInteractionService;


    /**
     * 添加或更新blog互动
     *
     * @param blogInteraction blog的互动信息
     * @return blog的互动信息的id
     */
    @PostMapping
    public ResponseEntity addInteraction(@RequestBody BlogInteraction blogInteraction) {
        return ResponseEntity.success().data("blogInteractionId", blogInteractionService.addInteraction(blogInteraction));
    }

    /**
     * 通过博客的id和用户id获取该用户对该博客的互动信息
     *
     * @param blogId   博客id
     * @param memberId 用户id
     * @return 用户对博客的互动信息
     */
    @GetMapping("{blogId}/{memberId}")
    public ResponseEntity getInteraction(@PathVariable("blogId") String blogId,
                                         @PathVariable("memberId") String memberId) {
        return ResponseEntity.success().data("blogInteraction", blogInteractionService.getInteraction(blogId, memberId));
    }

    /**
     * 统计博客的点赞数和收藏数
     *
     * @param blogId 博客id
     * @return 博客的点赞数和收藏数
     */
    @GetMapping("count/{blogId}")
    public ResponseEntity countInteraction(@PathVariable("blogId") String blogId) {
        return ResponseEntity.success().data( blogInteractionService.countInteraction(blogId));
    }

}

