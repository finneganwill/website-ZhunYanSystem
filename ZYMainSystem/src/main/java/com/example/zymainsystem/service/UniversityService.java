package com.example.zymainsystem.service;

import com.example.zymainsystem.pojo.University;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO University服务层
 *
 * @Author : WuXian
 * @Time : 2021/7/28 10:46
 */
public interface UniversityService {
    List<University> queryAllUniversities();

    University queryUniversityByName(String name);

    University queryUniversityByCode(String code);
}
