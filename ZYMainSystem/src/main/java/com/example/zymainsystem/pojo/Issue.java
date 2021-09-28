package com.example.zymainsystem.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Issue implements Serializable{

    private int id;

    private String title;

    private String content;

    private String username;

    private String createTime;

    private String tag;

    private String subject;

    private String category;

    private String major;

    private int likeNum;

    private int cmtNum;

    private int cltNum;

    private static final long serialVersionUID = 1L;


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

    public String getCreateTime() {
        return createTime;
    }


    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    public String getTag() {
        return tag;
    }


    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSubject() {
        return subject;
    }


    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }


    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }


    public int getLikeNum() {
        return likeNum;
    }


    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }


    public int getCmtNum() {
        return cmtNum;
    }


    public void setCmtNum(int cmtNum) {
        this.cmtNum = cmtNum;
    }


    public int getCltNum() {
        return cltNum;
    }


    public void setCltNum(int cltNum) {
        this.cltNum = cltNum;
    }


}