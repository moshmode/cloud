package com.mosh.utils.exception.handler;

import com.mosh.utils.exception.CloudException;
import com.mosh.utils.exception.LoginException;
import com.mosh.utils.exception.SaveException;
import com.mosh.utils.response.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/9 17:01
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return ResponseEntity.error().message("服务器运行产生异常");
    }

    @ResponseBody
    @ExceptionHandler(CloudException.class)
    public ResponseEntity handleLoginException(CloudException e) {
        log.error(e.getInfo());
        e.printStackTrace();
        return ResponseEntity.createResponse().code(e.getCode()).message(e.getInfo());
    }


}
