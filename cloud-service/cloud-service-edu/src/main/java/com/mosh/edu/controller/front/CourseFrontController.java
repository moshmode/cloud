package com.mosh.edu.controller.front;

import com.mosh.edu.entity.query.CourseQuery;
import com.mosh.edu.service.CourseService;
import com.mosh.utils.jwt.JwtUtils;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Description
 * 课程前台控制器
 *
 * @author mosh
 * @date 2021/11/8 13:07
 */
@RestController
@RequestMapping("edu/course/front")
public class CourseFrontController {

    @Resource
    CourseService courseService;

    @PostMapping("page/{current}/{limit}")
    public ResponseEntity getCourseList(@PathVariable Integer current,
                                        @PathVariable Integer limit,
                                        CourseQuery query) throws IllegalAccessException {
        return ResponseEntity.success().data(courseService.getCourseByPage(current, limit, query));
    }

    @GetMapping("{id}")
    public ResponseEntity getCourseInfo(@PathVariable("id") String id, HttpServletRequest request) {
        return ResponseEntity.success().data("courseInfo", courseService.getCourseClientInfoVo(id, JwtUtils.getMemberIdByRequest(request)));
    }

    @GetMapping("/hot")
    public ResponseEntity getHotData() {
        return ResponseEntity.success().data("courseList", courseService.getHotCourses());
    }


}
