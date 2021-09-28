package com.example.zymainsystem.config;

import com.example.zymainsystem.enumeration.HttpStatusCode;
import com.google.gson.Gson;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * TODO 登录成功处理
 *
 * @Author : WuXian
 * @Time : 2021/7/25 10:56
 */
public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = httpServletResponse.getWriter();
        HttpStatusCode.REDIRECT.setMsg("登录成功");
        HttpStatusCode.REDIRECT.setUrl("/index");
        String responseJson = HttpStatusCode.REDIRECT.toString();
        printWriter.print(responseJson);
        printWriter.flush();
        printWriter.close();
    }
}
