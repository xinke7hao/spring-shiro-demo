package com.tuliu.demo.springshiro.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sys_user_role")
@Data
public class SysUserRole implements Serializable {
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
     * 用户id
     */
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    
}