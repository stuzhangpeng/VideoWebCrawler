package com.zhangpeng.videowebsite.webcrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;

import java.util.Arrays;
/**
 * @ClassName VideoSpider
 * @Description 视频爬虫
 * @Author zhangpeng
 * @Date 2020/11/3 15:55
 * @Version 1.0
 */
//@Component
public class VideoSpider {
    //爬取的起始url
    private static String url="https://aa1805.com/serch_18av/%E7%84%A1%E4%BF%AE%E6%AD%A3%E5%85%A8%E9%83%A8%E5%88%97%E8%A1%A8_60.htm";
    @Autowired
    private JdbcPipline jdbcPipline;
    @Autowired
    public void startSpider(){
        //执行爬虫
        Spider.create(new VideoReptileJobPro())//设置爬虫的结果解析器
                .addUrl(url)//设置爬取的url
                .thread(10)
                .setPipelines(Arrays.asList(jdbcPipline))
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(100000)))
                .run();
    }
}
