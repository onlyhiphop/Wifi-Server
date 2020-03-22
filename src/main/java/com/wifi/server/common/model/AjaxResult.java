package com.wifi.server.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一接口返回类型
 * @author liaobaocai
 * @date 2020/3/19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AjaxResult<T> implements Serializable {
    private int code;
    private String msg;
    private T data;


    /**
     * 返回成功结果
     * @param data 结果数据
     * @param <T>
     * @return
     */
    public static <T> AjaxResult<T> success(T data){
        return new AjaxResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), data);
    }

    /**
     * 返回成功结果，自定义返回消息
     * @param data 结果数据
     * @param message 自定义消息
     * @param <T>
     * @return
     */
    public static <T> AjaxResult<T> success(T data, String message){
        return new AjaxResult<T>(ResultCode.SUCCESS.getCode(),message, data);
    }

    /**
     * 返回错误结果，自定义错误消息
     * @param message 自定义错误消息
     * @param <T>
     * @return
     */
    public static <T> AjaxResult<T> failed(String message){
        return new AjaxResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 返回错误结果
     * @param <T>
     * @return
     */
    public static <T> AjaxResult<T> failed(){
        return failed(ResultCode.FAILED.getMsg());
    }
}
