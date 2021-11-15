package com.mosh.order.service;

import com.mosh.order.entity.PayLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 支付日志表 服务类
 * </p>
 *
 * @author mosh
 * @since 2021-11-08
 */
public interface PayLogService extends IService<PayLog> {

    Map<String, Object> createNative(String orderNo);

    Map<String, String> getPayState(String orderNo);

    void updateOrdersState(Map<String, String> map);
}
