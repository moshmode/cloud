package com.mosh.obs.controller;

import com.mosh.obs.service.OBSService;
import com.mosh.utils.response.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/14 20:07
 */
@Slf4j
@RestController
@RequestMapping("obs/avatar")
public class AvatarOBSController {

    @Resource
    private OBSService obsService;

    @PostMapping
    public ResponseEntity upload(MultipartFile file) {
        log.info(file.getName());
        return ResponseEntity.success().data("url", obsService.uploadTeacherAvatar(file));
    }

}
