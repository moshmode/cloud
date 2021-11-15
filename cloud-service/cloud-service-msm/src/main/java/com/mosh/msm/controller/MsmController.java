package com.mosh.msm.controller;

import com.mosh.msm.service.MsmService;
import com.mosh.msm.utils.RandomUtil;
import com.mosh.utils.response.ResponseEntity;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/5 19:08
 */
@RestController
@RequestMapping("msm")
public class MsmController {

    @Resource
    MsmService msmService;

    @Resource
    RedisTemplate<String, String> redisTemplate;

    @GetMapping("send/{phone}")
    public ResponseEntity sendMsm(@PathVariable("phone") String phone) {
        if (!StringUtils.isEmpty(redisTemplate.opsForValue().get(phone))) {
            return ResponseEntity.success();
        }

        String code = RandomUtil.getSixBitRandom();
        if (msmService.sendMsm(phone, code)) {
            redisTemplate.opsForValue().set(phone, code, 5, TimeUnit.MINUTES);
            return ResponseEntity.success();
        }
        return ResponseEntity.error().message("短信发送失败");
    }
}
