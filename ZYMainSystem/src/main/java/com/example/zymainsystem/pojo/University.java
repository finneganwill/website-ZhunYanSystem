package com.example.zymainsystem.pojo;

import org.springframework.stereotype.Component;

/**
 * TODO 高等院校
 *
 * @Author : WuXian
 * @Time : 2021/7/28 10:04
 */
@Component
public class University {
    private String code;
    private String name;
    private String license;

    public University() {
    }

    @Override
    public String toString() {
        return "University{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", license='" + license + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}
