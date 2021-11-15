package com.mosh.comment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/9 12:50
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.mosh")
public class CommentApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommentApplication.class, args);
    }
}
