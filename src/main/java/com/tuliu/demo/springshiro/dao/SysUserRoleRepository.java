package com.tuliu.demo.springshiro.dao;

import com.tuliu.demo.springshiro.model.SysRole;
import com.tuliu.demo.springshiro.model.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserRoleRepository extends JpaRepository<SysUserRole, Void>, JpaSpecificationExecutor<SysUserRole> {

    @Query(
            value = "select r from SysRole r where r.id in (select roleId from SysUserRole where userId = ?1)"
    )
    List<SysRole> findByUserId(Integer userId);
}