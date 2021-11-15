package com.mosh.msm.service.impl;

import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.mosh.msm.client.MsmApiClient;
import com.mosh.msm.context.MsmConfigurationContext;
import com.mosh.msm.service.MsmService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/5 21:16
 */
@Service
public class MsmServiceImpl implements MsmService {

    @Resource
    MsmConfigurationContext context;

    @Override
    public boolean sendMsm(String phone, String code) {
        if (StringUtils.isEmpty(phone)) return false;

        try {
            return context.getClient().sendSyncMode(phone, context.getTemplate(), code).getCode() == 200;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
