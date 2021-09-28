package com.example.zymainsystem.service.impl;

import com.example.zymainsystem.mapper.EnshrineMapper;
import com.example.zymainsystem.mapper.IssueMapper;
import com.example.zymainsystem.pojo.Enshrine;
import com.example.zymainsystem.pojo.Issue;
import com.example.zymainsystem.service.IssueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {
    private static final Logger logger = LoggerFactory.getLogger(IssueServiceImpl.class);

    @Autowired
    private IssueMapper issueMapper;

    @Autowired
    private EnshrineMapper enshrineMapper;

    @Override
    public boolean insertIssue(Issue issue) {
        boolean flag = true;
        try {
            issueMapper.insert(issue);
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Issue> queryAllIssues() {
        List<Issue> issues = new ArrayList<>();
        try {
            issues = issueMapper.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return issues;
    }

    @Override
    public boolean likeIssue(int id, int likeNum) {
        boolean flag = true;
        try {
            issueMapper.likeIssue(id, likeNum);
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean cltIssue(int id, int cltNum, String username) {
        List<Enshrine> enshrines = enshrineMapper.queryOne(id, username);
        if (enshrines.size() != 0) {
            return false;
        }
        try {
            Enshrine newEnshrine = new Enshrine();
            newEnshrine.setIssueId(id);
            newEnshrine.setOwner(username);
            enshrineMapper.addOne(newEnshrine);
            issueMapper.cltIssue(id, cltNum);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
