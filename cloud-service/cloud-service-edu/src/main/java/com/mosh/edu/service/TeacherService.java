package com.mosh.edu.service;

import com.mosh.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mosh.edu.entity.query.TeacherQuery;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author mosh
 * @since 2021-10-08
 */
public interface TeacherService extends IService<Teacher> {

    List<Teacher> getHotTeachers();

    Map<String, Object> getTeacherByPage(Integer current, Integer limit, TeacherQuery query) throws IllegalAccessException;
}
