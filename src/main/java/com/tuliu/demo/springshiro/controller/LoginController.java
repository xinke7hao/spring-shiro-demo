package com.tuliu.demo.springshiro.controller;

import com.tuliu.demo.springshiro.cmd.UserCommand;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyanbo
 * @date 2020/6/4
 */
@Slf4j
@RestController
public class LoginController {

    @GetMapping("/tologin")
    public String toLogin() {
        return "login page";
    }

    @GetMapping("login")
    public String login(UserCommand user) {
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        token.setRememberMe(user.isRemember());
        subject.login(token);
        log.info("login success:{}", user.getUsername());
        return "login success";
    }

    @GetMapping("logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        log.info("log out:{}", subject.getPrincipal());
        subject.logout();
        return "logout success";
    }

}
