package com.mosh.vod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/3 20:06
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.mosh", exclude = DataSourceAutoConfiguration.class)
public class VodApplication {
    public static void main(String[] args) {
        SpringApplication.run(VodApplication.class, args);
    }
}
