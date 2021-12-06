package com.mosh.interaction.service;

import com.mosh.interaction.entity.BlogInteraction;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 博客互动 服务类
 * </p>
 *
 * @author mosh
 * @since 2021-11-23
 */
public interface BlogInteractionService extends IService<BlogInteraction> {

    String addInteraction(BlogInteraction blog);

    BlogInteraction getInteraction(String blogId,String memberId);

    Map<String, Object> countInteraction(String blogId);

    Integer deleteInteraction(String blogId);

    List<String> getCollectedByMemberId(String memberId);
}
