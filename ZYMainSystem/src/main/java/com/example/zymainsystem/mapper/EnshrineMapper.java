package com.example.zymainsystem.mapper;

import com.example.zymainsystem.pojo.Enshrine;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO
 *
 * @Author : WuXian
 * @Time : 2021/9/25 9:21
 */
@Mapper
@Repository
public interface EnshrineMapper {
    List<Enshrine> queryMore(String owner);

    void addOne(Enshrine enshrine);

    List<Enshrine> queryOne(int issueId, String owner);
}
