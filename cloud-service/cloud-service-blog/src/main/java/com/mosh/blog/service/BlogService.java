package com.mosh.blog.service;

import com.mosh.blog.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 博客 服务类
 * </p>
 *
 * @author mosh
 * @since 2021-11-14
 */
public interface BlogService extends IService<Blog> {

    Map<String,Object> getBlogListByPage(Integer current, Integer limit, Blog blog);
}
