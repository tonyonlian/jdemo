package com.tongyl.example.jdemosb.enums;

/**
 * 定义错误枚举
 * @author Created by Tunyl on 2019/7/26.
 * @version 1.0
 */
public enum ErrorCode {
    /**
     * code：200，message：成功
     */
    SUCCESS(200,"成功"),
    NO_PERMISSION(211,"权限不足"),
    SERVER_ERROR(10000,"服务器异常"),
    AUTH_ERROR(10001,"认证失败"),
    PARAMS_ERROR(10002,"参数错误"),
    JSON_PARSE_ERROR(10003,"Json解析错误"),
    ILLEAGAL_STRING(15001,"非法字符串"),
    UNKNOW_ERROR(16000,"未知错误");

    private Integer code;
    private String msg;

    ErrorCode(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
