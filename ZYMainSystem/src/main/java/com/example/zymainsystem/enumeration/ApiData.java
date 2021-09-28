package com.example.zymainsystem.enumeration;

import com.google.gson.Gson;

/**
 * TODO 接口数据json格式
 *
 * @Author : WuXian
 * @Time : 2021/9/26 19:29
 */
public class ApiData {
    private int code;
    private String msg;
    private int count;
    private Object data;

    public ApiData(int code, String msg, int count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
