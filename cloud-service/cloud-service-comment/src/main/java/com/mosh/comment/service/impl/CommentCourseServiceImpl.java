package com.mosh.comment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mosh.comment.entity.CommentCourse;
import com.mosh.comment.entity.Reply;
import com.mosh.comment.entity.ReplyCourse;
import com.mosh.comment.entity.vo.CommentVo;
import com.mosh.comment.mapper.CommentCourseMapper;
import com.mosh.comment.mapper.ReplyCourseMapper;
import com.mosh.comment.service.CommentCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mosh.comment.utils.MapperUtils;
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
public class CommentCourseServiceImpl extends ServiceImpl<CommentCourseMapper, CommentCourse> implements CommentCourseService {

    @Resource
    CommentCourseMapper commentMapper;

    @Resource
    ReplyCourseMapper replyMapper;


    @Override
    public Map<String, Object> getCommentByCourseId(String courseId, Integer current, Integer limit) {
        Page<CommentCourse> page = MapperUtils.getPage(CommentCourse.class, commentMapper, courseId, current, limit);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", page.getTotal());
        map.put("rows", MapperUtils.getRows(page, replyMapper));
        return map;
    }
}
