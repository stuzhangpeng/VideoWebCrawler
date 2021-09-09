package com.zhangpeng.videowebsite.configuration;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MinioConfiguration
 * @Description  minio配置文件
 * @Author zhangpeng
 * @Date 2020/11/8 15:56
 * @Version 1.0
 */
@Configuration
public class MinioConfiguration {
    @Autowired
    private MinioProperties minioProperties;
    @Bean
    public MinioClient minioClient() throws InvalidPortException, InvalidEndpointException {
       return  new MinioClient(minioProperties.getEndpoint(),minioProperties.getAccessKey(),minioProperties.getSecrectKey());
    }
}
