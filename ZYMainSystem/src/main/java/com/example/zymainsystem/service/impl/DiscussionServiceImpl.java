package com.example.zymainsystem.service.impl;

import com.example.zymainsystem.mapper.DiscussionMapper;
import com.example.zymainsystem.pojo.Discussion;
import com.example.zymainsystem.service.DiscussionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @Author : WuXian
 * @Time : 2021/9/20 20:39
 */
@Service
public class DiscussionServiceImpl implements DiscussionService {
    @Autowired
    private DiscussionMapper discussionMapper;

    @Override
    public List<Discussion> queryAllDiscussion() {
        return discussionMapper.queryAll();
    }


    @Override
    public boolean insertOneDiscussion(Discussion discussion) {
        boolean flag = true;
        try {
            discussionMapper.insertOne(discussion);
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }
}
