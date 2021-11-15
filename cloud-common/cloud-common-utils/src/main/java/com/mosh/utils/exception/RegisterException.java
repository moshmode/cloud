package com.mosh.utils.exception;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/6 13:36
 */
public class RegisterException extends CloudException {
    public RegisterException() {
        this.code = 204;
        this.info = "注册失败";
    }
}
