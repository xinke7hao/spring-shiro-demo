package com.tuliu.demo.springshiro.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyanbo
 * @date 2020/6/4
 */
@Slf4j
@RestController
public class TestController {

    @Value("${project.appname}")
    private String appname;

    @GetMapping("/appname")
    public String appname() {
        log.info("request appname");
        return appname;
    }

    @RequiresPermissions("test:shiro")
    @GetMapping("/shiro")
    public String shiro() {
        log.info("pass shiro authorization");
        return "authorized";
    }
}
