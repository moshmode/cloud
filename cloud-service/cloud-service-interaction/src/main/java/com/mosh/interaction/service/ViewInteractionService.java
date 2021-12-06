package com.mosh.interaction.service;

import com.mosh.interaction.entity.ViewInteraction;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 关注 服务类
 * </p>
 *
 * @author mosh
 * @since 2021-12-03
 */
public interface ViewInteractionService extends IService<ViewInteraction> {

    Map<String, Object> getViewByPage(Integer current, Integer limit, String fromMemberId);

    void cancelView(String memberId, String fromMemberId);

    Boolean getView(String memberId, String fromMemberId);
}
