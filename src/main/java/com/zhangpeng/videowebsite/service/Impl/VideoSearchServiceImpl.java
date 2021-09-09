package com.zhangpeng.videowebsite.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhangpeng.videowebsite.javabean.PageVideoResult;
import com.zhangpeng.videowebsite.javabean.VideoDetail;
import com.zhangpeng.videowebsite.service.VideoSearchService;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.core.CountRequest;
import org.elasticsearch.client.core.CountResponse;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName VideoSearchServiceImpl
 * @Description 视频搜索实现类
 * @Author zhangpeng
 * @Date 2020/11/5 22:02
 * @Version 1.0
 */
@Service
public class VideoSearchServiceImpl implements VideoSearchService {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Override
    public List<Map<String, Object>> searchVideoByCategory(String categoryName, Integer page, Integer pagesize) {
        SearchRequest searchRequest = new SearchRequest("videowebsite");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //条件查询
        TermQueryBuilder termQuery = QueryBuilders.termQuery("category", categoryName);
        searchSourceBuilder.timeout(TimeValue.timeValueMinutes(3));
        searchSourceBuilder.query(termQuery);
        //分页
        searchSourceBuilder.from((page - 1) * pagesize);
        searchSourceBuilder.size(pagesize);
        String [] includes={"vid","imageurl","category","videoTittle"};
        String [] excludes={"size","createDate","docUrl","playUrl"};
        searchSourceBuilder.fetchSource(includes, excludes);
        searchRequest.source(searchSourceBuilder);
        //执行查询
        List<Map<String, Object>> list = new ArrayList();
        SearchResponse result = null;
        try {
            result = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
            return list;
        }
        //搜索结果
        SearchHits hits = result.getHits();
        SearchHit[] hitsCollection = hits.getHits();
        //遍历搜索结果进行封装
        if(hitsCollection!=null&&hitsCollection.length>0){
            for (SearchHit documentFields : hitsCollection) {
                //单个文档封装成map
                Map<String, Object> sourceAsMap = documentFields.getSourceAsMap();
                //添加到list列表
                list.add(sourceAsMap);
            }
        }
        return list;
    }

    @Override
    public PageVideoResult searchVideoByKeyword(String keyword, Integer page, Integer pagesize) throws IOException {
        CountRequest countRequest=new CountRequest("videowebsite");


        PageVideoResult pageVideoResult=new PageVideoResult();
        SearchRequest searchRequest = new SearchRequest("videowebsite");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //条件查询
        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("videoTittle", keyword);
        searchSourceBuilder.timeout(TimeValue.timeValueMinutes(3));

        //分页
        searchSourceBuilder.from((page - 1) * pagesize);
        searchSourceBuilder.size(pagesize);
        searchSourceBuilder.query(matchQuery);
        searchRequest.source(searchSourceBuilder);
        countRequest.query(matchQuery);
        CountResponse count = restHighLevelClient.count(countRequest, RequestOptions.DEFAULT);
        long totalCount = count.getCount();
        //执行查询
        List<Map<String, Object>> list = new ArrayList();
        SearchResponse result = null;
        try {
            result = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
            return pageVideoResult;
        }
        //搜索结果
        SearchHits hits = result.getHits();
        SearchHit[] hitsCollection = hits.getHits();
        //遍历搜索结果进行封装
        if(hitsCollection!=null&&hitsCollection.length>0){
            for (SearchHit documentFields : hitsCollection) {
                //单个文档封装成map
                Map<String, Object> sourceAsMap = documentFields.getSourceAsMap();
                //添加到list列表
                list.add(sourceAsMap);
                pageVideoResult.setCount(totalCount);
                pageVideoResult.setMapList(list);
                pageVideoResult.setCurpage(page);
                pageVideoResult.setTotalpage((totalCount+pagesize-1)/pagesize);
            }
        }
        return pageVideoResult;
    }

