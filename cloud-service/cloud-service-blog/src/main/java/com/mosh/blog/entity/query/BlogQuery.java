package com.mosh.blog.entity.query;

import com.mosh.blog.entity.Blog;
import com.mosh.db.annotation.QueryField;
import com.mosh.db.menu.QueryType;
import com.mosh.db.query.Query;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/20 11:43
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class BlogQuery extends Query<Blog> {
    /**
     * 用户id
     */
    @QueryField(column = "member_id")
    private String memberId;

    /**
     * 专业ID
     */
    @QueryField(column = "subject_id")
    private String subjectId;

    /**
     * 专业父级ID
     */
    @QueryField(column = "subject_parent_id")
    private String subjectParentId;

    /**
     * 用户名称
     */
    @QueryField(column = "name",type = QueryType.LIKE)
    private String name;

    /**
     * 标题
     */
    @QueryField(column = "title", type = QueryType.LIKE)
    private String title;

    /**
     * 状态 Draft未发布  Normal已发布
     */
    @QueryField(column = "status")
    private String status;

    /**
     * 起止时间
     */
    @QueryField(column = "gmt_create", type = QueryType.GE)
    private String begin;

    /**
     * 终止时间
     */
    @QueryField(column = "gmt_create", type = QueryType.LE)
    private String end;

    /**
     * 排列顺序
     */
    @QueryField(type = QueryType.ORDER_BY_DESC)
    private String order;
}
