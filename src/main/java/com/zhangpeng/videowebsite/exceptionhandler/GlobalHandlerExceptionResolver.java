package com.zhangpeng.videowebsite.exceptionhandler;
import com.zhangpeng.videowebsite.javabean.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * @ClassName GlobalHandlerExceptionResolver
 * @Description 全局异常处理器
 * @Author zhangpeng
 * @Date 2020/10/24 18:54
 * @Version 1.0
 */
@RestControllerAdvice
public class GlobalHandlerExceptionResolver {
    /**
     * @Description 全局异常处理器，返回json数据
     * @Param [ex]  捕获到的异常
     * @return java.lang.String
     */
    @ExceptionHandler(Exception.class)
    public CommonResult handleException(Exception ex){
        //记录日志
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.error(ex.getMessage(),ex.getStackTrace());
        return new CommonResult("500","服务器错误",null);
    }
}
