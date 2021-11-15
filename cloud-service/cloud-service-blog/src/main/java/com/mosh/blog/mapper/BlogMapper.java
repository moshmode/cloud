package com.mosh.blog.mapper;

import com.mosh.blog.entity.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 博客 Mapper 接口
 * </p>
 *
 * @author mosh
 * @since 2021-11-14
 */
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {

}
