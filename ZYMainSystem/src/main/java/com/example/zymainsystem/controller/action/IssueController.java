package com.example.zymainsystem.controller.action;

import com.example.zymainsystem.pojo.Issue;
import com.example.zymainsystem.service.IssueService;
import com.google.gson.Gson;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @Author : WuXian
 * @Time : 2021/8/31 16:18
 */
@Controller
public class IssueController {

    @Autowired
    private IssueService issueService;

    @PostMapping("/issue/create")
    @ResponseBody
    public boolean createIssue(String json) {
        Issue issue = new Gson().fromJson(json, Issue.class);
        String createTime = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        issue.setCreateTime(createTime);
        issue.setLikeNum(0);
        issue.setCmtNum(0);
        issue.setCltNum(0);
        return issueService.insertIssue(issue);
    }

    @GetMapping("/issue/get")
    @ResponseBody
    public List<Issue> getIssues() {
        return issueService.queryAllIssues();
    }

    @PostMapping("/issue/like")
    @ResponseBody
    public boolean likeIssue(Integer id, Integer likeNum) {
        return issueService.likeIssue(id, likeNum);
    }

    @PostMapping("/issue/collect")
    @ResponseBody
    public boolean collectIssue(Integer id, Integer cltNum, String username) {
        return issueService.cltIssue(id, cltNum, username);
    }

}
