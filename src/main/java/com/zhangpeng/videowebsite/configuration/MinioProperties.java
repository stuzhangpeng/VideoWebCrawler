package com.zhangpeng.videowebsite.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName MinioProperties
 * @Description minio配置文件
 * @Author zhangpeng
 * @Date 2020/11/8 15:50
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {
    private String endpoint;
    private String accessKey;
    private String secrectKey;
    private String bucket;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecrectKey() {
        return secrectKey;
    }

    public void setSecrectKey(String secrectKey) {
        this.secrectKey = secrectKey;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }
}
