package com.zhangpeng.videowebsite.mapper;

import com.zhangpeng.videowebsite.javabean.PlayHistory;
import com.zhangpeng.videowebsite.javabean.PlayHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlayHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table playhistory
     *
     * @mbg.generated
     */
    long countByExample(PlayHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table playhistory
     *
     * @mbg.generated
     */
    int deleteByExample(PlayHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table playhistory
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table playhistory
     *
     * @mbg.generated
     */
    int insert(PlayHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table playhistory
     *
     * @mbg.generated
     */
    int insertSelective(PlayHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table playhistory
     *
     * @mbg.generated
     */
    List<PlayHistory> selectByExample(PlayHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table playhistory
     *
     * @mbg.generated
     */
    PlayHistory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table playhistory
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") PlayHistory record, @Param("example") PlayHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table playhistory
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") PlayHistory record, @Param("example") PlayHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table playhistory
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(PlayHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table playhistory
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(PlayHistory record);
}