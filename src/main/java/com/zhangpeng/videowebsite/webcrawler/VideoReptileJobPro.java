package com.zhangpeng.videowebsite.webcrawler;

import com.zhangpeng.videowebsite.javabean.VideoDetail;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import java.util.Date;
import java.util.List;
/**
 * @ClassName VideoReptileJobPro
 * @Description TODO
 * @Author zhangpeng
 * @Date 2020/11/15 18:14
 * @Version 1.0
 */
public class VideoReptileJobPro implements PageProcessor {
    private Site site=Site.me().addHeader("Referer", "https://aa1805.com")
            .addHeader("Host", "aa1805.com")
            .addCookie("PHPSESSID", "38hke7cjt1bdedgs8chv0v19i7")
            .addCookie("__cfduid",  "daab4b978486c5377f7f0d39e3f13e1901605439109")
            .addCookie("TSCvalue", "gb")
            .addCookie("UM_distinctid","175cba0df69164-0b456f34fd74d-333376b-1fa400-175cba0dfa11b1")
            .addCookie("CNZZDATA1273435591", "243998569-1605434501-https%253A%252F%252Faa1805.com%252F%7C1605618591")
            .addCookie("CNZZDATA1273380027", "301181757-1605436767-https%253A%252F%252Faa1805.com%252F%7C1605618080")
            .addCookie("javascript_cookie_Eighteenth", "I_am_over_18_years_old")
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
            String videoDetailUrl =null;
            String regex = videoDetailHtml.regex("aa1805.com/js/player/fcfluidplayer.php\\?id=720.*?dt_dm").toString();
            if(regex!=null){
                int dt_dm = regex.indexOf("\"");
                 videoDetailUrl= "https://"+regex.substring(0, dt_dm);
            }
            //使用正则表达式提取获m3u8文件的url
            if(videoDetailUrl==null||videoDetailUrl.length()==0){
                //提取m3u8文件的url
                saveVideoUrl(page);
            }else{
                //封装video信息
                saveVideoInfo(page);
                //发送请求获取m3u8url
                page.addTargetRequest(videoDetailUrl);
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
        Html html = page.getHtml();
        String regex = html.regex("source.*m3u8").toString();
        int begin = regex.indexOf("https");
        String videoUrl=regex.substring(begin);
        String requestUrl = page.getRequest().getUrl();
        VideoDetail videoDetail=new VideoDetail();
        videoDetail.setPlayUrl(videoUrl);
        videoDetail.setDocUrl(requestUrl);
        page.putField("videoInfo", videoDetail);

    }
    public void saveVideoInfo(Page page){
        VideoDetail videoDetail=new VideoDetail();
        Html html = page.getHtml();
        //利用jsoup读取数据
        String videoName = Jsoup.parse(html.css("h1 a.aRF").toString()).text();
        String imageUrl = html.css("h1 a.aRF img", "src").toString();
        String url = html.regex("aa1805.com/js/player/fcfluidplayer.php\\?id=720.*?dt_dm").toString();
        if(url!=null){
            int dt_dm = url.indexOf("\"");
            url = url.substring(0, dt_dm);
        }
        String docUrl="https://"+url;
        int begin = videoName.indexOf("]");
        String title = videoName.substring(begin+1);
        videoDetail.setCategory("uncensored");
        videoDetail.setImageurl(imageUrl);
        videoDetail.setPlayUrl("");
        videoDetail.setCreateDate(new Date());
        videoDetail.setVideoTittle(title);
        videoDetail.setSize("unknow");
        videoDetail.setDocUrl(docUrl);
        page.putField("videoInfo", videoDetail);
    }
}
