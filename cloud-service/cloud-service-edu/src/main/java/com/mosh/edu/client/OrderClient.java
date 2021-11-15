package com.mosh.edu.client;

import com.mosh.utils.response.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/11 10:07
 */
@Component
@FeignClient("cloud-service-order")
public interface OrderClient {

    @GetMapping("order/order/feign/checkPay/{courseId}/{memberId}")
    Boolean getIsPay(@PathVariable("courseId") String courseId, @PathVariable("memberId") String memberId);

}
