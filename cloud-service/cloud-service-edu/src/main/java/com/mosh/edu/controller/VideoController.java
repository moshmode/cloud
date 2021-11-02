package com.mosh.edu.controller;


import com.mosh.edu.entity.Video;
import com.mosh.edu.mapper.VideoMapper;
import com.mosh.edu.service.VideoService;
import com.mosh.utils.response.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author mosh
 * @since 2021-10-25
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/edu/video")
public class VideoController {

    @Resource
    VideoService videoService;

    @PostMapping
    public ResponseEntity addVideo(@RequestBody Video video) {
        log.info(video.toString());
        videoService.save(video);
        return ResponseEntity.success();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteVideo(@PathVariable("id") String id) {
        videoService.removeById(id);
        return ResponseEntity.success();
    }

    @GetMapping("{id}")
    public ResponseEntity getVideo(@PathVariable("id") String id) {
        Video video = videoService.getById(id);
        return ResponseEntity.success().data("video", video);
    }

    @PutMapping
    public ResponseEntity updateVideo(@RequestBody Video video) {
        videoService.updateById(video);
        return ResponseEntity.success();
    }

}

