package com.mosh.obs.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/14 19:41
 */
public interface OBSService {


    String uploadTeacherAvatar(MultipartFile file);

    String uploadBlogCover(MultipartFile file);

    void deleteBlogCover(String url);
}
