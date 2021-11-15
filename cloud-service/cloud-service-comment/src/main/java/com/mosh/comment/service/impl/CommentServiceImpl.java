package com.mosh.comment.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mosh.comment.entity.Comment;
import com.mosh.comment.entity.Reply;
import com.mosh.comment.entity.vo.CommentVo;
import com.mosh.comment.mapper.CommentMapper;
import com.mosh.comment.mapper.ReplyMapper;
import com.mosh.comment.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author mosh
 * @since 2021-11-09
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Resource
    CommentMapper commentMapper;

    @Resource
    ReplyMapper replyMapper;

    @Override
    public Map<String, Object> getCommentByCourseId(String courseId, Integer current, Integer limit) {
        Page<Comment> page = new Page<>(current, limit);

        QueryWrapper<Comment> wrapper = new QueryWrapper<>();

        wrapper.eq("course_id", courseId);

        commentMapper.selectPage(page, wrapper);

        List<CommentVo> rows = new ArrayList<>();
        for (Comment comment : page.getRecords()) {
            QueryWrapper<Reply> replyWrapper = new QueryWrapper<>();
            replyWrapper.eq("parent_id", comment.getId());
            List<Reply> replyList = replyMapper.selectList(replyWrapper);
            CommentVo commentVo = new CommentVo();
            BeanUtils.copyProperties(comment, commentVo);
            commentVo.setReplyList(replyList);
            rows.add(commentVo);
        }

        long total = page.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", rows);
        return map;
    }
}
