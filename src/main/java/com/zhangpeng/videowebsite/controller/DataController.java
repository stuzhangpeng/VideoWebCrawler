package com.zhangpeng.videowebsite.controller;
import com.zhangpeng.videowebsite.javabean.CommonResult;
import com.zhangpeng.videowebsite.javabean.IndexPageData;
import com.zhangpeng.videowebsite.javabean.RotationChart;
import com.zhangpeng.videowebsite.javabean.UserHomeData;
import com.zhangpeng.videowebsite.service.UserDataService;
import com.zhangpeng.videowebsite.service.VideoSearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName DataController
 * @Description 数据请求controller
 * @Author zhangpeng
 * @Date 2020/10/22 12:25
 * @Version 1.0
 */
@RestController
@Api(tags = "数据获取controller")
public class DataController {
    /**
     * @Description 处理前端首页数据强求，结果以json格式返回
     * @Param
     * @return com.zhangpeng.videowebsite.javabean.IndexPageData
     */
    @Autowired
    private VideoSearchService videoSearchService;
    @Autowired
    private UserDataService userDataService;
    @ApiOperation(value = "首页数据获取",response = CommonResult.class)
    @GetMapping("/indexPage")
    public IndexPageData getIndexPageData(String category,String type,Integer page,Integer pagesize){
        List<Map<String, Object>> list = videoSearchService.searchVideoByCategory(category, page, pagesize);
        List<Map<String, Object>> types = videoSearchService.searchVideoByCategory(type, page, pagesize);
        List<RotationChart> rotationChartList=new ArrayList<>();
        RotationChart rotationChart1=new RotationChart("http://192.168.0.109/img/rotationChartItem1.jpg", 800, 600, 1);
        RotationChart rotationChart2=new RotationChart("http://192.168.0.109/img/rotationChartItem2.jpg", 800, 600, 2);
        RotationChart rotationChart3=new RotationChart("http://192.168.0.109/img/rotationChartItem3.jpg", 800, 600, 3);
        rotationChartList.add(rotationChart1);
        rotationChartList.add(rotationChart2);
        rotationChartList.add(rotationChart3);
        IndexPageData indexPageData=new IndexPageData();
        indexPageData.setRotationCharts(rotationChartList);
        if (list!=null){
            indexPageData.getList().add(list);
        }
        if(types!=null){
          indexPageData.getList().add(types);
        }
        return indexPageData;
    }
    /*
     * @Description 返回userhome信息
     * @Param
     * @return
     */
    @GetMapping("/userHome")
    public UserHomeData getUserHomeData(Integer uid){
        UserHomeData userHomeData = userDataService.findUserHomeData(uid);
        return userHomeData;
    }
    /**
     * @Description 添加用户播放历史记录
     * @Param [vid 视频id, uid 用户ID]
     * @return com.zhangpeng.videowebsite.javabean.CommonResult
     */
     @PostMapping("/playHistory")
    public CommonResult addPlayHistoryByUid(Integer vid,Integer uid){
        return  null;
     };
}
