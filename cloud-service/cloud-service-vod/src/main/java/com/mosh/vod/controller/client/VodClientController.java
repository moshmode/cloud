package com.mosh.vod.controller.client;

import com.aliyuncs.exceptions.ClientException;
import com.mosh.utils.response.ResponseEntity;
import com.mosh.vod.service.VodService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/8 15:19
 */
@RestController
@RequestMapping(("vod/client"))
public class VodClientController {

    @Resource
    VodService vodService;

    @GetMapping("{id}")
    public ResponseEntity getPlayAuthById(@PathVariable("id") String id) throws Exception {
        String playAuth = vodService.getPlayAuthById(id);
        return ResponseEntity.success().data("playAuth",playAuth);
    }
}
