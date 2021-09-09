package com.zhangpeng.videowebsite;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.zhangpeng.videowebsite.mapper")
public class VideowebsiteApplication {
    public static void main(String[] args) {
        //启动项目
        SpringApplication.run(VideowebsiteApplication.class, args);
    }

}
