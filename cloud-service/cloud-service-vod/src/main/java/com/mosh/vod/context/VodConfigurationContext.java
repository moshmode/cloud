package com.mosh.vod.context;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/3 20:17
 */
@Data
@Component
@ConfigurationProperties(prefix = "vod")
public class VodConfigurationContext {

    private String ak;

    private String sk;

    private String endPoint;

}
