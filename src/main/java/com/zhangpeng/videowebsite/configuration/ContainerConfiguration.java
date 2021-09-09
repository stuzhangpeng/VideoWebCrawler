package com.zhangpeng.videowebsite.configuration;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * @ClassName ContainerConfiguration
 * @Description ioc容器配置
 * @Author zhangpeng
 * @Date 2020/10/16 10:38
 * @Version 1.0
 */
@Configuration
public class ContainerConfiguration {
    /**
     * @Description durid数据源配置
     * @Param []
     * @return javax.sql.DataSource
     */
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource druid(){
        DataSource dataSource=new DruidDataSource();
        return dataSource;
    }
    /**
     * @Description durid数据源监控fiter
     * @Param []
     * @return org.springframework.boot.web.servlet.FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean webstatfilter(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterRegistrationBean.setFilter(new WebStatFilter());
        return filterRegistrationBean;
    }
    /**
     * @Description durid数据源监控servlet
     * @Param []
     * @return org.springframework.boot.web.servlet.ServletRegistrationBean
     */
    @Bean
    public ServletRegistrationBean webstatservlet(){
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.setUrlMappings(Arrays.asList("/druid/*"));
        //设置durid登录信息
        Map map=new HashMap();
        map.put("loginUsername","admin");
        map.put("loginPassword","123456");
        servletRegistrationBean.setInitParameters(map);
        return servletRegistrationBean;
    }
}
