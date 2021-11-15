package com.mosh.vod.service;

import com.aliyuncs.exceptions.ClientException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/3 20:10
 */
public interface VodService {
    String upload(MultipartFile file);
    //删除多个阿里云视频的方法
    void remove(List<String> videoIdList);

    void deleteById(String id);

    String getPlayAuthById(String id) throws ClientException;
}
