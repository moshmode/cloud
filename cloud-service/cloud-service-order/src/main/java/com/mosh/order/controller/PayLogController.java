package com.mosh.order.controller;


import com.mosh.order.service.OrderService;
import com.mosh.order.service.PayLogService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 支付日志表 前端控制器
 * </p>
 *
 * @author mosh
 * @since 2021-11-08
 */
@RestController
@RequestMapping("/order/payLog")
public class PayLogController {
    @Resource
    PayLogService payLogService;

    @GetMapping("createNative/{orderNo}")
    public ResponseEntity createNative(@PathVariable("orderNo") String orderNo) {
        Map<String, Object> map = payLogService.createNative(orderNo);
        return ResponseEntity.success().data(map);
    }

    @GetMapping("state/{orderNo}")
    public ResponseEntity getPayState(@PathVariable("orderNo") String orderNo) {
        Map<String,String> map = payLogService.getPayState(orderNo);
        if(map == null) {
            return ResponseEntity.error().message("支付出错了");
        }
        //如果返回map里面不为空，通过map获取订单状态
        if(map.get("trade_state").equals("SUCCESS")) {//支付成功
            //添加记录到支付表，更新订单表订单状态
            payLogService.updateOrdersState(map);
            return ResponseEntity.success().message("支付成功");
        }
        return ResponseEntity.createResponse().code(300).message("支付中");
    }
}

