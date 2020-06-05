package com.tuliu.demo.springshiro.model.dsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.tuliu.demo.springshiro.model.SysRolePermission;


/**
 * QSysRolePermission is a Querydsl query type for SysRolePermission
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSysRolePermission extends EntityPathBase<SysRolePermission> {

    private static final long serialVersionUID = -1137843044L;

    public static final QSysRolePermission sysRolePermission = new QSysRolePermission("sysRolePermission");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> permissionId = createNumber("permissionId", Integer.class);

    public final NumberPath<Integer> roleId = createNumber("roleId", Integer.class);

    public QSysRolePermission(String variable) {
        super(SysRolePermission.class, forVariable(variable));
    }

    public QSysRolePermission(Path<? extends SysRolePermission> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSysRolePermission(PathMetadata metadata) {
        super(SysRolePermission.class, metadata);
    }

}

