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
public class ExcelNullException extends CloudException {
    public ExcelNullException(){
        this.code = 201;
        this.info = "Excel文件为空";
    }
}
