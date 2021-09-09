package com.zhangpeng.videowebsite.webcrawler;

import com.zhangpeng.videowebsite.javabean.VideoDetail;
import org.jsoup.Jsoup;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName VideoReptileJob
 * @Description 爬虫页面结果解析类
 * @Author zhangpeng
 * @Date 2020/11/3 15:43
 * @Version 1.0
 */
public class VideoReptileJob implements PageProcessor {
    Map<String,String> cookie=VideoCookie.getCookie();

    private Site site=Site.me().addHeader("Referer", "https://aa1805.com/wtydfAA.htm")
            .addHeader("Host", "aa1805.com")
            .addCookie("PHPSESSID", "snirdh5atci5a7bjhnduom6hm0")
            .addCookie("__cfduid",  "df2c90c0a06060e5cab62fd74c409f55b1604403919")
            .addCookie("TSCvalue", "gb")
            .addCookie("UM_distinctid","1758ded7705187-0e185fce0478538-4c3f2678-1fa400-1758ded77062a1")
            .addCookie("CNZZDATA1273435591", "66914902-1604400571-https%253A%252F%252Faa1805.com%252F%7C1604573905")
            .addCookie("CNZZDATA1273380027", "1579638437-1604402706-https%253A%252F%252Faa1805.com%252F%7C1604571126")
            .setDomain("aa1805.com")
            .setTimeOut(150000)//设置超时时间
            .setCharset("UTF-8")//设置编码
            .setRetrySleepTime(3000)//设置重试间隔时间
            .setSleepTime(3)//设置重试次数
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:82.0) Gecko/20100101 Firefox/82.0");
    @Override
    public void process(Page page) {
        //获取爬取结果的html页面
        Html resultHtml = page.getHtml();
        //通过css选择器获取对应标签的值，获取视频详情页url
        List<String> results = resultHtml.$("span#main>.aRF:not(:has(br))").links().all();
        //获取视频url地址
        if(results==null||results.size()==0){
            //视频详情页解析获取视频url
            Html videoDetailHtml = page.getHtml();
            //解析html,获取视频src
            String videoDetailUrl = videoDetailHtml.css("[data-cfasync]+script").toString();
            //使用正则表达式提取获m3u8文件的url
            if(videoDetailUrl==null||videoDetailUrl.length()==0){
               saveVideoUrl(page);
            }else{
                //获取m3u8文件地址
                int begin = videoDetailUrl.indexOf("//");
                int end = videoDetailUrl.indexOf("html");
                String substring = videoDetailUrl.substring(begin, end+4);
                String m3u8Url="https:"+substring;
                saveVideoInfo(page);
                page.addTargetRequest(m3u8Url);
            }
        }
        else{
            //视频详情页放入任务队列中
            for(String info:results){
                page.addTargetRequest(info);
            }
            page.setSkip(true);
            //下一页
            String nextpage = resultHtml.css("span.pageback").links().get();
            page.addTargetRequest(nextpage);
        }

    }

    @Override
    public Site getSite() {
        return site;
    }
    /**
     * @Description 封装爬取的video数据到pipline
     * @Param [page]
     * @return void
     */
    public void saveVideoUrl(Page page){
        VideoDetail videoDetail=new VideoDetail();
        String m3u8String = page.getHtml().css("[type]").toString();
        int m3u8Begin = m3u8String.indexOf("https");
        int m3u8End = m3u8String.lastIndexOf("m3u8");
        String videoUrl = m3u8String.substring(m3u8Begin, m3u8End + 4);
        videoDetail.setPlayUrl(videoUrl);
        String requestUrl = page.getRequest().getUrl();
        if (requestUrl.contains("mv")){
          requestUrl = requestUrl.replace("mv", "");
        }
        videoDetail.setDocUrl(requestUrl);
        page.putField("videoInfo", videoDetail);

    }
    public void saveVideoInfo(Page page){
        VideoDetail videoDetail=new VideoDetail();
        Html html = page.getHtml();
        //利用jsoup读取数据
        String videoName = Jsoup.parse(html.css("h1 a.aRF").toString()).text();
        String imageUrl = html.css("h1 a.aRF img", "src").toString();
        int begin = videoName.indexOf("]");
        String title = videoName.substring(begin+1);
        String size = videoName.substring(0, begin + 1);
        if(title.contains("最新")){
            int  titleBegin= title.indexOf("最新");
            title=title.substring(titleBegin);
        }
        videoDetail.setCategory("self-photo");
        videoDetail.setImageurl(imageUrl);
        videoDetail.setPlayUrl("");
        videoDetail.setCreateDate(new Date());
        videoDetail.setVideoTittle(title);
        videoDetail.setSize(size);
        videoDetail.setDocUrl(page.getRequest().getUrl());
        page.putField("videoInfo", videoDetail);
    }
}
