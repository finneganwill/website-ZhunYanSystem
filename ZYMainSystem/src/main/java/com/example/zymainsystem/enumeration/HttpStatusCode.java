package com.example.zymainsystem.enumeration;

import com.google.gson.Gson;

/**
 * TODO Http状态码
 *
 * @Author : WuXian
 * @Time : 2021/7/25 12:50
 */
public enum HttpStatusCode {

    //接受
    OK(200, "Ok", null),//接受
    REDIRECT(300, "Redirect", ""),//重定向
    BAD(400, "Bad", null),//拒绝

    FORBIDDEN(403, "Forbidden", ""),//服务器已访问
    NOT_FOUND(404, "Not Found", ""),//服务器未找到资源
    INTERNAL_SERVER_ERROR(500, "	Internal Server Error", "");//服务器内部错误

    private int code;
    private String msg;
    private String url;

    HttpStatusCode(int code, String msg, String url) {
        this.code = code;
        this.msg = msg;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "{\"code\":"
                +  code + ","
                + "\"msg\":"
                + "\"" + msg + "\","
                + "\"url\":"
                + "\"" + url + "\"}";
    }
}
