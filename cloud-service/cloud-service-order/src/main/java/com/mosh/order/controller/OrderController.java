package com.mosh.order.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mosh.order.entity.Order;
import com.mosh.order.service.OrderService;
import com.mosh.utils.jwt.JwtUtils;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author mosh
 * @since 2021-11-08
 */
@RestController
@RequestMapping("order/order")
public class OrderController {
    @Resource
    OrderService orderService;

    @GetMapping("create/{courseId}")
    public ResponseEntity createOrder(@PathVariable("courseId") String courseId, HttpServletRequest request) {
        String orderNo = orderService.createOrder(courseId, JwtUtils.getMemberIdByRequest(request));
        return ResponseEntity.success().data("orderNo", orderNo);
    }

    @GetMapping("{orderId}")
    public ResponseEntity get(@PathVariable String orderId) {
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no", orderId);
        Order order = orderService.getOne(wrapper);
        return ResponseEntity.success().data("order", order);
    }

}

