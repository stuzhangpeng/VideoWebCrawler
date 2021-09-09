package com.zhangpeng.videowebsite.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zhangpeng.videowebsite.javabean.CommonResult;
import com.zhangpeng.videowebsite.javabean.PageVideoResult;
import com.zhangpeng.videowebsite.javabean.VideoDetail;
import com.zhangpeng.videowebsite.service.VideoSearchService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName VideoSearchController
 * @Description TODO
 * @Author zhangpeng
 * @Date 2020/11/6 14:56
 * @Version 1.0
 */
@RestController
public class VideoController {
    @Autowired
    private VideoSearchService videoSearchService;
    /**
     * @Description 根据视频id查找视频
     * @return com.zhangpeng.videowebsite.javabean.CommonResult
     */
    @GetMapping("/video/{vid}")
    public CommonResult getVideoByVid(@PathVariable("vid") Integer vid) throws JsonProcessingException {
        CommonResult commonResult=new CommonResult();
        commonResult.setCode("200");
        commonResult.setMessage("查询成功");
        Map<String, Object> resultMap = videoSearchService.searchVideoById(vid);
        if (resultMap!=null){
            commonResult.setData(resultMap);
            return commonResult;
        }
        return commonResult;
    }
    /**
     * @Description 根据分类名称获取分页视频列表
     * @return com.zhangpeng.videowebsite.javabean.CommonResult
     */
    @GetMapping("/videos/category/{categoryName}/{page}/{pagesize}")
    public CommonResult getVideosByPage(@PathVariable("categoryName") String categoryName,@PathVariable("page")Integer page,@PathVariable("pagesize")Integer PageSize){
        List<Map<String, Object>> maps = videoSearchService.searchVideoByCategory(categoryName, page, PageSize);
        CommonResult commonResult=new CommonResult();
        commonResult.setCode("200");
        commonResult.setMessage("查询成功");
        if (maps.size()>0){
            commonResult.setData(maps);
        }
        return commonResult;
    }
    /**
     * @Description 根据关键词搜索视频并进行分页
     * @Param [keywordName]
     * @return com.zhangpeng.videowebsite.javabean.CommonResult
     */
    @GetMapping("/videos/keyword")
    public CommonResult searchvideo( String keyword,Integer page,Integer pagesize) throws IOException {
        PageVideoResult pageVideoResult = videoSearchService.searchVideoByKeyword(keyword, page, pagesize);
        CommonResult commonResult=new CommonResult();
        commonResult.setCode("200");
        commonResult.setMessage("查询成功");
        commonResult.setData(pageVideoResult);
        return commonResult;
    }
    @GetMapping("/videos/category/all")
    public CommonResult getAllVideosByCategory(String category,Integer page,Integer pagesize) throws IOException {
        PageVideoResult pageResult = videoSearchService.getAllVideosByCategory(category, page, pagesize);
        CommonResult commonResult=new CommonResult();
        commonResult.setCode("200");
        commonResult.setMessage("success");
        commonResult.setData(pageResult);
        return commonResult;
    }
}
