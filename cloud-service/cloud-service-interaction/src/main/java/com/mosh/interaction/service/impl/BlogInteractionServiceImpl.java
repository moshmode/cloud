package com.mosh.interaction.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mosh.interaction.entity.BlogInteraction;
import com.mosh.interaction.mapper.BlogInteractionMapper;
import com.mosh.interaction.service.BlogInteractionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mosh.interaction.utils.MapperUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 博客互动 服务实现类
 * </p>
 *
 * @author mosh
 * @since 2021-11-23
 */
@Service
public class BlogInteractionServiceImpl extends ServiceImpl<BlogInteractionMapper, BlogInteraction> implements BlogInteractionService {

    @Resource
    BlogInteractionMapper blogInteractionMapper;

    @Override
    public String addInteraction(BlogInteraction blogInteraction) {
        return MapperUtils.addInteraction(blogInteractionMapper, blogInteraction, "blog_id", blogInteraction.getBlogId());
    }

    @Override
    public BlogInteraction getInteraction(String blogId, String memberId) {
        return blogInteractionMapper.selectOne(new QueryWrapper<BlogInteraction>().eq("blog_id", blogId).eq("member_id", memberId));
    }

    @Override
    public Map<String, Object> countInteraction(String blogId) {
        return MapperUtils.countInteraction(blogInteractionMapper, "blog_id", blogId);
    }

    @Override
    public Integer deleteInteraction(String blogId) {
        return blogInteractionMapper.delete(new QueryWrapper<BlogInteraction>().eq("blog_id", blogId));
    }

    @Override
    public List<String> getCollectedByMemberId(String memberId) {
        return blogInteractionMapper.getCollectedByMemberId(memberId);
    }

}
