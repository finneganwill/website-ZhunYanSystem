package com.example.zymainsystem.service;

import com.example.zymainsystem.pojo.User;

import java.util.List;

/**
 * TODO
 *
 * @Author : WuXian
 * @Time : 2021/7/10 15:48
 */
public interface UserService {
    boolean insertOne(User user);

    boolean updateUserInfo(User user);

    boolean updateUserImg(User user);

    boolean updateUserPsw(User user);

    List<User> queryAllUsers();

    List<User> queryMoreUsers();

    User queryOneUser(String userAccount);
}
