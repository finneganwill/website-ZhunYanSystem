package com.example.zymainsystem.service;

import com.example.zymainsystem.pojo.Discussion;

import java.util.List;

/**
 * TODO
 *
 * @Author : WuXian
 * @Time : 2021/9/20 20:38
 */

public interface DiscussionService {

    List<Discussion> queryAllDiscussion();

    boolean insertOneDiscussion(Discussion discussion);

}
