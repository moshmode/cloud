package com.mosh.order.mapper;

import com.mosh.order.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单 Mapper 接口
 * </p>
 *
 * @author mosh
 * @since 2021-11-08
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
