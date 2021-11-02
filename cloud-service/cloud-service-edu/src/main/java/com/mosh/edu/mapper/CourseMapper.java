package com.mosh.edu.mapper;

import com.mosh.edu.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mosh.edu.entity.vo.course.publish.CoursePublishVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author mosh
 * @since 2021-10-25
 */
@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    CoursePublishVo getPublishCourseInfo(String courseId);
}
