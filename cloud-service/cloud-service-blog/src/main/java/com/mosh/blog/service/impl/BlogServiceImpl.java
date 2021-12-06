package com.mosh.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mosh.blog.client.InteractionClient;
import com.mosh.blog.entity.Blog;
import com.mosh.blog.entity.Detail;
import com.mosh.blog.entity.query.BlogQuery;
import com.mosh.blog.mapper.BlogMapper;
import com.mosh.blog.mapper.DetailMapper;
import com.mosh.blog.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mosh.db.mapper.MapperUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Resource
    DetailMapper detailMapper;

    @Resource
    InteractionClient interactionClient;

    @Override
    public Map<String, Object> getBlogListByPage(Integer current, Integer limit, BlogQuery query) throws IllegalAccessException {
        Page<Blog> page = MapperUtils.getPage(blogMapper, query, current, limit);
        long total = page.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", page.getRecords());
        return map;
    }

    @Override
    public void deleteBlog(String id) {
        interactionClient.deleteInteraction(id);
        blogMapper.deleteById(id);
        QueryWrapper<Detail> wrapper = new QueryWrapper<>();
        wrapper.eq("blog_id", id);
        detailMapper.delete(wrapper);
    }

    @Override
    public String addBlog(Blog blog) {
        blog.setStatus("Normal");
        blog.setIsDeleted(0);
        blogMapper.insert(blog);
        return blog.getId();
    }

    @Override
    public Map<String, Object> getBlogCollectedPageByMemberId(Integer current, Integer limit, String memberId) {
        List<String> blogIds = interactionClient.getCollectedByMemberId(memberId);
        if (blogIds == null || blogIds.isEmpty()) {
            return null;
        }

        Page<Blog> page = new Page<>(current, limit);
        QueryWrapper<Blog> wrapper = new QueryWrapper<>();
        wrapper.in("id", blogIds);
        blogMapper.selectPage(page, wrapper);
        Map<String, Object> map = new HashMap<>();
        map.put("rows", page.getRecords());
        map.put("total", page.getTotal());
        return map;
    }

}
