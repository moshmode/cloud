package com.mosh.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mosh.blog.entity.Blog;
import com.mosh.blog.mapper.BlogMapper;
import com.mosh.blog.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 博客 服务实现类
 * </p>
 *
 * @author mosh
 * @since 2021-11-14
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    @Resource
    BlogMapper blogMapper;

    @Override
    public Map<String, Object> getBlogListByPage(Integer current, Integer limit, Blog blog) {
        Page<Blog> page = new Page<>(current, limit);

        QueryWrapper<Blog> wrapper = new QueryWrapper<>();

        String title = blog.getTitle();
        String name = blog.getName();
        String subjectId = blog.getSubjectId();
        String subjectTitle = blog.getSubjectTitle();
        String subjectParentId = blog.getSubjectParentId();

        if (!StringUtils.isEmpty(title)) {
            wrapper.like("title", title);
        }
        if (!StringUtils.isEmpty(name)) {
            wrapper.eq("name", name);
        }
        if (!StringUtils.isEmpty(subjectId)) {
            wrapper.eq("subject_title", subjectTitle);
        }
        if (!StringUtils.isEmpty(subjectId)) {
            wrapper.eq("subject_id", subjectId);
        }
        if (!StringUtils.isEmpty(subjectParentId)) {
            wrapper.eq("subject_parent_id", subjectParentId);
        }
        wrapper.eq("status", "Normal");

        blogMapper.selectPage(page, wrapper);

        long total = page.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", page.getRecords());
        return map;

    }
}
