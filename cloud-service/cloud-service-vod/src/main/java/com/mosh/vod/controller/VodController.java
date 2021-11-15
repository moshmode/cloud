package com.mosh.vod.controller;

import com.mosh.utils.response.ResponseEntity;
import com.mosh.vod.service.VodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/3 20:07
 */
@RestController
@RequestMapping(("vod"))
public class VodController {

    @Resource
    VodService vodService;

    @PostMapping
    public ResponseEntity upload(MultipartFile file) {
        String id = vodService.upload(file);
        return ResponseEntity.success().data("id", id);
    }

}
