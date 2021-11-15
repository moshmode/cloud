package com.mosh.comment.service;

import com.mosh.comment.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mosh.comment.entity.vo.CommentVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 评论 服务类
 * </p>
 *
 * @author mosh
 * @since 2021-11-09
 */
public interface CommentService extends IService<Comment> {

    Map<String, Object> getCommentByCourseId(String courseId, Integer current, Integer limit);
}
