package com.zhangpeng.videowebsite;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhangpeng.videowebsite.configuration.MinioProperties;
import com.zhangpeng.videowebsite.javabean.VideoDetail;
import com.zhangpeng.videowebsite.javabean.VideoDetailExample;
import com.zhangpeng.videowebsite.mapper.VideoDetailMapper;
import com.zhangpeng.videowebsite.webcrawler.VideoSpider;
import io.minio.MinioClient;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VideowebsiteApplicationTests {
 /*   @Autowired
    private MinioProperties minioProperties;
    @Autowired
    private MinioClient minioClient;
    @Autowired
    private VideoSpider videoSpider;*/
    @Autowired
    private RestHighLevelClient restHighLevelClient;
    @Autowired
    private VideoDetailMapper videoDetailMapper;
    @Test
    public void contextLoads() {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MINUTE, 10);
        //jwt的应用
        String token = JWT.create()
                .withClaim("username", "zhangsan")//设置payload
                .withExpiresAt(instance.getTime())//设置过期时间
                .sign(Algorithm.HMAC256("lalalalajajaj"));//设置签名算法和密钥
        System.out.println("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDM1MjQ3NjYsInVzZXJuYW1lIjoiemhhbmdzYW4ifQ.4j1Pd7YfXI304iJwkYZ6n9AEAfElNvy8763J2SVQRl4");

    }
    @Test
    public void contextLoads1() {
        //验签对象
        JWTVerifier jwtVerifier= JWT.require(Algorithm.HMAC256("lalalalajajaj")).build();
        //验证签名
        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDM1MjQ3NjYsInVzZXJuYW1lIjoiemhhbmdzYW4ifQ.4j1Pd7YfXI304iJwkYZ6n9AEAfElNvy8763J2SVQRl4");
        //解码数据
        String payload = verify.getPayload();
        System.out.println(payload);
        String header = verify.getHeader();
        System.out.println(header);
        String user = verify.getClaim("username").asString();
        System.out.println(user);
    }
    @Test
    public void contextLoads2() {
        String videoDetailUrl="height=\"430px\"src=\"//aa1805.com/dfmv/30467.html\">";
        int begin = videoDetailUrl.indexOf("//");
        int end = videoDetailUrl.indexOf("html");
        String substring = videoDetailUrl.substring(begin, end+4);
        System.out.println(substring);
    }
    /*@Test*/
    /*public void contextLoads3() {
       videoSpider.startSpider();
    }*/
    @Test
    public void contextLoads4() throws IOException {
        //创建索引
        CreateIndexRequest indexRequest = new CreateIndexRequest("videowebsite");
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
        videoTittle.put("analyzer","ik_max_word");
        Map<String, Object> size = new HashMap<>();
        size.put("type", "text");
        size.put("analyzer","ik_max_word");
        Map<String, Object> properties = new HashMap<>();
        properties.put("vid",vid);
        properties.put("category",category);
        properties.put("createDate",createDate);
        properties.put("docUrl",docUrl);
        properties.put("imageurl",imageurl);
        properties.put("playUrl",playUrl);
        properties.put("size",size);
        properties.put("videoTittle",videoTittle);
        Map<String, Object> mapping = new HashMap<>();
        mapping.put("properties", properties);
        indexRequest.mapping(mapping);
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(indexRequest, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse.isAcknowledged());

    }
    @Test
    public void contextLoads5() throws IOException {
        //获取索引
        DeleteIndexRequest indexRequest = new DeleteIndexRequest("zhangpeng");
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(indexRequest, RequestOptions.DEFAULT);
        System.out.println(delete);


    }
    @Test
    public void contextLoads6() throws IOException {
            //批量插入搜索文档
        VideoDetailExample example=new VideoDetailExample();
        List<VideoDetail> videoDetails = videoDetailMapper.selectByExampleWithBLOBs(example);
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout(TimeValue.timeValueHours(1L));
        ObjectMapper objectMapper=new ObjectMapper();
        for(int i=0;i<videoDetails.size();i++){
            //批量插入
            VideoDetail videoDetail = videoDetails.get(i);
            String json = objectMapper.writeValueAsString(videoDetail);
            IndexRequest indexRequest=new IndexRequest("videowebsite").id(""+(i+1)).source(json,XContentType.JSON);
            indexRequest.timeout(TimeValue.timeValueMinutes(3L));
            bulkRequest.add(indexRequest);
        }
        //执行批量插入
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulk.status());

    }
    @Test
    public void contextLoads10() throws IOException {
            //批量插入搜索文档
        VideoDetailExample example=new VideoDetailExample();
        VideoDetailExample.Criteria criteria = example.createCriteria();
        criteria.andVidGreaterThanOrEqualTo(42504);
        criteria.andVidLessThanOrEqualTo(44878);
        List<VideoDetail> videoDetails = videoDetailMapper.selectByExampleWithBLOBs(example);
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout(TimeValue.timeValueHours(5L));
        ObjectMapper objectMapper=new ObjectMapper();
        for(int i=0;i<videoDetails.size();i++){
            //批量插入
            VideoDetail videoDetail = videoDetails.get(i);
            String json = objectMapper.writeValueAsString(videoDetail);
            IndexRequest indexRequest=new IndexRequest("videowebsite").id(""+videoDetail.getVid()).source(json,XContentType.JSON);
            indexRequest.timeout(TimeValue.timeValueMinutes(40L));
            bulkRequest.add(indexRequest);
        }
        //执行批量插入
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulk.status());

    }
    @Test
    public void contextLoads7() throws IOException {
            //批量插入搜索文档
        VideoDetailExample example=new VideoDetailExample();
        List<VideoDetail> videoDetails = videoDetailMapper.selectByExampleWithBLOBs(example);
        for(VideoDetail videoDetail:videoDetails){
            String imageurl = videoDetail.getImageurl();
            String replace = imageurl.replace("127.0.0.1", "192.168.0.109");
            videoDetail.setImageurl(replace);
            videoDetailMapper.updateByPrimaryKeySelective(videoDetail);
        }

    }
    @Test
    public  void testMinioUploadFile() throws Exception{


    }
   /* public  void testMinioUploadFiles() throws Exception{
        File files=new File("E:\\imagespro");
        String contentType="image/jpeg";
        String imageurl="https://fchost1.ccmma18.com/b/ei/CH37323.jpg";
        String bucket="imagepro";
        File file = HttpUtil.downloadFileFromUrl(imageurl,files ,1000*600);
        String name = FileNameUtil.getName(file);
        BufferedInputStream inputStream = FileUtil.getInputStream(file);
        try {
            minioClient.putObject(bucket, name, inputStream,contentType);
            String imgUrl = minioClient.getObjectUrl(bucket, name);
            System.out.println(imgUrl);
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

    }*/

   /* @Test
    public  void  test9(){
        File files=new File("E:\\imagespro");
        String contentType="image/jpeg";
        String imageurl="https://fchost1.ccmma18.com/b/ei/CH37323.jpg";
        File file = HttpUtil.downloadFileFromUrl(imageurl,files ,1000*600);

    }*/
}


