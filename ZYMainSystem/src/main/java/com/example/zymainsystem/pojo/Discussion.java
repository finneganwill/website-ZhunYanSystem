package com.example.zymainsystem.pojo;

import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @Author : WuXian
 * @Time : 2021/9/20 20:30
 */
@Component
public class Discussion {
    private int id;
    private String title;
    private String content;
    private String username;
    private String alias;
    private String createTime;

    public Discussion(int id, String title, String content, String username, String alias, String createTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.username = username;
        this.alias = alias;
        this.createTime = createTime;
    }

    public Discussion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
