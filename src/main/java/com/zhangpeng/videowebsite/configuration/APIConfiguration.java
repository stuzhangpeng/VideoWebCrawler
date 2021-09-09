package com.zhangpeng.videowebsite.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;
/**
 * @ClassName APIConfiguration
 * @Description swagger2 api接口配置类
 * @Author zhangpeng
 * @Date 2020/10/31 12:35
 * @Version 1.0
 */
@Configuration
@EnableSwagger2
public class APIConfiguration {
    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.enable(true)//开启swagger
                .apiInfo(apiInfo())//配置api信息
                .groupName("zhangpeng")//配置组名
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zhangpeng.videowebsite.controller"))//配置扫描的包
                .build();
        return docket;
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("zhangpeng", "", "stuzhangsan@gmail.com");
        ApiInfo apiInfo = new ApiInfo("filmwebsiteapi", "视频网站api接口", "v1.0", "", contact, "", "", new ArrayList<>());
        return apiInfo;
    }
}
