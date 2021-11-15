package com.mosh.obs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/14 19:25
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.mosh", exclude = DataSourceAutoConfiguration.class)
public class OBSApplication {
    public static void main(String[] args) {
        SpringApplication.run(OBSApplication.class, args);
    }
}
