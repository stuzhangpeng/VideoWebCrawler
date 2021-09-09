package com.zhangpeng.videowebsite.mapper;

import com.zhangpeng.videowebsite.javabean.FavouriteList;
import com.zhangpeng.videowebsite.javabean.FavouriteListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FavouriteListMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favouritelist
     *
     * @mbg.generated
     */
    long countByExample(FavouriteListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favouritelist
     *
     * @mbg.generated
     */
    int deleteByExample(FavouriteListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favouritelist
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favouritelist
     *
     * @mbg.generated
     */
    int insert(FavouriteList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favouritelist
     *
     * @mbg.generated
     */
    int insertSelective(FavouriteList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favouritelist
     *
     * @mbg.generated
     */
    List<FavouriteList> selectByExample(FavouriteListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favouritelist
     *
     * @mbg.generated
     */
    FavouriteList selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favouritelist
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") FavouriteList record, @Param("example") FavouriteListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favouritelist
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") FavouriteList record, @Param("example") FavouriteListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favouritelist
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(FavouriteList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favouritelist
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(FavouriteList record);
}