package com.example.zymainsystem.config;

import com.example.zymainsystem.enumeration.HttpStatusCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * TODO 登陆失败处理
 *
 * @Author : WuXian
 * @Time : 2021/7/24 22:42
 */
public class LoginAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = httpServletResponse.getWriter();
        HttpStatusCode.BAD.setMsg("用户名或密码错误");
        String responseJson = HttpStatusCode.BAD.toString();
        printWriter.print(responseJson);
        printWriter.flush();
        printWriter.close();
    }
}
