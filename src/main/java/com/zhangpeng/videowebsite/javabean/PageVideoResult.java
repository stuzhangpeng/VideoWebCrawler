package com.zhangpeng.videowebsite.javabean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName PageVideoResult
 * @Description 视频列表分页信息javabean
 * @Author zhangpeng
 * @Date 2020/11/9 13:26
 * @Version 1.0
 */
public class PageVideoResult {
    private Long count;
    private Long totalpage;
    private int curpage;
    private List<Map<String,Object>> mapList=new ArrayList<>();

    public int getCurpage() {
        return curpage;
    }

    public void setCurpage(int curpage) {
        this.curpage = curpage;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(Long totalpage) {
        this.totalpage = totalpage;
    }

    public List<Map<String, Object>> getMapList() {
        return mapList;
    }

    public void setMapList(List<Map<String, Object>> mapList) {
        this.mapList = mapList;
    }
}
