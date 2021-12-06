package com.mosh.comment.service;

import com.mosh.comment.entity.CommentCourse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 评论 服务类
 * </p>
 *
 * @author mosh
 * @since 2021-11-09
 */
public interface CommentCourseService extends IService<CommentCourse> {

    Map<String, Object> getCommentByCourseId(String courseId, Integer current, Integer limit);
}
