package com.tuliu.demo.springshiro.service;

import com.tuliu.demo.springshiro.dao.*;
import com.tuliu.demo.springshiro.model.SysPermission;
import com.tuliu.demo.springshiro.model.SysRole;
import com.tuliu.demo.springshiro.model.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author xuyanbo
 * @date 2020/6/4
 */
@Slf4j
@Service
public class ShiroAuthService extends AuthorizingRealm {

    @Autowired
    private SysUserRepository sysUserRepository;
    @Autowired
    private SysUserRoleRepository sysUserRoleRepository;
    @Autowired
    private SysRolePermissionRepository sysRolePermissionRepository;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            throw new AuthorizationException("principals should not be null");
        }
        SysUser userInfo = (SysUser) SecurityUtils.getSubject().getPrincipal();
        log.info("用户-->{}获取权限中", userInfo.getUsername());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        //用户获取角色集
        List<SysRole> roleList = sysUserRoleRepository.findByUserId(userInfo.getId());
        Set<Integer> roleIds = new HashSet<>();
        for (SysRole r : roleList) {
            roleIds.add(r.getId());
            simpleAuthorizationInfo.addRole(r.getName());
        }
        List<SysPermission> permissionList = sysRolePermissionRepository.findByRoleIds(roleIds);
        Optional.ofNullable(permissionList).ifPresent(ps -> ps.stream()
                .forEach(per -> simpleAuthorizationInfo.addStringPermission(per.getName())));

        log.info("角色为-> {}", simpleAuthorizationInfo.getRoles());
        log.info("权限为-> {}", simpleAuthorizationInfo.getStringPermissions());
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        log.info("用户输入--->{}:{}", username, password);
        SysUser userInfo = sysUserRepository.findByUsername(username);
        if (userInfo == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!password.equals(userInfo.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, userInfo.getPassword(), getName()
        );
        return authenticationInfo;
    }
}
