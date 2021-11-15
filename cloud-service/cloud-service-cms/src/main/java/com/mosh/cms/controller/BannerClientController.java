package com.mosh.cms.controller;

import com.mosh.cms.entity.CrmBanner;
import com.mosh.cms.service.CrmBannerService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/4 17:43
 */
@RestController
@RequestMapping("/cms/banner/client")
public class BannerClientController {

    @Resource
    CrmBannerService bannerService;


    @GetMapping
    public ResponseEntity getBanners() {
        List<CrmBanner> list = bannerService.getBanners();
        return ResponseEntity.success().data("bannerList", list);
    }

}
