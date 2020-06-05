package com.tuliu.demo.springshiro.model.dsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.tuliu.demo.springshiro.model.SysRole;


/**
 * QSysRole is a Querydsl query type for SysRole
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSysRole extends EntityPathBase<SysRole> {

    private static final long serialVersionUID = -1768143123L;

    public static final QSysRole sysRole = new QSysRole("sysRole");

    public final StringPath description = createString("description");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QSysRole(String variable) {
        super(SysRole.class, forVariable(variable));
    }

    public QSysRole(Path<? extends SysRole> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSysRole(PathMetadata metadata) {
        super(SysRole.class, metadata);
    }

}

