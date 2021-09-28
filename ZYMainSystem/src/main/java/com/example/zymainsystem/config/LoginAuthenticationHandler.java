package com.example.zymainsystem.config;

import com.example.zymainsystem.pojo.Official;
import com.example.zymainsystem.pojo.User;
import com.example.zymainsystem.service.OfficialService;
import com.example.zymainsystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * TODO 用户登录校验
 *
 * @Author : WuXian
 * @Time : 2021/7/25 10:06
 */
@Component
public class LoginAuthenticationHandler implements UserDetailsService, PasswordEncoder {

    @Autowired
    private UserService userService;

    @Autowired
    private OfficialService officialService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final Logger logger = LoggerFactory.getLogger(LoginAuthenticationHandler.class);

    /*
     * TODO
     * @params String s --> 用户名
     * @return UserDetails --> UserDetails对象
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info(String.valueOf(username.length()));
        if (username.length() == 10) {
            Official official = officialService.queryOfficialByCode(username);
            // 用户名校验
            if (official == null) {
                throw new UsernameNotFoundException("用户未注册");
            }
            return new org.springframework.security.core.userdetails.User(username, official.getPassword(),
                    AuthorityUtils.commaSeparatedStringToAuthorityList("normal"));
        }else {
            User user = userService.queryOneUser(username);
            // 用户名校验
            if (user == null) {
                throw new UsernameNotFoundException("用户未注册");
            }
            return new org.springframework.security.core.userdetails.User(username, user.getPassword(),
                    AuthorityUtils.commaSeparatedStringToAuthorityList("normal"));
        }
    }

    @Override
    public String encode(CharSequence charSequence) {
        return null;
    }

    @Override
    public boolean matches(CharSequence charSequence, String password) {
        // 密码校验
        logger.info("客户端输入：" + charSequence.toString());
        logger.info("数据库查询：" + password);
        //charSequence明文 password密文
        return passwordEncoder.matches(charSequence, password);
    }
}
