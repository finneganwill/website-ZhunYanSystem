package com.example.zymainsystem.enumeration;

/**
 * TODO
 *
 * @Author : WuXian
 * @Time : 2021/7/12 18:39
 */
public enum LoginStatus {
    ALLOW(1, "登录成功"),
    FORBID(2, "密码错误"),
    WARN(3, "账号不存在");

    private Integer key;
    private String value;
//    private Boolean action;

    LoginStatus(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
