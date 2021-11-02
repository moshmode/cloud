package com.mosh.huawei.context;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/1 10:40
 */
@Data
@Component
@ConfigurationProperties(prefix = "huawei.account")
public class AccountConfigurationContext {
    private String ak;

    private String sk;
}
