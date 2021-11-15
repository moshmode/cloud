package com.mosh.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mosh.edu.entity.Course;
import com.mosh.edu.entity.vo.course.info.CourseInfoVo;
import com.mosh.edu.entity.vo.course.publish.CoursePublishVo;
import com.mosh.edu.service.CourseService;
import com.mosh.utils.exception.SaveException;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author mosh
 * @since 2021-10-25
 */
@RestController
@RequestMapping("/edu/course")
public class CourseController {

    @Resource
    CourseService courseService;

    @PostMapping
    public ResponseEntity addCourseInfo(@RequestBody CourseInfoVo courseInfoVo) throws SaveException {
        String id = courseService.saveCourseInfo(courseInfoVo);
        return ResponseEntity.success().data("id", id);
    }

    @GetMapping("{id}")
    public ResponseEntity getCourseInfo(@PathVariable("id") String id) {
        CourseInfoVo courseInfoVo = courseService.getCourseInfo(id);
        return ResponseEntity.success().data("courseInfoVo", courseInfoVo);
    }

    @PutMapping
    public ResponseEntity updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo) throws SaveException {
        courseService.updateCourseInfo(courseInfoVo);
        return ResponseEntity.success();
    }

    @GetMapping("publishInfo/{courseId}")
    public ResponseEntity getCoursePublishInfo(@PathVariable("courseId") String courseId) {
        CoursePublishVo coursePublishVo = courseService.getCoursePublishInfo(courseId);
        return ResponseEntity.success().data("coursePublishVo", coursePublishVo);
    }

    @PostMapping("publishCourse/{courseId}")
    public ResponseEntity publishCourse(@PathVariable("courseId") String courseId) {
        Course course = new Course();
        course.setId(courseId);
        course.setStatus("Normal");
        courseService.updateById(course);
        return ResponseEntity.success();
    }

    @PostMapping("page/{current}/{limit}")
    public ResponseEntity pageTeacherCondition(@PathVariable Integer current,
                                               @PathVariable Integer limit,
                                               Course courseQuery) {
        Page<Course> page = new Page<>(current, limit);

        QueryWrapper<Course> wrapper = new QueryWrapper<>();

        String title = courseQuery.getTitle();
        String status = courseQuery.getStatus();

        if (!StringUtils.isEmpty(title)) {
            wrapper.like("title", title);
        }
        if (!StringUtils.isEmpty(status)) {
            wrapper.eq("status", status);
        }

        courseService.page(page, wrapper);

        return ResponseEntity.success()
                .message("获取成功")
                .data("rows", page.getRecords())
                .data("total", page.getTotal());
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteCourse(@PathVariable("id") String id) {
        courseService.deleteCourseById(id);
        return ResponseEntity.success();
    }

}

