package com.mosh.edu.service;

import com.mosh.edu.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mosh.edu.entity.vo.client.CourseClientInfoVo;
import com.mosh.edu.entity.vo.course.info.CourseInfoVo;
import com.mosh.edu.entity.vo.course.publish.CoursePublishVo;
import com.mosh.entity.CourseOrder;
import com.mosh.utils.exception.SaveException;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author mosh
 * @since 2021-10-25
 */
public interface CourseService extends IService<Course> {

    String saveCourseInfo(CourseInfoVo courseInfoVo) throws SaveException;

    CourseInfoVo getCourseInfo(String id);

    void updateCourseInfo(CourseInfoVo courseInfoVo);

    CoursePublishVo getCoursePublishInfo(String courseId);

    void deleteCourseById(String id);

    List<Course> getHotCourses();

    CourseClientInfoVo getCourseClientInfoVo(String id, String memberId);


    CourseOrder getCourseOrder(String id);
}
