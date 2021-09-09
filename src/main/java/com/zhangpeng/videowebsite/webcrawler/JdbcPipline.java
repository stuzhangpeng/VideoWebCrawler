package com.zhangpeng.videowebsite.webcrawler;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.http.HttpUtil;
import com.zhangpeng.videowebsite.configuration.MinioProperties;
import com.zhangpeng.videowebsite.javabean.VideoDetail;
import com.zhangpeng.videowebsite.javabean.VideoDetailExample;
import com.zhangpeng.videowebsite.mapper.VideoDetailMapper;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xmlpull.v1.XmlPullParserException;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName JdbcPipline
 * @Description 爬取结果输出类
 * @Author zhangpeng
 * @Date 2020/11/3 15:53
 * @Version 1.0
 */
//@Component
public class JdbcPipline implements Pipeline {
    File files=new File("E:\\imagespro");
    String contentType="image/jpeg";
    @Autowired
    private MinioProperties minioProperties;
    @Autowired
    private MinioClient minioClient;
    @Autowired
    VideoDetailMapper videoDetailMapper;
    @Override
    public void process(ResultItems resultItems, Task task) {
        VideoDetail videoInfo = resultItems.get("videoInfo");
        if(videoInfo.getPlayUrl()==null||videoInfo.getPlayUrl().equals("")){
            String bucket = minioProperties.getBucket();
            try{
                boolean exist = minioClient.bucketExists(bucket);
                if(!exist){
                    minioClient.makeBucket(bucket);
                    // 使用putObject上传一个文件到存储桶中
                }
            }catch (Exception ex){
                ex.printStackTrace();
                return;
            }
            String loclImageUrl = getLoclImageUrl(bucket, contentType, videoInfo.getImageurl(), files);
            if(loclImageUrl!=null){
               videoInfo.setImageurl(loclImageUrl);
            }
            //添加到
            videoDetailMapper.insert(videoInfo);
        }else{
            VideoDetailExample videoDetailExample=new VideoDetailExample();
            VideoDetailExample.Criteria criteria = videoDetailExample.createCriteria();
            criteria.andDocUrlEqualTo(videoInfo.getDocUrl());
            videoDetailMapper.updateByExampleSelective(videoInfo,videoDetailExample);
        }
        //保存到数据库
    }
    /**
     * @Description //下载图片返回本地url
     * @Param [bucket, contentType, imageurl, files]
     * @return java.lang.String
     */
    public String getLoclImageUrl(String bucket, String contentType,String imageurl,File files){
        File file = HttpUtil.downloadFileFromUrl(imageurl,files ,1000*600);
        String name = FileNameUtil.getName(file);
        BufferedInputStream inputStream = FileUtil.getInputStream(file);
        try {
            minioClient.putObject(bucket, name, inputStream,contentType);
            String imgUrl = minioClient.getObjectUrl(bucket, name);
            return imgUrl;
        } catch (InvalidBucketNameException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InsufficientDataException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoResponseException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (ErrorResponseException e) {
            e.printStackTrace();
        } catch (InternalException e) {
            e.printStackTrace();
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }
}
