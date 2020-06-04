package com.tuliu.demo.springshiro.dao;

import com.tuliu.demo.springshiro.model.SysPermission;
import com.tuliu.demo.springshiro.model.SysRolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface SysRolePermissionRepository extends JpaRepository<SysRolePermission, Void>, JpaSpecificationExecutor<SysRolePermission> {

    @Query(
            "select p from SysPermission p where p.id in (select permissionId from SysRolePermission where roleId in ?1)"
    )
    List<SysPermission> findByRoleIds(Set<Integer> roleIds);
}