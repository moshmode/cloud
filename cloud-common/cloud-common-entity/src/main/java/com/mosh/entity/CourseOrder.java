package com.mosh.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/9 9:33
 */
@Data
public class CourseOrder {

    private String id;

    private String title;

    private BigDecimal price;

    private Integer lessonNum;

    private String cover;

    private String teacherId;

    private String teacherName;

}
