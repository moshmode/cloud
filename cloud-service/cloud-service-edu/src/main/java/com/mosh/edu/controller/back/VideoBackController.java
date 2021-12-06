package com.mosh.edu.controller.back;


import com.mosh.edu.client.VodClient;
import com.mosh.edu.entity.Video;
import com.mosh.edu.service.VideoService;
import com.mosh.utils.exception.SaveException;
import com.mosh.utils.response.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
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
@RestController
@RequestMapping("/edu/video")
public class VideoBackController {

    @Resource
    VideoService videoService;

    @Resource
    VodClient vodClient;

    @PostMapping
    public ResponseEntity addVideo(@RequestBody Video video) {
        log.info(video.toString());
        videoService.save(video);
        return ResponseEntity.success();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteVideo(@PathVariable("id") String id) throws SaveException {
        Video video = videoService.getById(id);

        if (!StringUtils.isEmpty(video.getVideoSourceId())) {
            if (!vodClient.delete(id)) {
                throw new SaveException();
            }
        }

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

