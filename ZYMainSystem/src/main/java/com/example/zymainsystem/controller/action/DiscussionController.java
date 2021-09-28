package com.example.zymainsystem.controller.action;

import com.example.zymainsystem.pojo.Discussion;
import com.example.zymainsystem.pojo.User;
import com.example.zymainsystem.service.DiscussionService;
import com.example.zymainsystem.service.UserService;
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
 * @Time : 2021/9/20 20:15
 */
@Controller
public class DiscussionController {
    @Autowired
    private DiscussionService discussionService;

    @Autowired
    private UserService userService;

    @GetMapping("/discussion/get/all")
    @ResponseBody
    public List<Discussion> getAll() {
        return discussionService.queryAllDiscussion();
    }

    @PostMapping("/discussion/create")
    @ResponseBody
    public boolean createOne(String json) {
        Discussion discussion = new Gson().fromJson(json, Discussion.class);
        String createTime = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        discussion.setCreateTime(createTime);
        User user = userService.queryOneUser(discussion.getUsername());
        discussion.setAlias(user.getAlias());
        return discussionService.insertOneDiscussion(discussion);
    }
}
