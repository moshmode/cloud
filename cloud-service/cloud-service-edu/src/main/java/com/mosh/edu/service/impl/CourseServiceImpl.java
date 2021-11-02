package com.mosh.edu.service.impl;

import com.mosh.edu.entity.Course;
import com.mosh.edu.entity.CourseDescription;
import com.mosh.edu.entity.vo.course.info.CourseInfoVo;
import com.mosh.edu.entity.vo.course.publish.CoursePublishVo;
import com.mosh.edu.mapper.ChapterMapper;
import com.mosh.edu.mapper.CourseDescriptionMapper;
import com.mosh.edu.mapper.CourseMapper;
import com.mosh.edu.mapper.VideoMapper;
import com.mosh.edu.service.ChapterService;
import com.mosh.edu.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mosh.edu.service.VideoService;
import com.mosh.utils.exception.SaveException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author mosh
 * @since 2021-10-25
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Resource
    CourseMapper courseMapper;

    @Resource
    CourseDescriptionMapper courseDescriptionMapper;

    @Resource
    ChapterService chapterService;

    @Resource
    VideoService videoService;



    @Override
    public String saveCourseInfo(CourseInfoVo courseInfoVo) throws SaveException {
        Course course = new Course();
        CourseDescription description = new CourseDescription();
        BeanUtils.copyProperties(courseInfoVo, course);


        int insert = courseMapper.insert(course);
        if (insert == 0) {
            throw new SaveException();
        }

        description.setDescription(courseInfoVo.getDescription());
        description.setId(course.getId());
        int insert1 = courseDescriptionMapper.insert(description);
        if (insert1 == 0) {
            throw new SaveException();
        }
        return course.getId();
    }

    @Override
    public CourseInfoVo getCourseInfo(String id) {
        CourseInfoVo courseInfoVo = new CourseInfoVo();
        Course course = courseMapper.selectById(id);
        BeanUtils.copyProperties(course, courseInfoVo);

        CourseDescription description = courseDescriptionMapper.selectById(id);
        courseInfoVo.setDescription(description.getDescription());

        return courseInfoVo;
    }

    @Override
    public void updateCourseInfo(CourseInfoVo courseInfoVo) {
        Course course = new Course();
        CourseDescription description = new CourseDescription();
        BeanUtils.copyProperties(courseInfoVo, course);

        courseMapper.updateById(course);

        description.setDescription(courseInfoVo.getDescription());
        description.setId(course.getId());
        courseDescriptionMapper.updateById(description);
    }

    @Override
    public CoursePublishVo getCoursePublishInfo(String courseId) {
        return courseMapper.getPublishCourseInfo(courseId);
    }

    @Override
    public void deleteCourseById(String id) {
        videoService.deleteByCourseId(id);
        chapterService.deleteByCourseId(id);
        courseDescriptionMapper.deleteById(id);
        courseMapper.deleteById(id);
    }


}
