package com.mosh.interaction.controller.feign;

import com.mosh.interaction.service.BlogInteractionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description
 * 博客互动关系的feign控制器
 *
 * @author mosh
 * @date 2021/11/23 22:21
 */
@RestController
@RequestMapping("/interaction/blog/feign")
public class BlogFeignController {

    @Resource
    BlogInteractionService blogInteractionService;

    /**
     * 根据博客id删除该博客所有互动关系
     *
     * @param blogId 博客id
     * @return 删除的互动条数
     */
    @DeleteMapping("{blogId}")
    public Integer deleteInteractionByBlogId(@PathVariable("blogId") String blogId) {
        return blogInteractionService.deleteInteraction(blogId);
    }

    /**
     * 根据用户id获取其收藏的所有博客id
     *
     * @param memberId 用户id
     * @return 博客id列表
     */
    @GetMapping("collected/{memberId}")
    public List<String> getCollectedByMemberId(@PathVariable("memberId") String memberId) {
        return blogInteractionService.getCollectedByMemberId(memberId);
    }

}
