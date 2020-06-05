package com.tuliu.demo.springshiro.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tuliu.demo.springshiro.dto.UserRolePermission;
import com.tuliu.demo.springshiro.model.dsl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xuyanbo
 * @date 2020/6/5
 */
@Service
public class QueryDslService {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    /**
     * 分页查询全关联数据
     * @param pageable
     * @return
     */
    public List<UserRolePermission> findAllUserRolePermission(Integer uid, Pageable pageable) {
        QSysUser user = QSysUser.sysUser;
        QSysRole role = QSysRole.sysRole;
        QSysUserRole userRole = QSysUserRole.sysUserRole;
        QSysPermission permission = QSysPermission.sysPermission;
        QSysRolePermission rolePermission = QSysRolePermission.sysRolePermission;
        List<UserRolePermission> result = jpaQueryFactory.select(
                user.username, role.name, permission.name
        ).from(user, userRole, role, rolePermission, permission)
        .where(
                user.id.eq(uid)
                .and(user.id.eq(userRole.userId))
                .and(role.id.eq(userRole.roleId))
                .and(role.id.eq(rolePermission.roleId))
                .and(rolePermission.permissionId.eq(permission.id))
        ).orderBy(permission.id.asc())
        .offset(pageable.getOffset())
        .limit(pageable.getPageSize())
        .fetch()
        .stream()
        .map(row ->
            UserRolePermission.builder()
                    .username(row.get(user.username))
                    .rolename(row.get(role.name))
                    .permission(row.get(permission.name))
                    .build()
        ).collect(Collectors.toList());
        return result;
    }

}
