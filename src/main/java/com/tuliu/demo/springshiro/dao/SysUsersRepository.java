package com.tuliu.demo.springshiro.dao;

import com.tuliu.demo.springshiro.model.SysUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysUsersRepository extends JpaRepository<SysUsers, String>, JpaSpecificationExecutor<SysUsers> {

}