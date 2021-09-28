package com.example.zymainsystem.controller;

import com.example.zymainsystem.pojo.University;
import com.example.zymainsystem.pojo.User;
import com.example.zymainsystem.service.UniversityService;
import com.example.zymainsystem.service.UserService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO
 *
 * @Author : WuXian
 * @Time : 2021/7/6 10:01
 */
@Controller
public class IndexController {
    @Autowired
    private UserService userService;

    @Autowired
    private UniversityService universityService;

    //访问首页
    @RequestMapping("/index")
    public String accessIndex(Model model) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            org.springframework.security.core.userdetails.User userDetails = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
            Logger logger = LoggerFactory.getLogger(IndexController.class);
            logger.info(new Gson().toJson(userDetails));
            if(userDetails.getUsername().length() == 10){
                University university = universityService.queryUniversityByCode(userDetails.getUsername());
                model.addAttribute("username",university.getCode());
                model.addAttribute("alias",university.getName());
            }else {
                User user = userService.queryOneUser(userDetails.getUsername());
                model.addAttribute("username",user.getUsername());
                model.addAttribute("alias", user.getAlias());
            }
        }else {
            model.addAttribute("username","");
            model.addAttribute("alias","欢迎登录");
        }
        return "/index";
    }


    //登录
    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    //注册
    @RequestMapping("/register")
    public String register() {
        return "/register";
    }


    @RequestMapping("/sys/login/success/{userAccount}")
    @ResponseBody
    public String loginSuccess(@PathVariable("userAccount") String userAccount) {
        System.out.println(userAccount);
        return "登录成功" + userAccount;
    }


    @RequestMapping("/sys/register/check/{userAccount}")
    @ResponseBody
    public boolean registerCheck(@PathVariable String userAccount) {
        User user = userService.queryOneUser(userAccount);
        return user != null;
    }


    /****
     * page
     *****/

    @RequestMapping("/page/news")
    public String news() {
        return "/page/news";
    }

    @RequestMapping("/page/discuss")
    public String discussion() {
        return "/page/discuss";
    }

    @RequestMapping("/page/home")
    public String home(){
        return "page/home";
    }


}
