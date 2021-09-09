package com.zhangpeng.videowebsite.service;

import com.zhangpeng.videowebsite.javabean.CommonResult;
import com.zhangpeng.videowebsite.javabean.User;
import com.zhangpeng.videowebsite.javabean.UserInfo;

/**
 * @ClassName UserService
 * @Description 用户service类
 * @Author zhangpeng
 * @Date 2020/10/16 14:58
 * @Version 1.0
 */
public interface UserService {
    /**
     * @Description 用户注册
     * @Param [user]
     * @return void
     */
    public CommonResult addUser(User user);
    /**
     * @Description 用户登录
     * @Param [ CommonResult]
     * @return void
     */
    public CommonResult findUser(User user);
    /**
     * @Description根据用户名查找用户
     * @Param user 前台传过来的user
     * @return com.zhangpeng.videowebsite.javabean.User
     */
    public User findUserByName(String userName);
    /**
     * @Description 根据邮箱查找用户，判断邮箱是否已注册
     * @Param [user]
     * @return com.zhangpeng.videowebsite.javabean.User
     */
    public User findUserByEmail(String email);
    /**
     * @Description 根据code查找用户并激活注册邮箱,成功返回true，失败返回false
     * @Param [code]
     * @return java.lang.Boolean true
     */
    public Boolean findUserByCode(String code);
    public User findUserById(Integer id);
    public UserInfo getUserInfo(String token);
}
