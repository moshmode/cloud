package com.mosh.edu.mapper;

import com.mosh.edu.entity.Video;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 课程视频 Mapper 接口
 * </p>
 *
 * @author mosh
 * @since 2021-10-25
 */
@Mapper
public interface VideoMapper extends BaseMapper<Video> {

}
