package com.mosh.db.menu;

/**
 * Description
 * 查询方式
 * @author mosh
 * @date 2021/11/22 10:49
 */
public enum QueryType {

    /**
     * 相等
     */
    EQ,

    /**
     * 模糊
     */
    LIKE,

    /**
     * 大于
     */
    GE,

    /**
     * 小于
     */
    LE,

    /**
     * 排列
     */
    ORDER_BY_DESC
}
