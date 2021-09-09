package com.zhangpeng.videowebsite.configuration;

import org.apache.http.HttpHost;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ElasticSearchConfiguration
 * @Description elasticsearch配置
 * @Author zhangpeng
 * @Date 2020/11/5 23:14
 * @Version 1.0
 */
@Configuration
public class ElasticSearchConfiguration {
    /**
     * @Description elasticsearch客户端
     */
    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1", 9200, "http")
                ));
        return client;
    }

    ;
}
