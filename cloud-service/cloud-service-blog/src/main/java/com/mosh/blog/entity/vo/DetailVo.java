package com.mosh.blog.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/15 11:17
 */
@Data
public class DetailVo {

    private String id;

    private String blogId;

    private String memberId;

    private String name;

    private String avatar;

    private String title;

    private String content;

    private Date releaseTime;

    private Date updateTime;
}
