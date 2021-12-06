package com.mosh.forum.entity.query;

import com.mosh.forum.entity.Label;
import lombok.Data;

import java.util.List;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/20 11:36
 */
@Data
public class QuestionQuery {

    private String id;

    private String memberId;

    private String name;

    private String title;

    private List<String> labels;

    private String status;

    private String begin;

    private String end;

    private Integer order;


}
