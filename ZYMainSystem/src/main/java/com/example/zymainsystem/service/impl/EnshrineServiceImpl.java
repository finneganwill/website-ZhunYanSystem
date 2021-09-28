package com.example.zymainsystem.service.impl;

import com.example.zymainsystem.mapper.EnshrineMapper;
import com.example.zymainsystem.mapper.IssueMapper;
import com.example.zymainsystem.pojo.Enshrine;
import com.example.zymainsystem.pojo.Issue;
import com.example.zymainsystem.service.EnshrineService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @Author : WuXian
 * @Time : 2021/9/25 9:29
 */
@Service
public class EnshrineServiceImpl implements EnshrineService {
    private static final Logger logger = LoggerFactory.getLogger(EnshrineServiceImpl.class);

    @Autowired
    private EnshrineMapper enshrineMapper;

    @Autowired
    private IssueMapper issueMapper;

    @Override
    public List<Issue> queryMoreEnshrines(String owner) {
        List<Issue> issues = new ArrayList<>();
        try {
            List<Enshrine> enshrines = enshrineMapper.queryMore(owner);
            for (Enshrine enshrine : enshrines) {
                Issue issue = issueMapper.selectOne(enshrine.getIssueId());
                issues.add(issue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return issues;
    }
}
