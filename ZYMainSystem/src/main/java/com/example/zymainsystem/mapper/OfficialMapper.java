package com.example.zymainsystem.mapper;

import com.example.zymainsystem.pojo.Official;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO
 *
 * @Author : WuXian
 * @Time : 2021/7/28 22:09
 */
@Mapper
@Repository
public interface OfficialMapper {
    Official queryOneByCode(String code);

    void insert(Official official);
}
