package com.mosh.comment.entity.vo;

import com.mosh.comment.entity.Reply;
import com.mosh.comment.entity.ReplyCourse;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/9 13:20
 */
@Data
public class CommentVo {
    /**
     * 评论ID
     */
    private String id;

    /**
     * 课程id
     */
    private String courseId;

    /**
     * 会员id
     */
    private String memberId;

    /**
     * 会员昵称
     */
    private String nickname;

    /**
     * 会员头像
     */
    private String avatar;

    /**
     * 评论内容
     */
    private String content;

    private Date gmtCreate;

    private List<Reply> replyList;
}
