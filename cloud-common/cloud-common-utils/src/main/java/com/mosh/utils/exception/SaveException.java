package com.mosh.utils.exception;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/25 20:13
 */
public class SaveException extends Exception {
    private Integer code = 202;

    private String info = "添加失败";

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
