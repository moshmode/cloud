package com.mosh.comment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mosh.comment.entity.CommentCourse;
import com.mosh.comment.entity.CommentForum;
import com.mosh.comment.mapper.CommentForumMapper;
import com.mosh.comment.mapper.ReplyForumMapper;
import com.mosh.comment.service.CommentForumService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mosh.comment.utils.MapperUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 论坛评论 服务实现类
 * </p>
 *
 * @author mosh
 * @since 2021-11-17
 */
@Service
public class CommentForumServiceImpl extends ServiceImpl<CommentForumMapper, CommentForum> implements CommentForumService {

    @Resource
    CommentForumMapper commentMapper;

    @Resource
    ReplyForumMapper replyMapper;

    @Override
    public Map<String, Object> getCommentByQuestionId(String questionId, Integer current, Integer limit) {
        Page<CommentForum> page = MapperUtils.getPage(CommentForum.class, commentMapper, questionId, current, limit);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", page.getTotal());
        map.put("rows", MapperUtils.getRows(page, replyMapper));
        return map;
    }
}
