package com.demo.controller;

import com.demo.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    @ResponseBody
    public String subLogin(User user, String rememberMe, HttpServletResponse response) throws IOException {
        ObjectMapper om = new ObjectMapper();
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            if(rememberMe!=null&&rememberMe.equals("on")){
               token.setRememberMe(true);
            }
            subject.login(token);
            response.sendRedirect("http://localhost:8080/success.jsp");
        } catch (UnknownAccountException e) {
            return "账号错误！";
        } catch (IncorrectCredentialsException e) {
            return "密码错误！";
        } catch (DisabledAccountException e) {
            return "该用户已被禁用！";
        } catch (AuthenticationException e) {
            return "登录失败，错误为：" + e.getMessage();
        }
        return null;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String testRole() throws JsonProcessingException {
        /* 使用shiro实现登出 0 */
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        /* 使用shiro实现登出 1 */
        ObjectMapper om = new ObjectMapper();
        return "退出成功！";
    }
}
