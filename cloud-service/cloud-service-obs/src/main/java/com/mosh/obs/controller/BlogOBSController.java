package com.mosh.obs.controller;

import com.mosh.obs.service.OBSService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/15 18:27
 */
@RestController
@RequestMapping("obs/blog")
public class BlogOBSController {
    @Resource
    private OBSService obsService;

    @PostMapping("/cover")
    public ResponseEntity upload(MultipartFile file) {
        return ResponseEntity.success().data("url", obsService.uploadBlogCover(file));
    }

    @DeleteMapping("/cover")
    public ResponseEntity delete(@RequestBody String url) {
        obsService.deleteBlogCover(url);
        return ResponseEntity.success();
    }
}
