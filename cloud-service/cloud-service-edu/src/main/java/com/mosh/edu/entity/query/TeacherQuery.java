package com.mosh.edu.entity.query;

import lombok.Data;

import java.util.Date;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/8 18:23
 */
@Data
public class TeacherQuery {

    private String name;

    private Integer level;

    private String begin;

    private String end;
}
