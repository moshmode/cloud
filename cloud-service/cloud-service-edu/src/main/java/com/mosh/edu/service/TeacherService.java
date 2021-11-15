package com.mosh.edu.service;

import com.mosh.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

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
}
