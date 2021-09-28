package com.example.zymainsystem.pojo;

import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @Author : WuXian
 * @Time : 2021/9/25 9:17
 */
@Component
public class Enshrine {
    private int id;
    private int issueId;
    private String owner;

    public Enshrine(int id, int issueId, String owner) {
        this.id = id;
        this.issueId = issueId;
        this.owner = owner;
    }

    public Enshrine() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
