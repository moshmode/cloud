package com.mosh.obs.service.impl;

import com.mosh.obs.context.OBSConfigurationContext;
import com.mosh.obs.service.AvatarOBSService;
import com.obs.services.ObsClient;
import com.obs.services.model.AccessControlList;
import com.obs.services.model.ObjectMetadata;
import com.obs.services.model.PutObjectRequest;
import com.obs.services.model.PutObjectResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/14 20:05
 */
@Service
public class AvatarOBSServiceImpl implements AvatarOBSService {
    @Resource
    private OBSConfigurationContext context;

    @Override
    public String upload(MultipartFile file) {
        try (ObsClient obsClient = context.getObsClient()) {
            PutObjectResult result = obsClient.putObject(createObsRequest(file));
            obsClient.close();
            return result.getObjectUrl();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private PutObjectRequest createObsRequest(MultipartFile file) throws IOException {
        String uuID = UUID.randomUUID().toString().replaceAll("-", "");
        Date date = new Date();
        String filename = new SimpleDateFormat("yyyy/MM/dd/").format(date) + uuID;

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType());

        PutObjectRequest request = new PutObjectRequest();
        request.setBucketName(context.getBucketName());
        request.setObjectKey(filename);
        request.setInput(file.getInputStream());
        request.setMetadata(metadata);
        request.setAcl(AccessControlList.REST_CANNED_PUBLIC_READ);
        return request;
    }
}
