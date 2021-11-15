package com.mosh.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mosh.cms.entity.CrmBanner;
import com.mosh.cms.mapper.CrmBannerMapper;
import com.mosh.cms.service.CrmBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 首页banner表 服务实现类
 * </p>
 *
 * @author mosh
 * @since 2021-11-04
 */
@Service
public class CrmBannerServiceImpl extends ServiceImpl<CrmBannerMapper, CrmBanner> implements CrmBannerService {

    @Resource
    CrmBannerMapper bannerMapper;

    @Cacheable("banner")
    @Override
    public List<CrmBanner> getBanners() {
        QueryWrapper<CrmBanner> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("sort");
        return bannerMapper.selectList(wrapper);
    }
}
