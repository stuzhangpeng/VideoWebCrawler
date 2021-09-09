package com.zhangpeng.videowebsite.service;

import com.zhangpeng.videowebsite.javabean.VideoDetail;

import java.util.List;

/**
 * @ClassName VideoDetailService
 * @Description TODO
 * @Author zhangpeng
 * @Date 2020/10/16 15:00
 * @Version 1.0
 */
public interface VideoDetailService {
    public List<VideoDetail> findVideoDetailById(List<Integer> vids);
}
