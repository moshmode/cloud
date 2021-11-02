package com.mosh.edu.mapper;

import com.mosh.edu.entity.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 讲师 Mapper 接口
 * </p>
 *
 * @author mosh
 * @since 2021-10-08
 */
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

}
