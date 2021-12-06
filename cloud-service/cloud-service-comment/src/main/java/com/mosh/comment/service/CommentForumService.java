package com.mosh.comment.service;

import com.mosh.comment.entity.CommentForum;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 论坛评论 服务类
 * </p>
 *
 * @author mosh
 * @since 2021-11-17
 */
public interface CommentForumService extends IService<CommentForum> {


    Map<String, Object> getCommentByQuestionId(String courseId, Integer current, Integer limit);
}
