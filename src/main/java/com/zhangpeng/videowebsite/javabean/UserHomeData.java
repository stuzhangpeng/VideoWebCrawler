package com.zhangpeng.videowebsite.javabean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserHomeData
 * @Description TODO
 * @Author zhangpeng
 * @Date 2020/11/17 20:04
 * @Version 1.0
 */
public class UserHomeData {
    private List<VideoDetail> playVideoList=new ArrayList();
    private List<VideoDetail> favouriteVideoList=new ArrayList();

    public List<VideoDetail> getPlayVideoList() {
        return playVideoList;
    }

    public void setPlayVideoList(List<VideoDetail> playVideoList) {
        this.playVideoList = playVideoList;
    }

    public List<VideoDetail> getFavouriteVideoList() {
        return favouriteVideoList;
    }

    public void setFavouriteVideoList(List<VideoDetail> favouriteVideoList) {
        this.favouriteVideoList = favouriteVideoList;
    }
}
