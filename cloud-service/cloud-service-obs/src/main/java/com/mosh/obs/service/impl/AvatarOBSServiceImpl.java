package com.mosh.obs.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.mosh.obs.context.OBSConfigurationContext;
import com.mosh.obs.service.AvatarOBSService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
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
        try {
            OSS client = context.getClient();
            String bucketName = context.getBucketName();

            String uuID = UUID.randomUUID().toString().replaceAll("-", "");
            Date date = new Date();
            String fileName = new SimpleDateFormat("yyyy/MM/dd/").format(date) + uuID;

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(file.getContentType());
            metadata.setObjectAcl(CannedAccessControlList.PublicRead);


            client.putObject(new PutObjectRequest(bucketName,
                    fileName,
                    file.getInputStream(),
                    metadata));
            client.shutdown();

            return "https://" + bucketName + "." + context.getEndPoint() + "/" + fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
