package com.example.zymainsystem.mapper;

import com.example.zymainsystem.pojo.Issue;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IssueMapper {
    List<Issue> queryAll();

    Issue selectOne(int id);

    void insert(Issue issue);

    void delete(int id);

    void update(Issue issue);

    void likeIssue(int id, int likeNum);

    void cltIssue(int id, int cltNum);
}
