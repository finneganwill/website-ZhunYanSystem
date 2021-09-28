package com.example.zymainsystem.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * TODO
 *
 * @Author : WuXian
 * @Time : 2021/7/31 16:06
 */
public class GetUserDetailsUtil {

    public static org.springframework.security.core.userdetails.User getUserDetails() {
        return (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
