package com.mosh.utils.exception;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/25 20:13
 */
public class SaveException extends CloudException {

    public SaveException(){
        this.code = 202;
        this.info = "添加失败";
    }
}
