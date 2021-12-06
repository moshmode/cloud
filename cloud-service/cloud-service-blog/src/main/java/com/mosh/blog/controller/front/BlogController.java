package com.mosh.blog.controller.front;


import com.mosh.blog.entity.Blog;
import com.mosh.blog.entity.query.BlogQuery;
import com.mosh.blog.service.BlogService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 博客 前端控制器
 * </p>
 *
 * @author mosh
 * @since 2021-11-14
 */
@RestController
@RequestMapping("blog/blog/front")
public class BlogController {

    @Resource
    BlogService blogService;

    /**
     * 分页获取博客
     *
     * @param current 当前页
     * @param limit   页大小
     * @param query   查询条件
     * @return 博客列表和列表大小
     */
    @PostMapping("page/{current}/{limit}")
    public ResponseEntity getQuestionByPage(@PathVariable("current") Integer current,
                                            @PathVariable("limit") Integer limit,
                                            @RequestBody BlogQuery query) throws IllegalAccessException {
        return ResponseEntity.success().data(blogService.getBlogListByPage(current, limit, query));
    }

    /**
     * 更新或添加博客
     *
     * @param blog 博客
     * @return 博客id
     */
    @PostMapping
    public ResponseEntity addBlog(Blog blog) {
        String blogId = blogService.addBlog(blog);
        return ResponseEntity.success().data("blogId", blogId);
    }

    /**
     * 删除博客
     *
     * @param id 博客id
     * @return 默认响应体
     */
    @DeleteMapping("{id}")
    public ResponseEntity deleteBlog(@PathVariable("id") String id) {
        blogService.deleteBlog(id);
        return ResponseEntity.success();
    }

    /**
     * 通过用户id分页获取其收藏博客
     *
     * @param current  当前页
     * @param limit    页大小
     * @param memberId 用户id
     * @return 博客列表和列表大小
     */
    @GetMapping("collected/{current}/{limit}/{memberId}")
    public ResponseEntity getBlogCollectedPageByMemberId(@PathVariable("current") Integer current,
                                                         @PathVariable("limit") Integer limit,
                                                         @PathVariable("memberId") String memberId) {
        return ResponseEntity.success().data(blogService.getBlogCollectedPageByMemberId(current, limit, memberId));
    }
}

