package com.mosh.comment.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mosh.comment.entity.CommentBlog;
import com.mosh.comment.entity.CommentCourse;
import com.mosh.comment.mapper.CommentBlogMapper;
import com.mosh.comment.mapper.CommentCourseMapper;
import com.mosh.comment.mapper.ReplyBlogMapper;
import com.mosh.comment.mapper.ReplyCourseMapper;
import com.mosh.comment.service.CommentBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mosh.comment.utils.MapperUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 博客评论 服务实现类
 * </p>
 *
 * @author mosh
 * @since 2021-11-18
 */
@Service
public class CommentBlogServiceImpl extends ServiceImpl<CommentBlogMapper, CommentBlog> implements CommentBlogService {

    @Resource
    CommentBlogMapper commentMapper;

    @Resource
    ReplyBlogMapper replyMapper;


    @Override
    public Map<String, Object> getCommentByBlogId(String blogId, Integer current, Integer limit) {
        Page<CommentBlog> page = MapperUtils.getPage(CommentBlog.class, commentMapper, blogId, current, limit);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", page.getTotal());
        map.put("rows", MapperUtils.getRows(page, replyMapper));
        return map;
    }
}
