package com.mosh.edu.entity.query;

import com.mosh.edu.entity.Course;
import com.mosh.db.annotation.QueryField;
import com.mosh.db.menu.QueryType;
import com.mosh.db.query.Query;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/21 19:00
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CourseQuery extends Query<Course> {

    /**
     * 课程讲师ID
     */
    @QueryField(column = "teacher_id")
    private String teacherId;

    /**
     * 课程专业ID
     */
    @QueryField(column = "subject_id")
    private String subjectId;

    /**
     * 课程专业父级ID
     */
    @QueryField(column = "subject_parent_id")
    private String subjectParentId;

    /**
     * 课程标题
     */
    @QueryField(column = "title", type = QueryType.LIKE)
    private String title;

    /**
     * 课程最大价格
     */
    @QueryField(column = "price", type = QueryType.LE)
    private BigDecimal maxPrice;

    /**
     * 课程最小价格
     */
    @QueryField(column = "price", type = QueryType.GE)
    private BigDecimal minPrice;

    /**
     * 课程状态 Draft未发布  Normal已发布
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
