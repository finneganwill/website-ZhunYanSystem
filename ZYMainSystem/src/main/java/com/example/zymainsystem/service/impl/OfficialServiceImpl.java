package com.example.zymainsystem.service.impl;

import com.example.zymainsystem.mapper.OfficialMapper;
import com.example.zymainsystem.pojo.Official;
import com.example.zymainsystem.service.OfficialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @Author : WuXian
 * @Time : 2021/7/28 22:10
 */
@Service
public class OfficialServiceImpl implements OfficialService {
    @Autowired
    private OfficialMapper officialMapper;

    @Override
    public Official queryOfficialByCode(String code) {
        Official official = null;
        try {
            official = officialMapper.queryOneByCode(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return official;
    }

    @Override
    public boolean insertOfficial(Official official) {
        try {
            officialMapper.insert(official);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
