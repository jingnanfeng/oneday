package com.nanfeng.exception;

import java.io.Serializable;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-05 10:45
 */
public class BusinessException extends RuntimeException
        implements Serializable {

    private static final long serialVersionUID = -3129813512425696662L;

    private int code;

    public BusinessException(){}

    public BusinessException(String message){
        super(message);
    }
    public BusinessException(String message, Throwable cause){
        super(message,cause);
    }
    public BusinessException(Throwable cause){
        super(cause);
    }
    public BusinessException(int cede, String message){
        super(message);
        this.code = cede;
    }

    public int getCode(){
        return code;
    }
    public void setCode(int code){
        this.code = code;
    }

}
