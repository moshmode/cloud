package com.mosh.utils.response.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Description
 *
 * @author mosh
 * @date 2021/11/12 15:39
 */
public class ResponseUtils {

    public static void out(HttpServletResponse response, ResponseEntity r) {
        ObjectMapper mapper = new ObjectMapper();
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        try {
            mapper.writeValue(response.getWriter(), r);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
