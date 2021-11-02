package com.mosh.obs.controller;

import com.mosh.obs.service.AvatarOBSService;
import com.mosh.utils.response.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/14 20:07
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("obs/avatar")
public class AvatarOBSController {

    @Resource
    private AvatarOBSService avatarOBSService;

    @PostMapping
    public ResponseEntity upload(MultipartFile file) {
        log.info(file.getName());
        return ResponseEntity.success().data("url", avatarOBSService.upload(file));
    }

}
