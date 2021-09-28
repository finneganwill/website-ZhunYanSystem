package com.example.zymainsystem.controller.action;

import com.example.zymainsystem.enumeration.ApiData;
import com.example.zymainsystem.enumeration.HttpStatusCode;
import com.example.zymainsystem.pojo.Issue;
import com.example.zymainsystem.service.EnshrineService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * TODO
 *
 * @Author : WuXian
 * @Time : 2021/9/25 9:21
 */
@Controller
public class EnshrineController {
    @Autowired
    private EnshrineService enshrineService;

    @GetMapping("/get/enshrine/{owner}")
    @ResponseBody
    public String getMyEnshrine(@PathVariable String owner) {
        List<Issue> issues = enshrineService.queryMoreEnshrines(owner);
        ApiData apiData = new ApiData(0, "", issues.size(), issues);
        return apiData.toString();
    }

}
