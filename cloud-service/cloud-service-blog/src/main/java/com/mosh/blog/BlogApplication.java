package com.mosh.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/14 14:30
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.mosh")
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}
