package com.mosh.obs.context;

import com.mosh.huawei.context.AccountConfigurationContext;
import com.obs.services.ObsClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/14 19:53
 */
@Data
@Component
@ConfigurationProperties(prefix = "huawei.obs")
public class OBSConfigurationContext {

    @Resource
    private AccountConfigurationContext account;

    private String endPoint;

    private String bucketName;

    public ObsClient getObsClient() {
        return new ObsClient(account.getAk(), account.getSk(), endPoint);
    }
}
