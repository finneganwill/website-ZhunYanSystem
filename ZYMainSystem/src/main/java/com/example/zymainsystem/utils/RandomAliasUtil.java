package com.example.zymainsystem.utils;

import org.apache.commons.lang3.RandomUtils;

/**
 * TODO
 *
 * @Author : WuXian
 * @Time : 2021/7/10 17:27
 */
public class RandomAliasUtil {

    public static String getRandomAlias(){
        String time = String.valueOf(System.currentTimeMillis());//1589944697520
        return "Lucky_" + time;
    }
}
