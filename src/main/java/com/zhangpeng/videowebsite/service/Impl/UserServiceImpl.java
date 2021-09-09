
package com.zhangpeng.videowebsite.service.Impl;

import cn.hutool.core.util.IdUtil;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zhangpeng.videowebsite.javabean.*;
import com.zhangpeng.videowebsite.mapper.UserMapper;
import com.zhangpeng.videowebsite.service.MailService;
import com.zhangpeng.videowebsite.service.UserService;
import com.zhangpeng.videowebsite.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.UUID;


/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author zhangpeng
 * @Date 2020/10/16 14:59
 * @Version 1.0
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    MailService mailService;
    @Autowired
    private UserMapper userMapper;
    @Override
    public CommonResult addUser(User user) {
        CommonResult commonResult=new CommonResult();
        commonResult.setCode("500");
        String username = user.getUsername();
        User userByEmail = findUserByEmail(user.getEmail());
        User userByName = findUserByName(user.getUsername());
        if( userByEmail!=null&&userByName!=null){
            commonResult.setMessage("用户名已经存在，邮箱已经注册");
            return commonResult;
        }
        if(userByName!=null){
            commonResult.setMessage("用户名已经存在");
            return commonResult;
        }
        if(userByEmail!=null){
            commonResult.setMessage("邮箱已经注册");
            return commonResult;
        }
        //密码加密
        String salt = UUID.randomUUID().toString();
        String orinication=user.getPassword()+salt;
        String password = DigestUtils.md5DigestAsHex(orinication.getBytes());
        user.setPassword(password);
        user.setSalt(salt);
        String code = IdUtil.simpleUUID();
        String usercode = IdUtil.simpleUUID();
        user.setCode(code);
        user.setUsercode(usercode);
        user.setStatus("N");
        userMapper.insert(user);
        //发送邮件
        String content="<h1>尊敬的"+username+"!</h1><br><h2>感谢您的注册！请点击下方链接激活邮箱,如果本次操作不是您本人执行，请忽略</h2><br>" +
                "<h3>http://localhost/confirmRegister/"+code+"<h3/>";
        mailService.sendMail(true, content, "邮箱激活", user.getEmail());
        commonResult.setMessage("用户注册成功，请登录邮箱激活此次注册!");
        commonResult.setCode("200");
        return commonResult;
    }

    @Override
    public CommonResult findUser(User user) {
        CommonResult commonResult=new CommonResult();
        commonResult.setCode("403");
        commonResult.setMessage("用户名或密码错误");
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        List<User> users = userMapper.selectByExample(userExample);
        if(users==null||users.isEmpty()){
            return commonResult;
        }else{
            User userFind=users.get(0);
            String salt = userFind.getSalt();
            String password = userFind.getPassword();
            String orinication=user.getPassword()+salt;
            if(DigestUtils.md5DigestAsHex(orinication.getBytes()).equals(password)){
                //校验邮箱是否激活
                if(userFind.getStatus().equals("Y")){
                    commonResult.setCode("200");
                    commonResult.setMessage("登录成功");
                    UserInfo userInfo = new UserInfo();
                    userInfo.setUsercode(userFind.getUsercode());
                    userInfo.setUserId(userFind.getUid());
                    commonResult.setData(JWTUtils.createDefaultExpireTimeToken(userInfo));
                    return commonResult;
                }else{
                    commonResult.setMessage("注册尚未激活，请登录注册邮箱，激活后登录");
                    return commonResult;
                }

            }
            return commonResult;
        }
    }


    @Override
    public User findUserByName(String username) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        if(users!=null&&users.size()>0){
           return users.get(0);
        }else{
            return null;
        }
    }
    public User findUserByEmail(String email) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andEmailEqualTo(email);
        List<User> users = userMapper.selectByExample(userExample);
        if(users!=null&&users.size()>0){
           return users.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Boolean findUserByCode(String code) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andCodeEqualTo(code);
        List<User> users = userMapper.selectByExample(userExample);
        if(users!=null&&users.size()>0){
            //设置邮箱激活标志位
          users.get(0).setStatus("Y");
          users.get(0).setCode("");
          //更新user信息
          userMapper.updateByPrimaryKey(users.get(0));
          return true;
        }else{
            return false;
        }
    }

    @Override
    public User findUserById(Integer id) {
        UserKey userKey=new UserKey();
        userKey.setUid(id);
        User user = userMapper.selectByPrimaryKey(userKey);
        if(user!=null&&user.getUid()!=null){
           return user;
        }
        return null;
    }

    @Override
    public UserInfo getUserInfo(String token) {
        DecodedJWT decodedJWT = JWTUtils.vertifyTokenByHMAC256(token);
        String username = decodedJWT.getClaim("username").asString();
        Integer userid = decodedJWT.getClaim("userid").asInt();
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(userid);
        userInfo.setUsercode(username);
        return userInfo;
    }
}

