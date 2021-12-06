package com.mosh.comment.service.impl;

import com.mosh.comment.entity.ReplyBlog;
import com.mosh.comment.mapper.ReplyBlogMapper;
import com.mosh.comment.service.ReplyBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客回复 服务实现类
 * </p>
 *
 * @author mosh
 * @since 2021-11-18
 */
@Service
public class ReplyBlogServiceImpl extends ServiceImpl<ReplyBlogMapper, ReplyBlog> implements ReplyBlogService {

}
