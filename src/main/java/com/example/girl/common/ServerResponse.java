package com.example.girl.common;

import com.sun.org.apache.regexp.internal.RE;

public class ServerResponse<T> {
    /**错误码  */
    private Integer code;

    /**错误说明  */
    private String msg;

    /**返回的数据  */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ServerResponse(Integer code,String message){
        this.code=code;
        this.msg=message;
    }
    public ServerResponse(Integer code,String message,T data){
        this.code=code;
        this.msg=message;
        this.data=data;
    }

    public static <T>ServerResponse<T> success(Object object){
        return new ServerResponse(ResponseCode.SUCCESS.getCode(),"成功",object);
    }

    public static  <T>ServerResponse<T> success(String messag){
        return  new ServerResponse(ResponseCode.SUCCESS.getCode(),messag,null);
    }

    public static <T>ServerResponse<T> error(){
        return new ServerResponse(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc(),null);
    }

    public static <T>ServerResponse<T> error(String message){
        return new ServerResponse(ResponseCode.ERROR.getCode(),message,null);
    }

    public static <T>ServerResponse<T> error(int errorCode,String message){
        return new ServerResponse(errorCode,message,null);
    }


}
