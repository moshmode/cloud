package com.mosh.edu.entity.query;

import com.mosh.edu.entity.Teacher;
import com.mosh.db.annotation.QueryField;
import com.mosh.db.menu.QueryType;
import com.mosh.db.query.Query;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/8 18:23
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TeacherQuery extends Query<Teacher> {

    @QueryField(column = "name", type = QueryType.LIKE)
    private String name;

    @QueryField(column = "level", type = QueryType.EQ)
    private Integer level;

    @QueryField(column = "career", type = QueryType.EQ)
    private String career;

    @QueryField(column = "gmtCreate", type = QueryType.GE)
    private String begin;

    @QueryField(column = "gmtCreate", type = QueryType.LE)
    private String end;
}
