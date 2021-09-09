package com.zhangpeng.videowebsite.service.Impl;

import com.zhangpeng.videowebsite.javabean.*;
import com.zhangpeng.videowebsite.mapper.FavouriteListMapper;
import com.zhangpeng.videowebsite.mapper.PlayHistoryMapper;
import com.zhangpeng.videowebsite.mapper.UserMapper;
import com.zhangpeng.videowebsite.mapper.VideoDetailMapper;
import com.zhangpeng.videowebsite.service.UserDataService;
import com.zhangpeng.videowebsite.service.UserService;
import com.zhangpeng.videowebsite.service.VideoDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserDataServiceImpl
 * @Description TODO
 * @Author zhangpeng
 * @Date 2020/11/17 20:33
 * @Version 1.0
 */
@Service
public class UserDataServiceImpl implements UserDataService {
    @Autowired
    private PlayHistoryMapper playHistoryMapper;
    @Autowired
    private FavouriteListMapper favouriteListMapper;
    @Autowired
    private VideoDetailService videoDetailService;
    @Autowired
    private UserService userService;
    @Override
    public List<PlayHistory> findPlayHistoryByUid(Integer uid) {
        PlayHistoryExample playHistoryExample=new PlayHistoryExample();
        PlayHistoryExample.Criteria criteria = playHistoryExample.createCriteria();
         criteria.andUidEqualTo(uid);
        List<PlayHistory> playHistorieList = playHistoryMapper.selectByExample(playHistoryExample);
        if(playHistorieList!=null&&playHistorieList.size()>0){
            return  playHistorieList;
        }
        return null;
    }

    @Override
    public List<FavouriteList> findFavouriteListByUid(Integer uid) {
        FavouriteListExample favouriteListExample=new FavouriteListExample();
        FavouriteListExample.Criteria criteria = favouriteListExample.createCriteria();
         criteria.andUidEqualTo(uid);
        List<FavouriteList> favouriteLists = favouriteListMapper.selectByExample(favouriteListExample);
        if(favouriteLists!=null&&favouriteLists.size()>0){
            return favouriteLists;
        }
        return null;
    }

    @Override
    public UserHomeData findUserHomeData(Integer uid) {
        UserHomeData userHomeData=new UserHomeData();
        List<FavouriteList> favouriteLists = findFavouriteListByUid(uid);
        List<PlayHistory> playHistorys = findPlayHistoryByUid(uid);
        if(favouriteLists!=null){
            List<Integer> vids=new ArrayList<>();
            for (PlayHistory playHistory:playHistorys){
                vids.add(playHistory.getVid());
            }
            //查询播放历史列表
            List<VideoDetail> playVideoList = videoDetailService.findVideoDetailById(vids);
            if (playVideoList!=null){
                userHomeData.setPlayVideoList(playVideoList);
            };
        }
        if(playHistorys!=null){
            List<Integer> playHistoryVids=new ArrayList<>();
            for (FavouriteList favouriteList:favouriteLists){
                playHistoryVids.add(favouriteList.getVid());
            }
            //查询播放历史列表
            List<VideoDetail> favouriteVideoList = videoDetailService.findVideoDetailById(playHistoryVids);
            if (favouriteVideoList!=null){
                userHomeData.setFavouriteVideoList(favouriteVideoList);
            };
        }
        return userHomeData;
    }
}
