package com.zhangpeng.videowebsite.javabean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @ClassName RotationChart
 * @Description 轮播图pojo
 * @Author zhangpeng
 * @Date 2020/10/22 12:32
 * @Version 1.0
 */
@ApiModel(description = "轮播图描述类",value = "轮播图")
public class RotationChart implements Serializable {
    /**
     * @Description 图片url
     * @Param url
     */
    @ApiModelProperty("图片url")
    private String url;
    /**
     * @Description 图片宽度
     * @Param width
     */

    @ApiModelProperty("图片宽度")
    private Integer width;
    /**
     * @Description 图片高度
     * @Param height
     */

    @ApiModelProperty("图片高度")
    private Integer height;
    /**
     * @Description 图片排序id
     * @Param sid
     */

    @ApiModelProperty("图片id")
    private Integer sid;

    public RotationChart() {
    }

    public RotationChart(String url, Integer width, Integer height, Integer sid) {
        this.url = url;
        this.width = width;
        this.height = height;
        this.sid = sid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

}
