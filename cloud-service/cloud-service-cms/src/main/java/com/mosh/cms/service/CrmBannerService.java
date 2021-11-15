package com.mosh.cms.service;

import com.mosh.cms.entity.CrmBanner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author mosh
 * @since 2021-11-04
 */
public interface CrmBannerService extends IService<CrmBanner> {

    List<CrmBanner> getBanners();
}
