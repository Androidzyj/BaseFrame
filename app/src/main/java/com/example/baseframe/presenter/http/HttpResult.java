package com.example.baseframe.presenter.http;

/**
 * Created by Administrator on 2019/9/4 0004
 * 返回请求结果封装
 */
public class HttpResult<T> {
    private int code;
    private String msg;
    private T subjects;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }

    public T getSubjects() {
        return subjects;
    }

    public void setSubjects(T subjects) {
        this.subjects = subjects;
    }
}
