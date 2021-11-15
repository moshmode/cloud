package com.mosh.msm.context;

import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;
import com.mosh.msm.client.MsmApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/6 10:30
 */
@Data
@Component
@ConfigurationProperties(prefix = "msm.api")
public class MsmConfigurationContext {
    private String ak;
    private String sk;
    private String template;
    private MsmApiClient client;

    public MsmApiClient getClient() {

        if (client == null) {
            client = new MsmApiClient();
            HttpClientBuilderParams httpParam = new HttpClientBuilderParams();
            httpParam.setAppKey(ak);
            httpParam.setAppSecret(sk);
            client.init(httpParam);
        }
        return client;
    }


}
