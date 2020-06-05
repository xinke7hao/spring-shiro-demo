package com.tuliu.demo.springshiro.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author xuyanbo
 * @date 2020/6/4
 */
@Slf4j
@ControllerAdvice
public class GlobalAdvice {

    @ExceptionHandler(AuthorizationException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String authorizationHandler() {
        return "403 | Not Authoriezed";
    }

    @ExceptionHandler({
            IncorrectCredentialsException.class,
            UnknownAccountException.class,
            MissingServletRequestParameterException.class
    })
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String shiroHandler(Exception e) {
        return e.getMessage();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String unrecognizedHandler(Exception e) {
        log.error("unexpected exception:", e);
        return "500 | Unexpected Exception";
    }

}
