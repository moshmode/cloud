package com.mosh.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mosh.blog.entity.Blog;
import com.mosh.blog.entity.Detail;
import com.mosh.blog.entity.vo.DetailVo;
import com.mosh.blog.mapper.BlogMapper;
import com.mosh.blog.mapper.DetailMapper;
import com.mosh.blog.service.DetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 博客 服务实现类
 * </p>
 *
 * @author mosh
 * @since 2021-11-15
 */
@Service
public class DetailServiceImpl extends ServiceImpl<DetailMapper, Detail> implements DetailService {

    @Resource
    DetailMapper detailMapper;

    @Resource
    BlogMapper blogMapper;

    @Override
    public DetailVo getDetailByBlogId(Integer blogId) {
        QueryWrapper<Detail> wrapper = new QueryWrapper<>();
        wrapper.eq("blog_id", blogId);
        Detail detail = detailMapper.selectOne(wrapper);

        Blog blog = blogMapper.selectById(blogId);

        DetailVo detailVo = new DetailVo();

        BeanUtils.copyProperties(detail, detailVo);

        detailVo.setName(blog.getName());
        detailVo.setTitle(blog.getTitle());
        detailVo.setReleaseTime(blog.getGmtCreate());
        detailVo.setUpdateTime(detail.getGmtModified());

        return detailVo;
    }
}
