package com.hyp.ques.common.service;


import com.hyp.ques.common.result.ResultCode;

/**
 * 服务（业务）异常如“ 账号或密码错误 ”，该异常只做INFO级别的日志记录 @see WebMvcConfigurer
 */
public class ServiceException extends RuntimeException {

    private ResultCode code;


    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }


    public ServiceException(String message, ResultCode code) {
        super(message);
        this.code = code;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }


    public ServiceException(String message, Throwable cause, ResultCode code) {
        super(message, cause);
        this.code = code;
    }

    public ResultCode getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code;
    }


}
