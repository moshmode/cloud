package com.mosh.obs.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.mosh.obs.context.OBSConfigurationContext;
import com.mosh.obs.service.OBSService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
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
public class OBSServiceImpl implements OBSService {
    @Resource
    private OBSConfigurationContext context;

    private String upload(MultipartFile file, String bucket) {
        try {
            OSS client = context.getClient();
            String uuID = UUID.randomUUID().toString().replaceAll("-", "");
            Date date = new Date();
            String fileName = new SimpleDateFormat("yyyy/MM/dd/").format(date) + uuID;

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(file.getContentType());
            metadata.setObjectAcl(CannedAccessControlList.PublicRead);


            client.putObject(new PutObjectRequest(bucket,
                    fileName,
                    file.getInputStream(),
                    metadata));
            client.shutdown();
            return "https://" + bucket + "." + context.getEndPoint() + "/" + fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void deleteImage(String bucket, String url) {
        OSS client = context.getClient();

        client.deleteObject(bucket, url.substring(url.lastIndexOf('.') + 5));

        client.shutdown();
    }

    @Override
    public String uploadTeacherAvatar(MultipartFile file) {
        return upload(file, context.getTeacherAvatarBucket());
    }

    @Override
    public String uploadBlogCover(MultipartFile file) {
        return upload(file, context.getBlogCoverBucket());
    }

    @Override
    public void deleteBlogCover(String url) {
        deleteImage(context.getBlogCoverBucket(), url);
    }


}
