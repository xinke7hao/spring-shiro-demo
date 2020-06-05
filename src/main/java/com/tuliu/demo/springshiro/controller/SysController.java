package com.tuliu.demo.springshiro.controller;

import com.tuliu.demo.springshiro.dao.SysUserRepository;
import com.tuliu.demo.springshiro.dto.UserRolePermission;
import com.tuliu.demo.springshiro.model.SysUser;
import com.tuliu.demo.springshiro.service.QueryDslService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xuyanbo
 * @date 2020/6/4
 */
@RestController
public class SysController {

    private final SysUserRepository sysUserRepository;
    private final QueryDslService queryDslService;

    public SysController(SysUserRepository sysUserRepository, QueryDslService queryDslService) {
        this.sysUserRepository = sysUserRepository;
        this.queryDslService = queryDslService;
    }

    @GetMapping("/sys/users")
    public List<SysUser> getAllUsers() {
        List<SysUser> users = sysUserRepository.findAll();
        return users;
    }

    @GetMapping("/sys/user-role-permissions")
    public List<UserRolePermission> getUserRolePermissions(
           @RequestParam("uid") Integer uid,
           @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
           @RequestParam(value = "size", required = false, defaultValue = "2") Integer size) {
        List<UserRolePermission> data = queryDslService.findAllUserRolePermission(uid, PageRequest.of(page, size));
        return data;
    }

    @GetMapping("/sys/dynamic-query")
    public List<UserRolePermission> getUserRolePermissions(
            @RequestParam("uid") Integer uid,
            @RequestParam(value = "username", required = false, defaultValue = "") String username) {
        List<UserRolePermission> data = queryDslService.findUserRolePermission(uid, username);
        return data;
    }

}
