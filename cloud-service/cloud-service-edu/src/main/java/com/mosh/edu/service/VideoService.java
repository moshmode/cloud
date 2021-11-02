package com.mosh.edu.service;

import com.mosh.edu.entity.Video;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author mosh
 * @since 2021-10-25
 */
public interface VideoService extends IService<Video> {

    void deleteByCourseId(String courseId);
}
