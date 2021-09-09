package com.zhangpeng.videowebsite.service;

import com.zhangpeng.videowebsite.javabean.CommonResult;

import java.io.File;

/**
 * @ClassName MailService
 * @Description 邮件发送服务
 * @Author zhangpeng
 * @Date 2020/10/27 15:18
 * @Version 1.0
 */
public interface MailService {
    public void sendMail(Boolean isHtml,String content, String subject, String to, File...files);
}
