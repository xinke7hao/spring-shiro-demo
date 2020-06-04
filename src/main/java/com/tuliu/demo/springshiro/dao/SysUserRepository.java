package com.tuliu.demo.springshiro.dao;

import com.tuliu.demo.springshiro.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysUserRepository extends JpaRepository<SysUser, Integer>, JpaSpecificationExecutor<SysUser> {

    SysUser findByUsername(String username);
}