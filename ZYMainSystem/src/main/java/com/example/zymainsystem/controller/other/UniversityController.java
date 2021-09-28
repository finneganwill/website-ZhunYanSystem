package com.example.zymainsystem.controller.other;

import com.example.zymainsystem.pojo.University;
import com.example.zymainsystem.service.UniversityService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * TODO 业务层
 *
 * @Author : WuXian
 * @Time : 2021/7/28 10:53
 */
@Controller
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @GetMapping("/uni/all")
    @ResponseBody
    public String getAll() {
        List<University> universities = universityService.queryAllUniversities();
        return new Gson().toJson(universities);
    }
}
