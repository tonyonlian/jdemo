package com.tongyl.example.jdemosb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tongyl.example.jdemosb.enums.ErrorCode;

import java.io.Serializable;

/**
 * restful api的统计结果类
 * @author Created by Tunyl on 2019/7/26.
 * @version 1.0
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -4577255781088498763L;

    private Integer err_no;
    private String err_msg;
    private T data;

    //构造器
    public Result(){
        setErrorCode(ErrorCode.SUCCESS);
    }
    public Result(T data){
        setErrorCode(ErrorCode.SUCCESS);
        this.data = data;
    }
    public Result(Result result){
        if(result == null){
            return ;
        }
        this.err_no = result.getErr_no();
        this.err_msg = result.getErr_msg();
    }
    public Result(ErrorCode errorCode){
        setErrorCode(errorCode);
    }

    //方法

    public static Result ok(){
        return new Result();
    }
    public static Result fail(ErrorCode errorCode){
        return new Result(errorCode);
    }
    @JsonIgnore
    public boolean isSuc(){
        return ErrorCode.SUCCESS.getCode().equals(err_no);
    }
    @JsonIgnore
    public boolean isFail(){
        return !isSuc();
    }

    public Result<T> setErrorCode(ErrorCode errorCode){
        return setErrorCode(errorCode.getCode(),errorCode.getMsg());
    }

    public Result<T> setErrorCode(Integer code,String errMsg){
        this.err_msg = errMsg;
        this.err_no = code;
        this.data = null;
        return this;
    }

    public Integer getErr_no() {
        return err_no;
    }

    public void setErr_no(Integer err_no) {
        this.err_no = err_no;
    }

    public String getErr_msg() {
        return err_msg;
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }
}
