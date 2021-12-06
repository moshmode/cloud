package com.mosh.edu.controller.back;


import com.mosh.edu.entity.Course;
import com.mosh.edu.entity.query.CourseQuery;
import com.mosh.edu.entity.vo.course.info.CourseInfoVo;
import com.mosh.edu.service.CourseService;
import com.mosh.utils.exception.SaveException;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 课程 后台控制器
 * </p>
 *
 * @author mosh
 * @since 2021-10-25
 */
@RestController
@RequestMapping("/edu/course")
public class CourseBackController {

    @Resource
    CourseService courseService;

    @PostMapping
    public ResponseEntity addCourseInfo(@RequestBody CourseInfoVo courseInfoVo) throws SaveException {
        return ResponseEntity.success().data("id", courseService.saveCourseInfo(courseInfoVo));
    }

    @GetMapping("{id}")
    public ResponseEntity getCourseInfo(@PathVariable("id") String id) {
        return ResponseEntity.success().data("courseInfoVo", courseService.getCourseInfo(id));
    }

    @PutMapping
    public ResponseEntity updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo) throws SaveException {
        courseService.updateCourseInfo(courseInfoVo);
        return ResponseEntity.success();
    }

    @GetMapping("publishInfo/{courseId}")
    public ResponseEntity getCoursePublishInfo(@PathVariable("courseId") String courseId) {
        return ResponseEntity.success().data("coursePublishVo", courseService.getCoursePublishInfo(courseId));
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
    public ResponseEntity getCourseByPage(@PathVariable Integer current,
                                          @PathVariable Integer limit,
                                          CourseQuery query) throws IllegalAccessException {
        return ResponseEntity.success().data(courseService.getCourseByPage(current, limit, query));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteCourse(@PathVariable("id") String id) {
        courseService.deleteCourseById(id);
        return ResponseEntity.success();
    }

}

