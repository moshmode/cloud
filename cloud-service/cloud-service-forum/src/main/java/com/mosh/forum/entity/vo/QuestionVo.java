package com.mosh.forum.entity.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.mosh.forum.entity.Label;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/21 15:20
 */
@Data
public class QuestionVo {

    /**
     * 问题ID
     */
    private String id;

    /**
     * 作者ID
     */
    private String memberId;

    /**
     * 作者名字
     */
    private String name;

    /**
     * 作者头像
     */
    private String avatar;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 浏览数量
     */
    private Long viewCount;

    /**
     * 标签列表
     */
    private List<Label> labels;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtModified;
}
