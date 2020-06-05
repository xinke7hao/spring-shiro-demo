package com.tuliu.demo.springshiro.controller;

import com.tuliu.demo.springshiro.dao.SysUserRepository;
import com.tuliu.demo.springshiro.model.SysUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xuyanbo
 * @date 2020/6/4
 */
@RestController
public class SysController {

    private final SysUserRepository sysUserRepository;

    public SysController(SysUserRepository sysUserRepository) {
        this.sysUserRepository = sysUserRepository;
    }

    @GetMapping("/sys/users")
    public List<SysUser> getAllUsers() {
        List<SysUser> users = sysUserRepository.findAll();
        return users;
    }


}
