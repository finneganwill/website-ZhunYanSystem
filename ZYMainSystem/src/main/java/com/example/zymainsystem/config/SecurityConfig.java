package com.example.zymainsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * TODO 访问控制
 *
 * @Author : WuXian
 * @Time : 2021/7/6 10:06
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private LoginAuthenticationHandler loginAuthenticationHandler;

    @Autowired
    private PersistentTokenRepository tokenRepository;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //用户登录信息验证
        auth.userDetailsService(loginAuthenticationHandler).passwordEncoder(loginAuthenticationHandler);
    }

    //角色授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //权限控制
        http.authorizeRequests() //开启请求的权限控制
                .antMatchers("/static/**").permitAll()//静态元素放行
                .antMatchers("/index", "/login", "/register").permitAll()//公共页面放行
                .antMatchers("/page/test").hasAuthority("normal");

        //关闭csrf
        http.csrf().disable();

        //登录
        http.formLogin() // 设置权限控制下的登录页面
                .loginPage("/login") //需要权限时，通过控制器跳转到指定的自定义登录页面
                .loginProcessingUrl("/loginProcessing")//登录验证路径，登录表单的路径要与此一致
                .successHandler(new LoginAuthenticationSuccessHandler())
                .failureHandler(new LoginAuthenticationFailureHandler());//登陆失败后跳转（重定向）

        //记住我
        http.rememberMe()
                .rememberMeParameter("remember")
                .userDetailsService(loginAuthenticationHandler)//自定义登录逻辑
                .tokenRepository(tokenRepository);//指定Token存储位置


        //退出
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");

        http.headers().frameOptions().disable();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository tokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);//设置数据源
//        jdbcTokenRepository.setCreateTableOnStartup(false);//第一次启动时要创建表，之后要注释掉
        return jdbcTokenRepository;
    }


}
