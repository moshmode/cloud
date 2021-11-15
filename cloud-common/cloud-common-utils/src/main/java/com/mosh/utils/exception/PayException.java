package com.mosh.utils.exception;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/10 22:15
 */
public class PayException extends CloudException {
    public PayException(){
        this.code = 205;
        this.info = "支付失败";
    }
}
