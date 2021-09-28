package com.example.zymainsystem.service;

import com.example.zymainsystem.pojo.Issue;

import java.util.List;

/**
 * TODO
 *
 * @Author : WuXian
 * @Time : 2021/9/25 9:28
 */
public interface EnshrineService {
    List<Issue> queryMoreEnshrines(String owner);
}
