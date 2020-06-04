package com.tuliu.demo.springshiro.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "sys_role_permission")
@Data
@Entity
public class SysRolePermission implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    /**
     * 角色id
     */
    @Column(name = "role_id", nullable = false)
    private Integer roleId;

    /**
     * 权限id
     */
    @Column(name = "permission_id", nullable = false)
    private Integer permissionId;

    
}