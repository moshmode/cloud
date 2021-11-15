package com.mosh.utils.exception;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/6 12:27
 */
public abstract class CloudException extends RuntimeException {
    protected Integer code = 299;

    protected String info = "执行失败";

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
