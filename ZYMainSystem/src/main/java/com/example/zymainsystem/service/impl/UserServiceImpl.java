package com.example.zymainsystem.service.impl;

import com.example.zymainsystem.mapper.UserMapper;
import com.example.zymainsystem.pojo.User;
import com.example.zymainsystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @Author : WuXian
 * @Time : 2021/7/10 15:49
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean insertOne(User user) {
        try {
            userMapper.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateUserInfo(User user) {
        try {
            userMapper.updateInfo(user);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateUserImg(User user) {
        try{
            userMapper.updateImg(user.getImg(),user.getUsername());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUserPsw(User user) {
        try{
            userMapper.updatePsw(user.getUsername(),user.getPassword());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> queryAllUsers() {
        return userMapper.queryAll();
    }

    @Override
    public List<User> queryMoreUsers() {
        return null;
    }

    @Override
    public User queryOneUser(String username) {
        return userMapper.queryOneByUsername(username);
    }



}
