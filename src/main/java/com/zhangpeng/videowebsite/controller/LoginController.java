package com.zhangpeng.videowebsite.controller;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zhangpeng.videowebsite.javabean.CommonResult;
import com.zhangpeng.videowebsite.javabean.User;
import com.zhangpeng.videowebsite.javabean.UserInfo;
import com.zhangpeng.videowebsite.service.UserService;
import com.zhangpeng.videowebsite.utils.JWTUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Description 用户认证controller
 * @Author zhangpeng
 * @Date 2020/10/16 9:03
 * @Version 1.0
 */
@RestController
@Api(tags = "用户登录controller")
public class LoginController {
    @Autowired
    UserService userService;
    @ApiOperation(value = "用户登录",response = CommonResult.class)
    @PostMapping("/login")
    public CommonResult login( User user) {
        CommonResult result = userService.findUser(user);
        return result;
    }
    /**
     * @Description 根据jwttoken获取用户信息
     * @Param [token]
     * @return com.zhangpeng.videowebsite.javabean.CommonResult
     */
    @GetMapping("/userInfo")
    public CommonResult getUserInfo(@RequestHeader String token) {
        DecodedJWT decodedJWT = JWTUtils.vertifyTokenByHMAC256(token);
        String username = decodedJWT.getClaim("username").asString();
        Integer uid = decodedJWT.getClaim("userid").asInt();
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(uid);
        userInfo.setUsercode(username);
        CommonResult commonResult=new CommonResult();
        commonResult.setCode("200");
        commonResult.setMessage("success");
        commonResult.setData(userInfo);
        return  commonResult;
    }
}
