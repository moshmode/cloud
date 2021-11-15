package com.mosh.vod.controller.feign;

import com.mosh.utils.response.ResponseEntity;
import com.mosh.vod.service.VodService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/12 11:18
 */
@RestController
@RequestMapping(("vod/feign"))
public class VodFeignController {

    @Resource
    VodService vodService;

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable("id") String id) {
        vodService.deleteById(id);
        return true;
    }

    @DeleteMapping("deleteBatch")
    public Boolean deleteBatch(@RequestParam("videoIdList") List<String> videoIdList) {
        vodService.remove(videoIdList);
        return true;
    }
}
