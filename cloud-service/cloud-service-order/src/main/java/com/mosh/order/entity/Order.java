package com.mosh.order.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author mosh
 * @since 2021-11-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 课程id
     */
    private String courseId;

    /**
     * 课程名称
     */
    private String courseTitle;

    /**
     * 课程封面
     */
    private String courseCover;

    /**
     * 讲师名称
     */
    private String teacherName;

    /**
     * 会员id
     */
    private String memberId;

    /**
     * 会员昵称
     */
    private String nickname;

    /**
     * 会员手机
     */
    private String mobile;

    /**
     * 订单金额（分）
     */
    private BigDecimal totalFee;

    /**
     * 支付类型（1：微信 2：支付宝）
     */
    private Integer payType;

    /**
     * 订单状态（0：未支付 1：已支付）
     */
    private Integer state;

    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    @TableLogic
    private Integer isDeleted;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;



}
