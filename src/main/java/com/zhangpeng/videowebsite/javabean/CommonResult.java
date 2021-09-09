package com.zhangpeng.videowebsite.javabean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @ClassName MessageContent
 * @Description 前端内容返回实体类
 * @Author zhangpeng
 * @Date 2020/10/23 14:26
 * @Version 1.0
 */
@ApiModel(description = "结果统一返回封装",value = "返回结果")
public class CommonResult <T>implements Serializable {
    /**
     * @Description
     */
    @ApiModelProperty("结果返回的状态码，401:未认证，406：未授权，200：成功，403：数据校验不通过,500：服务器错误")
    private String code;
    /**
     * @Description 返回信息描述
     */
    @ApiModelProperty("返回结果的提示消息，正常返回：成功，非正常返回：错误提示消息具体内容")
    private String message;
    /**
     * @Description消息返回实体
     */
    @ApiModelProperty(value = "返回结果为具体业务相关实体数据，没有返回结果时默认为null")
    private T data;

    public CommonResult() {
    }

    public CommonResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
