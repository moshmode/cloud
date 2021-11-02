package com.mosh.edu.entity.vo.course.publish;

import lombok.Data;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/28 13:21
 */
@Data
public class CoursePublishVo {
    private String id;
    private String title;
    private String cover;
    private Integer lessonNum;
    private String subjectLevelOne;
    private String subjectLevelTwo;
    private String teacherName;
    private String price;//只用于显示
}