package com.mosh.edu.controller.client;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mosh.edu.entity.Teacher;
import com.mosh.edu.entity.query.TeacherQuery;
import com.mosh.edu.service.TeacherService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/8 13:07
 */
@RestController
@RequestMapping("edu/teacher/client")
public class TeacherClientController {

    @Resource
    TeacherService teacherService;

    @GetMapping("{id}")
    public ResponseEntity pageTeacherCondition(@PathVariable("id") String id) {
        Teacher teacher = teacherService.getById(id);
        return ResponseEntity.success().data("teacher", teacher);
    }

    /**
     * 分页查询
     *
     * @param current      当前条
     * @param limit        页大小
     * @param teacherQuery 查询条件
     * @return 查询结果
     */
    @PostMapping("page/{current}/{limit}")
    public ResponseEntity pageTeacherCondition(@PathVariable Integer current,
                                               @PathVariable Integer limit,
                                               Teacher teacherQuery) {
        Page<Teacher> page = new Page<>(current, limit);

        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();

        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String career = teacherQuery.getCareer();

        if (!StringUtils.isEmpty(name)) {
            wrapper.like("name", name);
        }
        if (level != null) {
            wrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(career)) {
            wrapper.like("career", career);
        }

        teacherService.page(page, wrapper);

        return ResponseEntity.success()
                .data("rows", page.getRecords())
                .data("total", page.getTotal());
    }
}
