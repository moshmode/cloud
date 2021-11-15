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
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("comment_reply")
public class Reply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 回复ID
     */
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 父评论ID
     */
    private String parentId;

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

    /**
     * 回复的会员id
     */
    private String toMemberId;

    /**
     * 回复的会员昵称
     */
    private String toNickname;

    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    @TableLogic
    private Integer isDeleted;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
