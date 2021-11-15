package com.mosh.edu.entity.vo.course.info;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/25 19:48
 */
@Data
public class CourseInfoVo {
    private String id;

    private String teacherId;

    private String subjectId;

    private String subjectParentId;

    private String title;

    private BigDecimal price;

    private Integer lessonNum;

    private String cover;

    private String description;

}
