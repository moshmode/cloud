package com.mosh.comment.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 博客回复
 * </p>
 *
 * @author mosh
 * @since 2021-11-18
 */
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("comment_reply_blog")
public class ReplyBlog extends Reply {
}
