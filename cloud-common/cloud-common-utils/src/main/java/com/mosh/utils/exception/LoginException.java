package com.mosh.utils.exception;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/6 12:03
 */
public class LoginException extends CloudException {
    public LoginException(){
        this.code = 203;
        this.info = "登录失败";
    }
}
