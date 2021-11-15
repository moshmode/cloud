package com.mosh.blog.controller;


import com.mosh.blog.entity.Blog;
import com.mosh.blog.service.BlogService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 博客 前端控制器
 * </p>
 *
 * @author mosh
 * @since 2021-11-14
 */
@RestController
@RequestMapping("blog")
public class BlogController {

    @Resource
    BlogService blogService;

    /**
     * @param current 当前页
     * @param limit   页大小
     * @param blog    查询条件
     * @return 博客列表和列表大小
     */
    @PostMapping("page/{current}/{limit}")
    public ResponseEntity getBlogListByPage(@PathVariable("current") Integer current,
                                            @PathVariable("limit") Integer limit,
                                            Blog blog) {
        return ResponseEntity.success().data(blogService.getBlogListByPage(current, limit, blog));
    }

    @PostMapping
    public ResponseEntity addBlog(Blog blog) {
        blogService.save(blog);
        return ResponseEntity.success();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteBlog(@PathVariable("id") Integer id) {
        blogService.removeById(id);
        return ResponseEntity.success();
    }
}

