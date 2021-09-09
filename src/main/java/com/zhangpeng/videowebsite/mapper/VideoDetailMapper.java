package com.zhangpeng.videowebsite.mapper;

import com.zhangpeng.videowebsite.javabean.VideoDetail;
import com.zhangpeng.videowebsite.javabean.VideoDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table videodetail
     *
     * @mbg.generated
     */
    long countByExample(VideoDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table videodetail
     *
     * @mbg.generated
     */
    int deleteByExample(VideoDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table videodetail
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer vid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table videodetail
     *
     * @mbg.generated
     */
    int insert(VideoDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table videodetail
     *
     * @mbg.generated
     */
    int insertSelective(VideoDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table videodetail
     *
     * @mbg.generated
     */
    List<VideoDetail> selectByExampleWithBLOBs(VideoDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table videodetail
     *
     * @mbg.generated
     */
    List<VideoDetail> selectByExample(VideoDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table videodetail
     *
     * @mbg.generated
     */
    VideoDetail selectByPrimaryKey(Integer vid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table videodetail
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") VideoDetail record, @Param("example") VideoDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table videodetail
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") VideoDetail record, @Param("example") VideoDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table videodetail
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") VideoDetail record, @Param("example") VideoDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table videodetail
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(VideoDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table videodetail
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(VideoDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table videodetail
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(VideoDetail record);
}