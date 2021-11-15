package com.mosh.edu.controller.client;

import com.mosh.edu.entity.Course;
import com.mosh.edu.entity.Teacher;
import com.mosh.edu.service.CourseService;
import com.mosh.edu.service.TeacherService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/4 21:12
 */
@RestController
@RequestMapping("/edu/client")
public class ClientController {

    @Resource
    TeacherService teacherService;

    @Resource
    CourseService courseService;

    @GetMapping("/hot")
    public ResponseEntity getHotData() {
        List<Teacher> teacherList = teacherService.getHotTeachers();
        List<Course> courseList = courseService.getHotCourses();

        return ResponseEntity.success().data("teacherList", teacherList).data("courseList", courseList);
    }

}
