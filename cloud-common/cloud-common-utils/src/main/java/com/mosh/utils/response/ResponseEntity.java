package com.mosh.utils.response;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/8 14:36
 */
@Data
public class ResponseEntity {

    private Integer code;

    private String message;

    private Map<String, Object> data = new HashMap<>();

    private ResponseEntity() {
    }

    public static ResponseEntity createResponse() {
        return new ResponseEntity();
    }

    public static ResponseEntity success() {
        return createResponse().code(ResultCode.SUCCESS);
    }

    public static ResponseEntity error() {
        return createResponse().code(ResultCode.ERROR);
    }


    public ResponseEntity code(Integer code) {
        this.setCode(code);
        return this;
    }

    public ResponseEntity message(String message) {
        this.setMessage(message);
        return this;
    }

    public ResponseEntity data(String index, Object value) {
        this.getData().put(index, value);
        return this;
    }

    public ResponseEntity data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

}
