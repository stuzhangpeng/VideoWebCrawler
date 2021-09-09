package com.zhangpeng.videowebsite.javabean;

import java.io.Serializable;
import java.util.Date;

public class VideoDetail implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column videodetail.vid
     *
     * @mbg.generated
     */
    private Integer vid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column videodetail.category
     *
     * @mbg.generated
     */
    private String category;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column videodetail.create_date
     *
     * @mbg.generated
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column videodetail.size
     *
     * @mbg.generated
     */
    private String size;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column videodetail.play_url
     *
     * @mbg.generated
     */
    private String playUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column videodetail.imageurl
     *
     * @mbg.generated
     */
    private String imageurl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column videodetail.doc_url
     *
     * @mbg.generated
     */
    private String docUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column videodetail.video_tittle
     *
     * @mbg.generated
     */
    private String videoTittle;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column videodetail.vid
     *
     * @return the value of videodetail.vid
     *
     * @mbg.generated
     */
    public Integer getVid() {
        return vid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column videodetail.vid
     *
     * @param vid the value for videodetail.vid
     *
     * @mbg.generated
     */
    public void setVid(Integer vid) {
        this.vid = vid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column videodetail.category
     *
     * @return the value of videodetail.category
     *
     * @mbg.generated
     */
    public String getCategory() {
        return category;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column videodetail.category
     *
     * @param category the value for videodetail.category
     *
     * @mbg.generated
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column videodetail.create_date
     *
     * @return the value of videodetail.create_date
     *
     * @mbg.generated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column videodetail.create_date
     *
     * @param createDate the value for videodetail.create_date
     *
     * @mbg.generated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column videodetail.size
     *
     * @return the value of videodetail.size
     *
     * @mbg.generated
     */
    public String getSize() {
        return size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column videodetail.size
     *
     * @param size the value for videodetail.size
     *
     * @mbg.generated
     */
    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column videodetail.play_url
     *
     * @return the value of videodetail.play_url
     *
     * @mbg.generated
     */
    public String getPlayUrl() {
        return playUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column videodetail.play_url
     *
     * @param playUrl the value for videodetail.play_url
     *
     * @mbg.generated
     */
    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl == null ? null : playUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column videodetail.imageurl
     *
     * @return the value of videodetail.imageurl
     *
     * @mbg.generated
     */
    public String getImageurl() {
        return imageurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column videodetail.imageurl
     *
     * @param imageurl the value for videodetail.imageurl
     *
     * @mbg.generated
     */
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column videodetail.doc_url
     *
     * @return the value of videodetail.doc_url
     *
     * @mbg.generated
     */
    public String getDocUrl() {
        return docUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column videodetail.doc_url
     *
     * @param docUrl the value for videodetail.doc_url
     *
     * @mbg.generated
     */
    public void setDocUrl(String docUrl) {
        this.docUrl = docUrl == null ? null : docUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column videodetail.video_tittle
     *
     * @return the value of videodetail.video_tittle
     *
     * @mbg.generated
     */
    public String getVideoTittle() {
        return videoTittle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column videodetail.video_tittle
     *
     * @param videoTittle the value for videodetail.video_tittle
     *
     * @mbg.generated
     */
    public void setVideoTittle(String videoTittle) {
        this.videoTittle = videoTittle == null ? null : videoTittle.trim();
    }
}