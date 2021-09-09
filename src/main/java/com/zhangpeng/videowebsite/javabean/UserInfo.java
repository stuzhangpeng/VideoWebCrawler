package com.zhangpeng.videowebsite.javabean;

/**
 * @ClassName UserInfo
 * @Description 用户展示信息
 * @Author zhangpeng
 * @Date 2020/10/16 17:52
 * @Version 1.0
 */
public class UserInfo {
    /**
     * @Description 用户昵称
     */
    private String usercode;
    /**
     * @Description 用户id
     */
    private Integer userId;

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
