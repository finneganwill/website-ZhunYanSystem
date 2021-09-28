package com.example.zymainsystem.mapper;

import com.example.zymainsystem.pojo.Discussion;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO
 *
 * @Author : WuXian
 * @Time : 2021/9/20 20:32
 */
@Mapper
@Repository
public interface DiscussionMapper {
    List<Discussion> queryAll();

    void insertOne(Discussion discussion);
}
