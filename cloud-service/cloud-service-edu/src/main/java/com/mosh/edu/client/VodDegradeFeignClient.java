package com.mosh.edu.client;

import com.mosh.utils.response.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/4 13:10
 */
@Component
public class VodDegradeFeignClient implements VodClient {

    @Override
    public Boolean delete(String id) {
        return false;
    }
    @Override
    public Boolean deleteBatch(List<String> videoIdList) {
        return false;
    }
}
