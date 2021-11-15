package com.mosh.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mosh.edu.client.OrderClient;
import com.mosh.edu.entity.Course;
import com.mosh.edu.entity.CourseDescription;
import com.mosh.edu.entity.Subject;
import com.mosh.edu.entity.Teacher;
import com.mosh.edu.entity.vo.client.ChapterClientVo;
import com.mosh.edu.entity.vo.client.CourseClientInfoVo;
import com.mosh.edu.entity.vo.course.info.CourseInfoVo;
import com.mosh.edu.entity.vo.course.publish.CoursePublishVo;
import com.mosh.edu.mapper.CourseDescriptionMapper;
import com.mosh.edu.mapper.CourseMapper;
import com.mosh.edu.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mosh.entity.CourseOrder;
import com.mosh.utils.exception.SaveException;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    TeacherService teacherService;

    @Resource
    SubjectService subjectService;

    @Resource
    OrderClient orderClient;

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

    @Cacheable("courseList")
    @Override
    public List<Course> getHotCourses() {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("view_count");
        wrapper.last("limit 8");

        return courseMapper.selectList(wrapper);
    }

    @Override
    public CourseClientInfoVo getCourseClientInfoVo( String id,String memberId) {
        CourseClientInfoVo courseClientInfoVo = new CourseClientInfoVo();
        Course course = courseMapper.selectById(id);

        BeanUtils.copyProperties(course, courseClientInfoVo);

        CourseDescription description = courseDescriptionMapper.selectById(id);
        courseClientInfoVo.setDescription(description.getDescription());

        List<ChapterClientVo> chapterList = chapterService.getClientChapterVideo(id);
        courseClientInfoVo.setChapterList(chapterList);

        Teacher teacher = teacherService.getById(courseClientInfoVo.getTeacherId());
        courseClientInfoVo.setTeacher(teacher);

        Subject subject = subjectService.getById(courseClientInfoVo.getSubjectId());
        courseClientInfoVo.setSubjectTitle(subject.getTitle());

        Subject subjectParent = subjectService.getById(courseClientInfoVo.getSubjectParentId());
        courseClientInfoVo.setSubjectParentTitle(subjectParent.getTitle());

        courseClientInfoVo.setPay(orderClient.getIsPay(id, memberId));

        return courseClientInfoVo;
    }

    @Override
    public CourseOrder getCourseOrder(String id) {
        Course course = courseMapper.selectById(id);
        Teacher teacher = teacherService.getById(course.getTeacherId());
        CourseOrder courseOrder = new CourseOrder();
        BeanUtils.copyProperties(course, courseOrder);
        courseOrder.setTeacherName(teacher.getName());
        return courseOrder;
    }


}
