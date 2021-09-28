package com.example.zymainsystem.service;

import com.example.zymainsystem.pojo.Official;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @Author : WuXian
 * @Time : 2021/7/28 22:09
 */
public interface OfficialService {
    Official queryOfficialByCode(String code);

    boolean insertOfficial(Official official);
}
