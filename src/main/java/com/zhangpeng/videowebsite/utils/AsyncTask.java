package com.zhangpeng.videowebsite.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.http.HttpUtil;
import com.zhangpeng.videowebsite.javabean.VideoDetail;
import com.zhangpeng.videowebsite.mapper.VideoDetailMapper;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.xmlpull.v1.XmlPullParserException;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName AsyncTask
 * @Description TODO
 * @Author zhangpeng
 * @Date 2020/11/8 19:45
 * @Version 1.0
 */
public class AsyncTask implements Runnable {
    File files=new File("E:\\images");
    String contentType="image/jpeg";
    private String  bucket;
    private MinioClient minioClient;
    private VideoDetailMapper videoDetailMapper;
    private VideoDetail videoDetail;
    private String imageurl;

    public AsyncTask(String bucket, MinioClient minioClient, VideoDetailMapper videoDetailMapper, VideoDetail videoDetail, String imageurl) {
        this.bucket = bucket;
        this.minioClient = minioClient;
        this.videoDetailMapper = videoDetailMapper;
        this.videoDetail = videoDetail;
        this.imageurl = imageurl;
    }

    @Override
    public void run() {
        File file = HttpUtil.downloadFileFromUrl(imageurl,files ,1000*600);
        String name = FileNameUtil.getName(file);
        BufferedInputStream inputStream = FileUtil.getInputStream(file);
        try {
            minioClient.putObject(bucket, name, inputStream,contentType);
            String imgUrl = minioClient.getObjectUrl(bucket, name);
            videoDetail.setImageurl(imgUrl);
            videoDetailMapper.updateByPrimaryKeySelective(videoDetail);
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

    }
}
