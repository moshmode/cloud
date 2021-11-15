package com.mosh.acl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/12 14:31
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.mosh")
public class AclApplication {
    public static void main(String[] args) {
        SpringApplication.run(AclApplication.class, args);
    }
}
