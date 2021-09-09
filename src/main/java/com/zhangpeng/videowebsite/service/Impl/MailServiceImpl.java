package com.zhangpeng.videowebsite.service.Impl;
import cn.hutool.extra.mail.MailUtil;
import com.zhangpeng.videowebsite.javabean.CommonResult;
import com.zhangpeng.videowebsite.javabean.User;
import com.zhangpeng.videowebsite.service.MailService;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @ClassName MailServiceImpl
 * @Description 邮件发送服务实现
 * @Author zhangpeng
 * @Date 2020/10/27 15:18
 * @Version 1.0
 */
@Service
public class MailServiceImpl implements MailService {
    @Override
    public void sendMail(Boolean isHtml,String content, String subject, String to, File... files) {
        MailUtil.send(to, subject, content,isHtml, files);
    }
}
