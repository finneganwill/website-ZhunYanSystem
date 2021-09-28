package com.example.zymainsystem.service;

import com.example.zymainsystem.pojo.Issue;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IssueService {
    boolean insertIssue(Issue issue);

    List<Issue> queryAllIssues();

    boolean likeIssue(int id, int likeNum);

    boolean cltIssue(int id, int cltNum,String username);
}
