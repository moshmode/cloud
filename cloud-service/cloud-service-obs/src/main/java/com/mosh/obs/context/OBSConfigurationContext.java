package com.mosh.obs.context;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/14 19:53
 */
@Data
@Component
@ConfigurationProperties(prefix = "obs")
public class OBSConfigurationContext {

    private String ak;

    private String sk;

    private String endPoint;

    private String teacherAvatarBucket;

    private String blogCoverBucket;

    public OSS getClient() {
        return new OSSClientBuilder().build(endPoint, ak, sk);
    }

}
