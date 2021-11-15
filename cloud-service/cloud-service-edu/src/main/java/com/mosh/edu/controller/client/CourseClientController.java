package com.mosh.edu.controller.client;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mosh.edu.entity.Course;
import com.mosh.edu.entity.Teacher;
import com.mosh.edu.entity.vo.client.CourseClientInfoVo;
import com.mosh.edu.entity.vo.course.info.CourseInfoVo;
import com.mosh.edu.service.CourseService;
import com.mosh.edu.service.TeacherService;
import com.mosh.entity.CourseOrder;
import com.mosh.utils.jwt.JwtUtils;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/8 13:07
 */
@RestController
@RequestMapping("edu/course/client")
public class CourseClientController {

    @Resource
    CourseService courseService;

    @PostMapping("page/{current}/{limit}")
    public ResponseEntity getCourseList(@PathVariable Integer current,
                                        @PathVariable Integer limit,
                                        Course courseQuery) {
        Page<Course> page = new Page<>(current, limit);

        QueryWrapper<Course> wrapper = new QueryWrapper<>();

        String title = courseQuery.getTitle();
        String teacherId = courseQuery.getTeacherId();
        String subjectId = courseQuery.getSubjectId();
        String subjectParentId = courseQuery.getSubjectParentId();

        if (!StringUtils.isEmpty(title)) {
            wrapper.like("title", title);
        }
        if (!StringUtils.isEmpty(teacherId)) {
            wrapper.eq("teacher_id", teacherId);
        }
        if (!StringUtils.isEmpty(subjectId)) {
            wrapper.eq("subject_id", subjectId);
        }
        if (!StringUtils.isEmpty(subjectParentId)) {
            wrapper.eq("subject_parent_id", subjectParentId);
        }
        wrapper.eq("status", "Normal");

        courseService.page(page, wrapper);

        return ResponseEntity.success()
                .message("获取成功")
                .data("rows", page.getRecords())
                .data("total", page.getTotal());
    }

    @GetMapping("{id}")
    public ResponseEntity getCourseInfo(@PathVariable("id") String id, HttpServletRequest request) {
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        CourseClientInfoVo courseClientInfoVo = courseService.getCourseClientInfoVo(id, memberId);

        return ResponseEntity.success().data("courseInfo", courseClientInfoVo);
    }


}
