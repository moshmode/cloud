package com.mosh.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mosh.edu.entity.Teacher;
import com.mosh.edu.mapper.TeacherMapper;
import com.mosh.edu.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author mosh
 * @since 2021-10-08
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Resource
    TeacherMapper teacherMapper;

    @Cacheable("teacherList")
    @Override
    public List<Teacher> getHotTeachers() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("sort");
        wrapper.last("limit 4");

        return teacherMapper.selectList(wrapper);
    }
}
