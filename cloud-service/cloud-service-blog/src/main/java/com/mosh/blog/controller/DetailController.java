package com.mosh.blog.controller;


import com.mosh.blog.entity.vo.DetailVo;
import com.mosh.blog.service.DetailService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 博客 前端控制器
 * </p>
 *
 * @author mosh
 * @since 2021-11-15
 */
@RestController
@RequestMapping("/blog/detail")
public class DetailController {

    @Resource
    DetailService detailService;

    @GetMapping("{blogId}")
    public ResponseEntity getDetailVoByBlogId(@PathVariable("blogId") Integer blogId) {
        DetailVo detailVo = detailService.getDetailByBlogId(blogId);
        return ResponseEntity.success().data("detail", detailVo);
    }
}

