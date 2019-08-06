package com.nanfeng.emnu;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-05 10:52
 */
public enum ErrorCode {

    G1001(1001,"参数异常"),
    G1002(1002,"IO操作异常"),
    G1003(1003,"文件找不到"),
    G1004(1004,"IO流关闭异常"),
    G1007(1005,"业务异常"),
    ;


    private int code;
    private  String message;

    ErrorCode(int code, String message){
        this.code = code;
        this.message = message;
    }

    public final int getCode(){
        return code;
    }
    public final String getMessage(){
        return message;
    }




}
