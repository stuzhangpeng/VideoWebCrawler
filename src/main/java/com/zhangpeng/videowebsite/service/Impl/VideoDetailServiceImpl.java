package com.zhangpeng.videowebsite.service.Impl;

import com.zhangpeng.videowebsite.javabean.VideoDetail;
import com.zhangpeng.videowebsite.javabean.VideoDetailExample;
import com.zhangpeng.videowebsite.mapper.VideoDetailMapper;
import com.zhangpeng.videowebsite.service.VideoDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName VideoDetailServiceImpl
 * @Description TODO
 * @Author zhangpeng
 * @Date 2020/10/16 14:59
 * @Version 1.0
 */
@Service
public class VideoDetailServiceImpl implements VideoDetailService {
    @Autowired
    private VideoDetailMapper videoDetailMapper;
    @Override
    public List<VideoDetail> findVideoDetailById(List<Integer> vids) {
        VideoDetailExample videoDetailExample=new VideoDetailExample();
        VideoDetailExample.Criteria criteria = videoDetailExample.createCriteria();
        criteria.andVidIn(vids);
        List<VideoDetail> videoDetailList = videoDetailMapper.selectByExample(videoDetailExample);
        if(videoDetailList!=null&&videoDetailList.size()>0){
            return videoDetailList;
        }

        return null;
    }
}
