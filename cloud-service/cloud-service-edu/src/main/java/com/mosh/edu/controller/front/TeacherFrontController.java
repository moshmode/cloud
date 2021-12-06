package com.mosh.edu.controller.front;

import com.mosh.edu.entity.Teacher;
import com.mosh.edu.entity.query.TeacherQuery;
import com.mosh.edu.service.TeacherService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description
 * 老师的前台控制器
 * @author mosh
 * @date 2021/11/8 13:07
 */
@RestController
@RequestMapping("edu/teacher/front")
public class TeacherFrontController {

    @Resource
    TeacherService teacherService;

    /**
     * 按id查询老师
     * @param id 老师id
     * @return 老师实体类
     */
    @GetMapping("{id}")
    public ResponseEntity getTeacherById(@PathVariable("id") String id) {
        Teacher teacher = teacherService.getById(id);
        return ResponseEntity.success().data("teacher", teacher);
    }

    /**
     * 分页查询
     *
     * @param current   当前条
     * @param limit 页大小
     * @param query 查询条件
     * @return 查询结果
     */
    @PostMapping("page/{current}/{limit}")
    public ResponseEntity pageTeacherCondition(@PathVariable Integer current,
                                               @PathVariable Integer limit,
                                               TeacherQuery query) throws IllegalAccessException {
        return ResponseEntity.success().data(teacherService.getTeacherByPage(current, limit, query));
    }

    /**
     * 获取老师的热点数据
     * @return 老师的热点数据
     */
    @GetMapping("/hot")
    public ResponseEntity getHotData() {
        return ResponseEntity.success().data("teacherList", teacherService.getHotTeachers());
    }
}
