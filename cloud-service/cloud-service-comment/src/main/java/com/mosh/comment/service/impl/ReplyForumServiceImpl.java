package com.mosh.comment.service.impl;

import com.mosh.comment.entity.ReplyForum;
import com.mosh.comment.mapper.ReplyForumMapper;
import com.mosh.comment.service.ReplyForumService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 论坛回复 服务实现类
 * </p>
 *
 * @author mosh
 * @since 2021-11-18
 */
@Service
public class ReplyForumServiceImpl extends ServiceImpl<ReplyForumMapper, ReplyForum> implements ReplyForumService {

}
