package com.mosh.comment.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mosh.comment.annotation.QueryField;
import com.mosh.comment.entity.CommentCourse;
import com.mosh.comment.entity.Reply;
import com.mosh.comment.entity.ReplyCourse;
import com.mosh.comment.entity.vo.CommentVo;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/18 9:27
 */
public class MapperUtils {

    public static <T> Page<T> getPage(Class<T> clazz, BaseMapper<T> mapper, String QueryId, Integer current, Integer limit) {
        Page<T> page = new Page<>(current, limit);

        QueryWrapper<T> wrapper = new QueryWrapper<>();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            QueryField annotation = field.getAnnotation(QueryField.class);
            if (annotation != null) {
                wrapper.eq(annotation.column(), QueryId);
                break;
            }
        }
        mapper.selectPage(page, wrapper);


        return page;
    }

    public static <T, E extends Reply> List<CommentVo> getRows(Page<T> page, BaseMapper<E> mapper) {
        List<CommentVo> rows = new ArrayList<>();
        for (T t : page.getRecords()) {
            QueryWrapper<E> wrapper = new QueryWrapper<>();
            CommentVo commentVo = new CommentVo();
            BeanUtils.copyProperties(t, commentVo);
            wrapper.eq("parent_id", commentVo.getId());
            List<E> replyList = mapper.selectList(wrapper);
            commentVo.setReplyList(new ArrayList<>(replyList));
            rows.add(commentVo);
        }
        return rows;
    }

}
