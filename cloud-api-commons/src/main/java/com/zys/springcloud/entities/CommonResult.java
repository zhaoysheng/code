package com.zys.springcloud.entities;

public class CommonResult<T> {

    private Integer code;
    private String Message;
    private T data;

    public CommonResult(Integer code, String Message){
        this(code,Message,null);
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        Message = message;
        this.data = data;
    }

    public CommonResult() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
