package com.example.zymainsystem.enumeration;

/**
 * TODO 性别枚举
 *
 * @Author : WuXian
 * @Time : 2021/7/27 11:16
 */
public enum Sex {
    OTHER(0, "保密"),
    MALE(1, "男"),
    FEMALE(2, "女");

    private int code;
    private String msg;

    Sex(int code, String msg) {
        this.code = code;
        this.msg = msg;
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

    public static String getMsgByCode(int code){
        if(code == 0){
            return OTHER.getMsg();
        }else if(code == 1){
            return MALE.getMsg();
        }else {
            return FEMALE.getMsg();
        }
    }
}
