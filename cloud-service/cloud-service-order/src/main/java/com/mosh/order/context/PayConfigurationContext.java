package com.mosh.order.context;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/10 21:58
 */
@Data
@Component
@ConfigurationProperties("weixin.pay")
public class PayConfigurationContext {
    private String appid;
    private String partner;
    private String partnerkey;
    private String notifyurl;
}
