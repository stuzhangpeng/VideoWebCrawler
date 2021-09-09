package com.zhangpeng.videowebsite.configuration;
import com.zhangpeng.videowebsite.javabean.CommonResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
/**
 * @ClassName GlobalReturnConfig
 * @Description 全局返回值包装成CommonResult
 * @Author zhangpeng
 * @Date 2020/10/27 14:12
 * @Version 1.0
 */

@ControllerAdvice(basePackages = {"com.zhangpeng.videowebsite.controller"})
public class GlobalReturnConfig implements ResponseBodyAdvice{

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if(body instanceof CommonResult){
            return body;
        }
        return new CommonResult<>("200","成功",body);
    }
}


