package com.mosh.order.service.impl;

import com.mosh.entity.CourseOrder;
import com.mosh.entity.MemberOrder;
import com.mosh.order.client.EduClient;
import com.mosh.order.client.UcenterClient;
import com.mosh.order.entity.Order;
import com.mosh.order.mapper.OrderMapper;
import com.mosh.order.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mosh.order.utils.OrderNoUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author mosh
 * @since 2021-11-08
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Resource
    EduClient eduClient;

    @Resource
    UcenterClient ucenterClient;

    @Resource
    OrderMapper orderMapper;

    @Override
    public String createOrder(String courseId, String memberId) {
        //通过远程调用根据用户id获取用户信息
        MemberOrder memberOrder = ucenterClient.getMemberOrder(memberId);
        //通过远程调用根据课程id获取课信息
        CourseOrder courseOrder = eduClient.getCourseOrder(courseId);
        //创建Order对象，向order对象里面设置需要数据
        Order order = new Order();
        order.setOrderNo(OrderNoUtil.getOrderNo());//订单号
        order.setCourseId(courseId); //课程id
        order.setCourseTitle(courseOrder.getTitle());
        order.setCourseCover(courseOrder.getCover());
        order.setTeacherName(courseOrder.getTeacherName());
        order.setTotalFee(courseOrder.getPrice());
        order.setMemberId(memberId);
        order.setMobile(memberOrder.getMobile());
        order.setNickname(memberOrder.getNickname());
        order.setState(0);  //订单状态（0：未支付 1：已支付）
        order.setPayType(1);  //支付类型 ，微信1

        orderMapper.insert(order);
        //返回订单号
        return order.getOrderNo();
    }
}
