package com.mosh.edu.client;

import com.mosh.utils.response.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Description
 *
 * @author mosh
 * @date 2021/11/4 10:30
 */
@FeignClient(name = "vodClient", fallback = VodDegradeFeignClient.class)
@Component
public interface VodClient {
    @DeleteMapping("vod/feign/{id}")
    Boolean delete(@PathVariable("id") String id);

    @DeleteMapping("vod/feign/deleteBatch")
    Boolean deleteBatch(@RequestParam("videoIdList") List<String> videoIdList);

}
