package com.zhangpeng.videowebsite.service;

import com.zhangpeng.videowebsite.javabean.FavouriteList;
import com.zhangpeng.videowebsite.javabean.PlayHistory;
import com.zhangpeng.videowebsite.javabean.UserHomeData;

import java.util.List;

/**
 * @ClassName UserDataService
 * @Description TODO
 * @Author zhangpeng
 * @Date 2020/11/17 20:28
 * @Version 1.0
 */
public interface UserDataService {
    public List<PlayHistory> findPlayHistoryByUid(Integer uid);
    public List<FavouriteList> findFavouriteListByUid(Integer uid);
    public UserHomeData findUserHomeData(Integer uid); 
}
