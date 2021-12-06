package com.mosh.interaction.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mosh.interaction.entity.ViewInteraction;
import com.mosh.interaction.mapper.ViewInteractionMapper;
import com.mosh.interaction.service.ViewInteractionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 关注 服务实现类
 * </p>
 *
 * @author mosh
 * @since 2021-12-03
 */
@Service
public class ViewInteractionServiceImpl extends ServiceImpl<ViewInteractionMapper, ViewInteraction> implements ViewInteractionService {

    @Resource
    ViewInteractionMapper viewInteractionMapper;


    @Override
    public Map<String, Object> getViewByPage(Integer current, Integer limit, String fromMemberId) {
        Page<ViewInteraction> page = new Page<>(current, limit);
        viewInteractionMapper.selectPage(page, new QueryWrapper<ViewInteraction>().eq("from_member_id", fromMemberId));
        Map<String, Object> map = new HashMap<>();
        map.put("rows", page.getRecords());
        map.put("total", page.getTotal());
        return map;

    }

    @Override
    public void cancelView(String memberId, String fromMemberId) {
        viewInteractionMapper.delete(new QueryWrapper<ViewInteraction>().eq("member_id", memberId).eq("from_member_id", fromMemberId));
    }

    @Override
    public Boolean getView(String memberId, String fromMemberId) {
        return viewInteractionMapper.selectCount(new QueryWrapper<ViewInteraction>().eq("member_id", memberId).eq("from_member_id", fromMemberId)) == 1;
    }

}
