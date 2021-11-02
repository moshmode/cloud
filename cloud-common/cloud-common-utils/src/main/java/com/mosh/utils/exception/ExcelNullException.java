package com.mosh.utils.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/15 19:30
 */
public class ExcelNullException extends RuntimeException {
    private Integer code = 201;

    private String info = "Excel文件为空";

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
