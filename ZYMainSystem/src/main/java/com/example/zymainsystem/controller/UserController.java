package com.example.zymainsystem.controller;

import com.example.zymainsystem.enumeration.HttpStatusCode;
import com.example.zymainsystem.enumeration.Permission;
import com.example.zymainsystem.pojo.User;
import com.example.zymainsystem.service.UserService;
import com.example.zymainsystem.utils.RandomAliasUtil;
import com.google.gson.Gson;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @Author : WuXian
 * @Time : 2021/7/10 15:49
 */
@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /********** 用户注册 **********/

    @PostMapping("/user/register")
    @ResponseBody
    public String userRegister(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setPermission(Permission.NORMAL.getKey());
        user.setOnline(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        user.setAlias(RandomAliasUtil.getRandomAlias());
        boolean b = userService.insertOne(user);
        if (b) {
            return HttpStatusCode.OK.toString();
        } else {
            return HttpStatusCode.BAD.toString();
        }
    }

    @PostMapping("/user/register/check")
    @ResponseBody
    public String userRegisterCheck(String username) {
        User user = userService.queryOneUser(username);
        if (user != null) {
            return HttpStatusCode.BAD.toString();
        } else {
            return HttpStatusCode.OK.toString();
        }
    }


    /********** 左侧导航跳转 **********/

    /* info */
    @RequestMapping("/user/my")
    public String userMy() {
        return "user/my";
    }

    @RequestMapping("/user/info/info/{username}")
    public String userInfoInfo(@PathVariable("username") String username, Model model) {
        Map<String, String> map = new HashMap<>();
        if (username.length() == 10) {
            return "user/info/info-psw";
        } else {
            User user = userService.queryOneUser(username);
            map.put("username", user.getUsername());
            map.put("alias", user.getAlias());
            map.put("img", user.getImg());
            map.put("sex", String.valueOf(user.getSex()));
            map.put("birthday", user.getBirthday());
            map.put("phone", user.getPhone());
            map.put("email", user.getEmail());
            map.put("almamater", user.getAlmamater());
            map.put("goalmater", user.getGoalmater());
            map.put("info", user.getInfo());
            model.addAllAttributes(map);
            return "user/info/info-info";
        }
    }

    @RequestMapping("/user/info/psw")
    public String userInfoPsw() {
        return "/user/info/info-psw";
    }

    @RequestMapping("/user/info/destroy")
    public String userInfoDestroy() {
        return "user/info/info-destroy";
    }

    /* action */

    @RequestMapping("/user/action/new")
    public String userActionCreate() {
        return "user/action/action-new";
    }

    @RequestMapping("/user/action/discuss")
    public String userActionDiscuss() {
        return "user/action/action-discuss";
    }

    @RequestMapping("/user/action/collect")
    public String userActionCollect() {
        return "user/action/action-enshrine";
    }

    @RequestMapping("/user/action/comment")
    public String userActionComment() {
        return "user/action/action-comment";
    }


    /********** 个人信息更新 **********/

    @PostMapping("/user/update/info")
    @ResponseBody
    public String userUpdateInfo(String json) {
        User user = new Gson().fromJson(json, User.class);
        boolean b = userService.updateUserInfo(user);
        if (b) {
            HttpStatusCode.OK.setMsg("保存成功");
            return HttpStatusCode.OK.toString();
        } else {
            HttpStatusCode.BAD.setMsg("更新失败");
            return HttpStatusCode.BAD.toString();
        }
    }

    @RequestMapping("/user/update/img")
    @ResponseBody
    public String userUpdateImg(String username, MultipartFile file) {
        if (file.isEmpty()) {
            return HttpStatusCode.BAD.toString();
        } else {
            String fileName = file.getOriginalFilename();
            String filePath = System.getProperty("user.dir") + "/ZYMainSystem/src/main/resources/static/upload/imgs/";
            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                User user = new User();
                user.setImg("/upload/imgs/" + fileName);
                user.setUsername(username);
                boolean b = userService.updateUserImg(user);
                String response;
                if (b) {
                    HttpStatusCode.OK.setUrl(fileName);
                    response = HttpStatusCode.OK.toString();
                } else {
                    HttpStatusCode.BAD.setMsg("上传失败");
                    response = HttpStatusCode.BAD.toString();
                }
                return response;
            } catch (IOException e) {
                return HttpStatusCode.BAD.toString();
            }
        }
    }


    @PostMapping("/user/update/password")
    @ResponseBody
    public String userUpdatePassword(String username, String oldPassword, String newPassword) {
        User user = userService.queryOneUser(username);
        String response;
        if (passwordEncoder.matches(oldPassword, user.getPassword())) {
            user.setPassword(passwordEncoder.encode(newPassword));
            boolean b = userService.updateUserPsw(user);
            if (b) {
                HttpStatusCode.OK.setMsg("修改成功");
                response = HttpStatusCode.OK.toString();
            } else {
                HttpStatusCode.BAD.setMsg("修改失败");
                response = HttpStatusCode.BAD.toString();
            }
        } else {
            HttpStatusCode.BAD.setMsg("旧密码不正确");
            response = HttpStatusCode.BAD.toString();
        }
        return response;
    }

}
