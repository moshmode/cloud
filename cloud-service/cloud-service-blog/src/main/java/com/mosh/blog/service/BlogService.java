package com.mosh.blog.service;

import com.mosh.blog.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mosh.blog.entity.query.BlogQuery;

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

    String addBlog(Blog blog);

    Map<String, Object> getBlogListByPage(Integer current, Integer limit, BlogQuery query) throws IllegalAccessException;

    void deleteBlog(String id);

    Map<String, Object> getBlogCollectedPageByMemberId(Integer current, Integer limit, String memberId);
}
