package com.mosh.edu.controller.feign;

import com.mosh.edu.service.CourseService;
import com.mosh.entity.CourseOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/12 11:25
 */
@RestController
@RequestMapping("edu/course/feign")
public class CourseFeignController {
    @Resource
    CourseService courseService;

    @GetMapping("order/{id}")
    public CourseOrder getCourseOrder(@PathVariable("id") String id) {
        return courseService.getCourseOrder(id);
    }

}
