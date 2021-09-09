package com.zhangpeng.videowebsite.controller;
import com.zhangpeng.videowebsite.javabean.CommonResult;
import com.zhangpeng.videowebsite.javabean.User;
import com.zhangpeng.videowebsite.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
/**
 * @ClassName RegistController
 * @Description 用户注册controller
 * @Author zhangpeng
 * @Date 2020/10/16 9:02
 * @Version 1.0
 */
@Api(tags = "用户注册controller")
@Controller
public class RegistController {
    @Autowired
    private UserService userService;
    /**
     * @Description 用户注册
     * @Param [token, validateCode, user, request]
     * @return java.lang.String
     */
    @ApiOperation(value = "用户注册",response = CommonResult.class)
    @ResponseBody
    @PostMapping("/register")
       public CommonResult register( User user, HttpServletRequest request) {
       return userService.addUser(user);
    }
    /**
     * @Description 根据code激活邮箱
     * @Param [code]
     * @return java.lang.String 返回成功或失败的视图
     */
    @ApiOperation(value = "注册邮箱激活",response = CommonResult.class)
    @GetMapping("/confirmRegister/{code}")
       public String confirmRegister(@PathVariable("code") String code) {
        Boolean userByCode = userService.findUserByCode(code);
        if(userByCode){
            return "/html/confirmregistersuccess.html";
        }else{
            return "/html/confirmregisterfailuer.html";
        }
    }
}