    @Override
    public Map<String,Object> searchVideoById(Integer vid) throws JsonProcessingException {
        SearchRequest searchRequest = new SearchRequest("videowebsite");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //条件查询
        TermQueryBuilder termQuery = QueryBuilders.termQuery("vid", vid);
        searchSourceBuilder.timeout(TimeValue.timeValueMinutes(3));
        searchSourceBuilder.query(termQuery);
        searchRequest.source(searchSourceBuilder);
        SearchResponse result = null;
        try {
            result = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        //搜索结果
        SearchHits hits = result.getHits();
        SearchHit[] hitsCollection = hits.getHits();
        //遍历搜索结果进行封装
        if (hitsCollection != null && hitsCollection.length > 0) {
            SearchHit documentField = hitsCollection[0];
            //单个文档封装成map
            Map<String, Object> sourceAsMap = documentField.getSourceAsMap();
            return sourceAsMap;
        }
        return null;
    }

    @Override
    public Boolean insertVideo(VideoDetail videoDetail) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(videoDetail);
            IndexRequest indexRequest = new IndexRequest("videowebsite").source(json, XContentType.JSON);
            restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Boolean insertVideoList(List<VideoDetail> list) {
        //批量插入搜索文档
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout(TimeValue.timeValueHours(1L));
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            for (int i = 0; i < list.size(); i++) {
                //批量插入
                VideoDetail videoDetail = list.get(i);
                String json = objectMapper.writeValueAsString(videoDetail);
                IndexRequest indexRequest = new IndexRequest("videowebsite").id("" + (i + 1)).source(json, XContentType.JSON);
                bulkRequest.add(indexRequest);
            }
            //执行批量插入
            BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public Boolean createIndex(String index) {
        //创建索引
        CreateIndexRequest indexRequest = new CreateIndexRequest(index);
        indexRequest.setTimeout(TimeValue.timeValueMinutes(3L));
        //设置分片和备份
        indexRequest.settings(Settings.builder()
                .put("index.number_of_shards", 5)
                .put("index.number_of_replicas", 2)
        );
        //设置mapping
        Map<String, Object> vid = new HashMap<>();
        vid.put("type", "integer");
        Map<String, Object> category = new HashMap<>();
        category.put("type", "keyword");
        Map<String, Object> createDate = new HashMap<>();
        createDate.put("type", "date");
        Map<String, Object> docUrl = new HashMap<>();
        docUrl.put("type", "keyword");
        Map<String, Object> playUrl = new HashMap<>();
        playUrl.put("type", "keyword");
        Map<String, Object> imageurl = new HashMap<>();
        imageurl.put("type", "keyword");
        Map<String, Object> videoTittle = new HashMap<>();
        videoTittle.put("type", "text");
        videoTittle.put("analyzer", "ik_max_word");
        Map<String, Object> size = new HashMap<>();
        size.put("type", "text");
        size.put("analyzer", "ik_max_word");
        Map<String, Object> properties = new HashMap<>();
        properties.put("vid", vid);
        properties.put("category", category);
        properties.put("createDate", createDate);
        properties.put("docUrl", docUrl);
        properties.put("imageurl", imageurl);
        properties.put("playUrl", playUrl);
        properties.put("size", size);
        properties.put("videoTittle", videoTittle);
        Map<String, Object> mapping = new HashMap<>();
        mapping.put("properties", properties);
        indexRequest.mapping(mapping);
        try {
            CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(indexRequest, RequestOptions.DEFAULT);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean deleteIndex(String index) {
        DeleteIndexRequest indexRequest = new DeleteIndexRequest(index);
        try {
            AcknowledgedResponse response = restHighLevelClient.indices().delete(indexRequest, RequestOptions.DEFAULT);
            return response.isAcknowledged();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public PageVideoResult getAllVideosByCategory(String category, Integer Page, Integer pagesize) throws IOException {
        CountRequest countRequest=new CountRequest("videowebsite");
        PageVideoResult pageVideoResult=new PageVideoResult();
        SearchRequest searchRequest = new SearchRequest("videowebsite");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //条件查询
        TermQueryBuilder termQuery = QueryBuilders.termQuery("category", category);
        searchSourceBuilder.timeout(TimeValue.timeValueMinutes(3));
        searchSourceBuilder.query(termQuery);
        //分页
        searchSourceBuilder.from((Page - 1) * pagesize);
        searchSourceBuilder.size(pagesize);
        searchRequest.source(searchSourceBuilder);
        countRequest.query(termQuery);
        CountResponse count = restHighLevelClient.count(countRequest, RequestOptions.DEFAULT);
        long totalCount = count.getCount();
        //执行查询
        List<Map<String, Object>> list = new ArrayList();
        SearchResponse result = null;
        try {
            result = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
            return pageVideoResult;
        }
        //搜索结果
        SearchHits hits = result.getHits();
        SearchHit[] hitsCollection = hits.getHits();
        //遍历搜索结果进行封装
        if(hitsCollection!=null&&hitsCollection.length>0){
            for (SearchHit documentFields : hitsCollection) {
                //单个文档封装成map
                Map<String, Object> sourceAsMap = documentFields.getSourceAsMap();
                //添加到list列表
                list.add(sourceAsMap);
            }
            pageVideoResult.setMapList(list);
            pageVideoResult.setCount(totalCount);
            pageVideoResult.setCurpage(Page);
            pageVideoResult.setTotalpage((totalCount+pagesize-1)/pagesize);
        }
        return pageVideoResult;
    }
}
