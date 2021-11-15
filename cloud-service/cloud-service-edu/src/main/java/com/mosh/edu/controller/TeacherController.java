package com.mosh.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mosh.edu.entity.Teacher;
import com.mosh.edu.entity.query.TeacherQuery;
import com.mosh.edu.service.TeacherService;
import com.mosh.utils.response.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author mosh
 * @since 2021-10-08
 */
@Slf4j
@RestController
@RequestMapping("edu/teacher")
public class TeacherController {

    @Resource
    TeacherService teacherService;

    @GetMapping("{id}")
    public ResponseEntity getTeacherById(@PathVariable("id") String id) {
        Teacher teacher = teacherService.getById(id);
        if (teacher == null) {
            return ResponseEntity.error().message("没有指定参数，请求失败");
        }
        return ResponseEntity.success().message("获取成功").data("teacher", teacher);
    }

    @GetMapping
    public ResponseEntity getTeachers() {
        List<Teacher> list = teacherService.list(null);
        if (list == null) {
            return ResponseEntity.error().message("没有指定参数，请求失败");
        }
        return ResponseEntity.success().message("获取成功").data("teacherList", list);
    }

    /**
     * 逻辑删除
     *
     * @param id 讲师id
     * @return 删除结果
     */
    @DeleteMapping("{id}")
    public ResponseEntity removeById(@PathVariable String id) {
        if (teacherService.removeById(id)) {
            return ResponseEntity.success().message("删除成功");
        }
        return ResponseEntity.error().message("没有指定参数，请求失败");
    }

    /**
     * 分页查询
     *
     * @param current 当前条
     * @param limit   页大小
     * @param teacherQuery 查询条件
     * @return 查询结果
     */
    @PostMapping("page/{current}/{limit}")
    public ResponseEntity pageTeacherCondition(@PathVariable Integer current,
                                               @PathVariable Integer limit,
                                               TeacherQuery teacherQuery) {
        Page<Teacher> page = new Page<>(current, limit);

        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();

        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();

        if (!StringUtils.isEmpty(name)) {
            wrapper.like("name", name);
        }
        if (level != null) {
            wrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create", begin);
        }
        if (!StringUtils.isEmpty(end)) {
            wrapper.le("gmt_create", end);
        }

        teacherService.page(page, wrapper);

        return ResponseEntity.success()
                .message("获取成功")
                .data("rows", page.getRecords())
                .data("total", page.getTotal());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Teacher teacher) {
        log.info(teacher.toString());
        teacherService.save(teacher);
        return ResponseEntity.success().message("添加成功");
    }

    @PutMapping("{id}")
    public ResponseEntity updateById(@PathVariable String id,
                                     @RequestBody Teacher teacher) {
        teacher.setId(id);
        teacherService.updateById(teacher);
        return ResponseEntity.success().message("更新成功");
    }


}

