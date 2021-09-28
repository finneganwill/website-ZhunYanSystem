package com.example.zymainsystem.mapper;

import com.example.zymainsystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO UserMapper接口
 *
 * @Author : WuXian
 * @Time : 2021/7/10 15:47
 */
@Mapper
@Repository
public interface UserMapper {
    void insert(User user);

    void delete(User user);

    void updateInfo(User user);

    void updateImg(String img, String username);

    void updatePsw(String username, String password);

    List<User> queryAll();

    User queryOneByUsername(String username);
}
