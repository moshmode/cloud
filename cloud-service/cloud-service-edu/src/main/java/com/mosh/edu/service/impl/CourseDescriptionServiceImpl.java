package com.mosh.edu.service.impl;

import com.mosh.edu.entity.CourseDescription;
import com.mosh.edu.mapper.CourseDescriptionMapper;
import com.mosh.edu.service.CourseDescriptionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程简介 服务实现类
 * </p>
 *
 * @author mosh
 * @since 2021-10-25
 */
@Service
public class CourseDescriptionServiceImpl extends ServiceImpl<CourseDescriptionMapper, CourseDescription> implements CourseDescriptionService {

}
