package com.tuliu.demo.springshiro.model.dsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.tuliu.demo.springshiro.model.SysUser;


/**
 * QSysUser is a Querydsl query type for SysUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSysUser extends EntityPathBase<SysUser> {

    private static final long serialVersionUID = -1768050110L;

    public static final QSysUser sysUser = new QSysUser("sysUser");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime", java.time.LocalDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath password = createString("password");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath username = createString("username");

    public QSysUser(String variable) {
        super(SysUser.class, forVariable(variable));
    }

    public QSysUser(Path<? extends SysUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSysUser(PathMetadata metadata) {
        super(SysUser.class, metadata);
    }

}

