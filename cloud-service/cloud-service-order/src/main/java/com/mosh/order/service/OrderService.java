package com.mosh.order.service;

import com.mosh.order.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author mosh
 * @since 2021-11-08
 */
public interface OrderService extends IService<Order> {

    String createOrder(String courseId, String memberIdByJwtToken);
}
