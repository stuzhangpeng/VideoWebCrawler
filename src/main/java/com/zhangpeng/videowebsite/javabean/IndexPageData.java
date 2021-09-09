package com.zhangpeng.videowebsite.javabean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName IndexPageData 首页数据pojo
 * @Description TODO
 * @Author zhangpeng
 * @Date 2020/10/22 12:30
 * @Version 1.0
 */
@ApiModel(description = "首页数据封装",value = "首页数据")
public class IndexPageData implements Serializable {
    @ApiModelProperty("轮播图片列表")
    private List<RotationChart> rotationCharts=new ArrayList<RotationChart>();
    private List<List<Map<String,Object>>> list=new ArrayList();
    public IndexPageData() {
    }
    public List<RotationChart> getRotationCharts() {
        return rotationCharts;
    }

    public void setRotationCharts(List<RotationChart> rotationCharts) {
        this.rotationCharts = rotationCharts;
    }

    public List<List<Map<String, Object>>> getList() {
        return list;
    }

    public void setList(List<List<Map<String, Object>>> list) {
        this.list = list;
    }
}
