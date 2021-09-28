package com.example.zymainsystem.pojo;

import org.springframework.stereotype.Component;

/**
 * TODO 实体类User
 *
 * @Author : WuXian
 * @Time : 2021/7/10 14:45
 */
@Component
public class User {
    private int id;
    private String username;
    private String password;
    private int permission;
    private String online;
    private String alias;
    private int sex;
    private String img;
    private String phone;
    private String email;
    private String birthday;
    private String almamater;
    private String goalmater;
    private String info;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", permission=" + permission +
                ", online='" + online + '\'' +
                ", alias='" + alias + '\'' +
                ", sex=" + sex +
                ", img='" + img + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                ", almamater='" + almamater + '\'' +
                ", goalmater='" + goalmater + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAlmamater() {
        return almamater;
    }

    public void setAlmamater(String almamater) {
        this.almamater = almamater;
    }

    public String getGoalmater() {
        return goalmater;
    }

    public void setGoalmater(String goalmater) {
        this.goalmater = goalmater;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}


