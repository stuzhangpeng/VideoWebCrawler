package com.zhangpeng.videowebsite.utils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zhangpeng.videowebsite.javabean.UserInfo;
import java.util.Calendar;
import java.util.Date;
/**
 * @ClassName JWTUtils
 * @Description jwt工具类，用于生成token，校验token
 * @Author zhangpeng
 * @Date 2020/10/24 15:33
 * @Version 1.0
 */
public class JWTUtils {
    /**
     * @Description  jwt密钥
     */
    private  static final String seckey="vuespringbootfilmwebsiteseckey";
    private  static final Algorithm HMAC256_ALOGORITHM=Algorithm.HMAC256(seckey);
    private  static final Algorithm HMAC384_ALOGORITHM=Algorithm.HMAC384(seckey);
    private static final Date expirtTime;
    static {
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DATE, 7);
        expirtTime=calendar.getTime();
    }
    /**
     * @Description 用HMAC256算法创建jwttoken
     * @Param [expireTime token过期时间, userInfo 放入payload的用户信息]
     * @return java.lang.String
     */
    public static String createHMAC256Token(Date expireTime, UserInfo userInfo){
        String token = JWT.create()
                .withClaim("username",userInfo.getUsercode()).withClaim("userid",userInfo.getUserId())//设置payload
                .withExpiresAt(expirtTime)//设置过期时间
                .sign(HMAC256_ALOGORITHM);//设置签名算法和密钥
        return token;
    }
    /**
     * @Description 用HMAC384算法创建jwttoken,
     * @Param [expireTime token过期时间, userInfo 放入payload的用户信息]
     * @return java.lang.String
     */
    public static String createHMAC384Token(Date expireTime, UserInfo userInfo){
        String token = JWT.create()
                .withClaim("username",userInfo.getUsercode()).withClaim("userid",userInfo.getUserId())//设置payload
                .withExpiresAt(expirtTime)//设置过期时间
                .sign(HMAC384_ALOGORITHM);//设置签名算法和密钥
        return token;
    }
    /**
     * @Description 创建默认时间的token，算法为HMAC256
     * @Param [userInfo]
     * @return java.lang.String
     */
    public static String createDefaultExpireTimeToken( UserInfo userInfo){
        String token = JWT.create()
                .withClaim("username",userInfo.getUsercode()).withClaim("userid",userInfo.getUserId())//设置payload
                .withExpiresAt(expirtTime)//设置过期时间
                .sign(HMAC256_ALOGORITHM);//设置签名算法和密钥
         return token;
    }
    /**
     * @Description HMAC256算法校验数据
     * @Param [token]
     * @return com.auth0.jwt.interfaces.DecodedJWT
     */
    public static DecodedJWT  vertifyTokenByHMAC256(String token ) {
      return JWT.require(HMAC256_ALOGORITHM).build().verify(token);
    }
    /**
     * @Description HMAC384算法校验数据
     * @Param [token]
     * @return com.auth0.jwt.interfaces.DecodedJWT
     */
    public static DecodedJWT vertifyTokenByHMAC384(String token ){
       return JWT.require(HMAC384_ALOGORITHM).build().verify(token);
    }
}
