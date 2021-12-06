package com.mosh.cms.controller.back;


import com.mosh.cms.entity.CrmBanner;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author mosh
 * @since 2021-11-04
 */
@RestController
@RequestMapping("/cms/banner/admin")
public class BannerBackController {
    @GetMapping("{id}")
    public ResponseEntity getBanner(@PathVariable("id") String id) {

        return ResponseEntity.success();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteBanner(@PathVariable("id") String id) {

        return ResponseEntity.success();
    }

    @PostMapping
    public ResponseEntity addBanner(@RequestBody CrmBanner banner) {

        return ResponseEntity.success();
    }

    @PutMapping
    public ResponseEntity updateBanner(@RequestBody CrmBanner banner) {

        return ResponseEntity.success();
    }
}

