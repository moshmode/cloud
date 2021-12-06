package com.mosh.comment.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 回复
 * </p>
 *
 * @author mosh
 * @since 2021-11-09
 */
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("comment_reply_course")
public class ReplyCourse extends Reply  {

}
