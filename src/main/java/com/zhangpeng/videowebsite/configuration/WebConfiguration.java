package com.zhangpeng.videowebsite.configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * @ClassName WebConfiguration
 * @Description webmvc自定义配置类
 * @Author zhangpeng
 * @Date 2020/10/16 9:07
 * @Version 1.0
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    /**
     * @Description cors跨域请求设置
     * @Param registry cors配置类
     * @return void
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("POST","GET","PUT","DELETE").allowCredentials(true)
                .allowedOrigins("*").allowedHeaders("*").maxAge(1800);
    }
}
