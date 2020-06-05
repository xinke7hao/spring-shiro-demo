package com.tuliu.demo.springshiro.model.dsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.tuliu.demo.springshiro.model.SysPermission;


/**
 * QSysPermission is a Querydsl query type for SysPermission
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSysPermission extends EntityPathBase<SysPermission> {

    private static final long serialVersionUID = 1004902150L;

    public static final QSysPermission sysPermission = new QSysPermission("sysPermission");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath url = createString("url");

    public QSysPermission(String variable) {
        super(SysPermission.class, forVariable(variable));
    }

    public QSysPermission(Path<? extends SysPermission> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSysPermission(PathMetadata metadata) {
        super(SysPermission.class, metadata);
    }

}

