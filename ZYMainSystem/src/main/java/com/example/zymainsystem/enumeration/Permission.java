package com.example.zymainsystem.enumeration;

/**
 * TODO
 *
 * @Author : WuXian
 * @Time : 2021/7/10 17:06
 */
public enum Permission {

    NORMAL(1, "normal", "普通用户"),
    BAN(2, "ban", "黑名单"),
    VIP(3, "vip", "vip");

    private int key;
    private String value;
    private String desc;

    Permission(int key, String value, String desc) {
        this.key = key;
        this.value = value;
        this.desc = desc;
    }


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
