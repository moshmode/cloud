package com.mosh.statistics.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/11 13:28
 */
@Component
@FeignClient("cloud-service-ucenter")
public interface UcenterClient {
    @GetMapping("ucenter/member/feign/statistics/register/{day}")
    public Integer countRegister(@PathVariable("day") String day);
}
