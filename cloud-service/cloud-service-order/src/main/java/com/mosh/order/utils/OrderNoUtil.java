package com.mosh.order.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/9 9:30
 */
public class OrderNoUtil {

    /**
     * 获取订单号
     */
    public static String getOrderNo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate = sdf.format(new Date());
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            result.append(random.nextInt(10));
        }
        return newDate + result;
    }
}
