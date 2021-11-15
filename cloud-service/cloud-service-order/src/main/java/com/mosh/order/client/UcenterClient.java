package com.mosh.order.client;

import com.mosh.entity.MemberOrder;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/9 9:20
 */
@Component
@FeignClient("cloud-service-ucenter")
public interface UcenterClient {
    @GetMapping("ucenter/member/feign/order/{id}")
    MemberOrder getMemberOrder(@PathVariable("id") String id);
}
