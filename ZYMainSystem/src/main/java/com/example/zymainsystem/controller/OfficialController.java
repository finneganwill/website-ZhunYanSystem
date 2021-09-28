package com.example.zymainsystem.controller;

import com.example.zymainsystem.enumeration.HttpStatusCode;
import com.example.zymainsystem.pojo.Official;
import com.example.zymainsystem.pojo.University;
import com.example.zymainsystem.service.OfficialService;
import com.example.zymainsystem.service.UniversityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO
 *
 * @Author : WuXian
 * @Time : 2021/7/28 22:08
 */
@Controller
public class OfficialController {

    @Autowired
    private OfficialService officialService;

    @Autowired
    private UniversityService universityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/official/register")
    @ResponseBody
    public String officialRegister(String code, String password) {
        University university = universityService.queryUniversityByCode(code);
        Official official = new Official();
        official.setCode(code);
        official.setName(university.getName());
        official.setPassword(passwordEncoder.encode(password));
        official.setLicense(university.getLicense());
        boolean b = officialService.insertOfficial(official);
        if (b) {
            HttpStatusCode.OK.setMsg("注册成功，请登录");
            return HttpStatusCode.OK.toString();
        } else {
            HttpStatusCode.BAD.setMsg("注册失败");
            return HttpStatusCode.BAD.toString();
        }
    }

    @PostMapping("/official/register/check")
    @ResponseBody
    public String officialRegisterCheck(String code, String license) {

        Official official = officialService.queryOfficialByCode(code);
        University university = universityService.queryUniversityByCode(code);
        String response = "";
        if (official == null) {
            if (university.getLicense().equals(license)) {
                HttpStatusCode.OK.setMsg("注册成功");
                response = HttpStatusCode.OK.toString();
            } else {
                HttpStatusCode.BAD.setMsg("授权码不正确");
                response = HttpStatusCode.BAD.toString();
            }
        } else {
            HttpStatusCode.BAD.setMsg("用户已注册");
            response = HttpStatusCode.BAD.toString();
        }
        return response;
    }
}
