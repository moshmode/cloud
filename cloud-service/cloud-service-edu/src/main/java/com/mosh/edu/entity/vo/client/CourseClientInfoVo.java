package com.mosh.edu.entity.vo.client;

import com.mosh.edu.entity.Chapter;
import com.mosh.edu.entity.Teacher;
import com.mosh.edu.entity.vo.course.chapter.ChapterVo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/8 13:21
 */
@Data
public class CourseClientInfoVo {

    private String id;

    private String teacherId;

    private Teacher teacher;

    private String subjectId;

    private String subjectTitle;

    private String subjectParentId;

    private String subjectParentTitle;

    private String title;

    private List<ChapterClientVo> chapterList;

    private BigDecimal price;

    private Integer lessonNum;

    private String cover;

    private String description;

    private Long buyCount;

    private Long viewCount;

    private boolean pay;

}
