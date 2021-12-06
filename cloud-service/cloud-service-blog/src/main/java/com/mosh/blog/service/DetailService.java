package com.mosh.blog.service;

import com.mosh.blog.entity.Detail;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mosh.blog.entity.vo.DetailVo;

import java.util.Map;

/**
 * <p>
 * 博客 服务类
 * </p>
 *
 * @author mosh
 * @since 2021-11-15
 */
public interface DetailService extends IService<Detail> {

    DetailVo getDetailByBlogId(String blogId);

    String addDetail(Detail detail);

    Map<String, Object> getDraftListByPage(Integer current, Integer limit, Detail detail);
}
