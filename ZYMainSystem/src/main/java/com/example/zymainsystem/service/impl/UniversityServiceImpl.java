package com.example.zymainsystem.service.impl;

import com.example.zymainsystem.mapper.UniversityMapper;
import com.example.zymainsystem.pojo.University;
import com.example.zymainsystem.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO University服务层实现类
 *
 * @Author : WuXian
 * @Time : 2021/7/28 10:49
 */
@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityMapper universityMapper;

    @Override
    public List<University> queryAllUniversities() {
        List<University> universities = new ArrayList<>();
        try {
            universities = universityMapper.queryAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return universities;
    }

    @Override
    public University queryUniversityByName(String name) {
        University university = null;
        try {
            university = universityMapper.queryOneByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return university;
    }

    @Override
    public University queryUniversityByCode(String code) {
        University university = null;
        try {
            university = universityMapper.queryOneByCode(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return university;
    }
}
