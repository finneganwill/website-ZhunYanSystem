package com.example.zymainsystem.mapper;

import com.example.zymainsystem.pojo.University;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO UniversityMapper接口
 *
 * @Author : WuXian
 * @Time : 2021/7/28 10:05
 */
@Mapper
@Repository
public interface UniversityMapper {
    List<University> queryAll();

    University queryOneByName(String name);

    University queryOneByCode(String code);
}
