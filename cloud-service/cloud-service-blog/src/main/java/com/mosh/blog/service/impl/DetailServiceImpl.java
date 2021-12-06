package com.mosh.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mosh.blog.entity.Blog;
import com.mosh.blog.entity.Detail;
import com.mosh.blog.entity.vo.DetailVo;
import com.mosh.blog.mapper.BlogMapper;
import com.mosh.blog.mapper.DetailMapper;
import com.mosh.blog.service.DetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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

    /**
     * 通过博客id获取Detail的vo对象
     *
     * @param blogId 博客id
     * @return 对应的detail的vo对象
     */
    @Override
    public DetailVo getDetailByBlogId(String blogId) {
        Detail detail = detailMapper.selectOne(new QueryWrapper<Detail>().eq("blog_id", blogId));

        Blog blog = blogMapper.selectById(blogId);

        DetailVo detailVo = new DetailVo();

        BeanUtils.copyProperties(detail, detailVo);

        detailVo.setName(blog.getName());
        detailVo.setAvatar(blog.getAvatar());
        detailVo.setReleaseTime(blog.getGmtCreate());
        detailVo.setUpdateTime(detail.getGmtModified());

        return detailVo;
    }

    /**
     * 更新或插入Detail
     *
     * @param detail 更新或插入对象
     * @return 插入对象的id
     */
    @Override
    public String addDetail(Detail detail) {

        //detail存有博客id，则状态设置为发布
        if (!StringUtils.isEmpty(detail.getBlogId())) {
            detail.setStatus("Normal");
        }
        detail.setIsDeleted(0);

        //检查id，无则插入，有则更新
        if (StringUtils.isEmpty(detail.getId())) {
            detailMapper.insert(detail);
        } else {
            detailMapper.updateById(detail);
        }

        return detail.getId();
    }

    @Override
    public Map<String, Object> getDraftListByPage(Integer current, Integer limit, Detail detail) {
        Page<Detail> page = new Page<>(current, limit);

        QueryWrapper<Detail> wrapper = new QueryWrapper<>();

        String title = detail.getTitle();
        String memberId = detail.getMemberId();

        if (!StringUtils.isEmpty(title)) {
            wrapper.like("title", title);
        }

        if (!StringUtils.isEmpty(memberId)) {
            wrapper.eq("member_id", memberId);
        }

        wrapper.eq("status", "Draft");

        detailMapper.selectPage(page, wrapper);
        HashMap<String, Object> map = new HashMap<>();
        long total = page.getTotal();
        map.put("total", total);
        map.put("rows", page.getRecords());
        return map;
    }
}
