package com.mosh.forum.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mosh.forum.entity.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mosh.forum.entity.query.QuestionQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 论坛 Mapper 接口
 * </p>
 *
 * @author mosh
 * @since 2021-11-15
 */
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

    List<Question> getQuestionByQuery(IPage<Question> page, @Param("query") QuestionQuery query);

}
