package com.mosh.db.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mosh.db.annotation.QueryField;
import com.mosh.db.menu.QueryType;
import com.mosh.db.query.Query;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/21 19:20
 */
public class MapperUtils {
    public static <T, E extends Query<T>> Page<T> getPage(BaseMapper<T> mapper, E query, Integer current, Integer limit) throws IllegalAccessException {
        Page<T> page = new Page<>(current, limit);
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        Class<?> clazz = query.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object val = field.get(query);
            QueryField annotation = field.getAnnotation(QueryField.class);
            if (annotation != null && !StringUtils.isEmpty(val)) {
                QueryType type = annotation.type();
                switch (type) {
                    case EQ:
                        wrapper.eq(annotation.column(), val);
                        break;
                    case LIKE:
                        wrapper.like(annotation.column(), val);
                        break;
                    case GE:
                        wrapper.ge(annotation.column(), val);
                        break;
                    case LE:
                        wrapper.le(annotation.column(), val);
                        break;
                    case ORDER_BY_DESC:
                        wrapper.orderByDesc((String) val);
                        break;
                    default:
                        break;
                }
            }
        }
        mapper.selectPage(page, wrapper);
        return page;
    }
}
