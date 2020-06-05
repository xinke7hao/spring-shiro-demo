package com.tuliu.demo.springshiro.dao;

import com.tuliu.demo.springshiro.model.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SysPermissionRepository extends JpaRepository<SysPermission, Integer>, JpaSpecificationExecutor<SysPermission> {

}