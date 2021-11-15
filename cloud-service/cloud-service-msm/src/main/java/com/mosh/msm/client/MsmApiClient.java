package com.mosh.msm.client;

import com.alibaba.cloudapi.sdk.client.ApacheHttpClient;
import com.alibaba.cloudapi.sdk.enums.HttpMethod;
import com.alibaba.cloudapi.sdk.enums.ParamPosition;
import com.alibaba.cloudapi.sdk.enums.Scheme;
import com.alibaba.cloudapi.sdk.model.ApiCallback;
import com.alibaba.cloudapi.sdk.model.ApiRequest;
import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;
import com.mosh.msm.context.MsmConfigurationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/6 10:24
 */
public class MsmApiClient extends ApacheHttpClient {


    public void init(HttpClientBuilderParams httpClientBuilderParams) {
        String host = "jumsendsms.market.alicloudapi.com";
        httpClientBuilderParams.setScheme(Scheme.HTTP);
        httpClientBuilderParams.setHost(host);
        super.init(httpClientBuilderParams);
    }


    public void selectState(String taskId, String mobile, ApiCallback callback) {
        String path = "/sms/send-status-upgrade";
        ApiRequest request = new ApiRequest(HttpMethod.GET, path);
        request.addParam("taskId", taskId, ParamPosition.QUERY, true);
        request.addParam("mobile", mobile, ParamPosition.QUERY, true);


        sendAsyncRequest(request, callback);
    }

    public ApiResponse selectStateSyncMode(String taskId, String mobile) {
        String path = "/sms/send-status-upgrade";
        ApiRequest request = new ApiRequest(HttpMethod.GET, path);
        request.addParam("taskId", taskId, ParamPosition.QUERY, true);
        request.addParam("mobile", mobile, ParamPosition.QUERY, true);


        return sendSyncRequest(request);
    }

    public void sendMsm(String mobile, String templateId, String value, ApiCallback callback) {
        String path = "/sms/send-upgrade";
        ApiRequest request = new ApiRequest(HttpMethod.POST_FORM, path);
        request.addParam("mobile", mobile, ParamPosition.QUERY, true);
        request.addParam("templateId", templateId, ParamPosition.QUERY, true);
        request.addParam("value", value, ParamPosition.QUERY, true);


        sendAsyncRequest(request, callback);
    }

    public ApiResponse sendSyncMode(String mobile, String templateId, String value) {
        String path = "/sms/send-upgrade";
        ApiRequest request = new ApiRequest(HttpMethod.POST_FORM, path);
        request.addParam("mobile", mobile, ParamPosition.QUERY, true);
        request.addParam("templateId", templateId, ParamPosition.QUERY, true);
        request.addParam("value", value, ParamPosition.QUERY, true);


        return sendSyncRequest(request);
    }
}
