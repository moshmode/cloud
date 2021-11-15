package com.mosh.order.client;

import com.mosh.entity.CourseOrder;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/9 9:19
 */
@Component
@FeignClient("cloud-service-edu")
public interface EduClient {
    @GetMapping("edu/course/feign/order/{id}")
    CourseOrder getCourseOrder(@PathVariable("id") String id);
}
