package com.mosh.edu.mapper;

import com.mosh.edu.entity.Subject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 课程科目 Mapper 接口
 * </p>
 *
 * @author mosh
 * @since 2021-10-15
 */
@Mapper
public interface SubjectMapper extends BaseMapper<Subject> {

}
