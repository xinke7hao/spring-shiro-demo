package com.tuliu.demo.springshiro.dao;

import com.tuliu.demo.springshiro.model.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleRepository extends JpaRepository<SysRole, Integer>, JpaSpecificationExecutor<SysRole> {

}