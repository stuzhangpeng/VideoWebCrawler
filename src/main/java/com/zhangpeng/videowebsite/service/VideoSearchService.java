package com.zhangpeng.videowebsite.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zhangpeng.videowebsite.javabean.PageVideoResult;
import com.zhangpeng.videowebsite.javabean.VideoDetail;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @ClassName VideoSearchService
 * @Description 视频搜索服务
 * @Author zhangpeng
 * @Date 2020/11/5 21:59
 * @Version 1.0
 */
public interface VideoSearchService {
    /**
     * @Description 通过分类名称查询分类分页视频列表
     * @Param [categoryName, page, pagesize]
     * @return java.util.List<com.zhangpeng.videowebsite.javabean.VideoDetail>
     */
    public List<Map<String,Object>>  searchVideoByCategory(String categoryName, Integer page, Integer pagesize) ;
   /**
    * @Description 通过关键字搜索视频列表并分页
    * @Param [keyword, page, pagesize]
    * @return java.util.List<com.zhangpeng.videowebsite.javabean.VideoDetail>
    */
    public PageVideoResult searchVideoByKeyword(String keyword, Integer page, Integer pagesize) throws IOException;
   /**
    * @Description通过视频id搜索视频
    * @Param [id]
    * @return com.zhangpeng.videowebsite.javabean.VideoDetail
    */
    public Map<String,Object> searchVideoById(Integer id) throws JsonProcessingException;
    /**
     * @Description 插入文档
     * @Param [videoDetail]
     * @return Boolean
     */
    public Boolean insertVideo(VideoDetail videoDetail);
    /**
     * @Description 插入文档列表
     * @Param [videoDetail]
     * @return Boolean
     */
    public Boolean insertVideoList(List<VideoDetail> list);
    /**
     * @Description 创建索引
     * @Param [index]
     * @return java.lang.Boolean
     */
    public Boolean createIndex(String index);
    public Boolean deleteIndex(String index);
    public PageVideoResult getAllVideosByCategory(String category,Integer Page,Integer pagesize) throws IOException;

}
