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
 * 支付日志表
 * </p>
 *
 * @author mosh
 * @since 2021-11-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_pay_log")
public class PayLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 支付完成时间
     */
    private Date payTime;

    /**
     * 支付金额（分）
     */
    private BigDecimal totalFee;

    /**
     * 交易流水号
     */
    private String transactionId;

    /**
     * 交易状态
     */
    private String tradeState;

    /**
     * 支付类型（1：微信 2：支付宝）
     */
    private Integer payType;

    /**
     * 其他属性
     */
    private String attr;

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
