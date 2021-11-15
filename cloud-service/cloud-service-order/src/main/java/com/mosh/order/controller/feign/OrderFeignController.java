package com.mosh.order.controller.feign;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mosh.order.entity.Order;
import com.mosh.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/12 11:23
 */
@RestController
@RequestMapping("order/order/feign")
public class OrderFeignController {

    @Resource
    OrderService orderService;

    //根据课程id和用户id查询订单表中订单状态
    @GetMapping("checkPay/{courseId}/{memberId}")
    public Boolean getIsPay(@PathVariable String courseId, @PathVariable String memberId) {
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", courseId);
        wrapper.eq("member_id", memberId);
        wrapper.eq("state", 1);//支付状态 1代表已经支付

        return orderService.count(wrapper) > 0;
    }
}
