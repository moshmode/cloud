package com.mosh.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mosh.edu.entity.Chapter;
import com.mosh.edu.entity.Video;
import com.mosh.edu.mapper.VideoMapper;
import com.mosh.edu.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author mosh
 * @since 2021-10-25
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

    @Resource
    VideoMapper videoMapper;

    @Override
    public void deleteByCourseId(String courseId) {
        QueryWrapper<Video> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", courseId);
        videoMapper.delete(wrapper);
    }
}
