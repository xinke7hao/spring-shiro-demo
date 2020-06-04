package com.tuliu.demo.springshiro.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Table(name = "sys_users")
@Entity
@Data
public class SysUsers implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", insertable = false, nullable = false)
    private String id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private String createdBy;

    /**
     * 登录名
     */
    @Column(name = "login_id", nullable = false)
    private String loginId = "";

    /**
     * 登录密码
     */
    @Column(name = "password", nullable = false)
    private String password = "";

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

    /**
     * 用户昵称
     */
    @Column(name = "username", nullable = false)
    private String username = "";

    /**
     * 是否可用
     */
    @Column(name = "valid", nullable = false)
    private Integer valid = 1;

    /**
     * 用户角色
     */
    @Column(name = "role", nullable = false)
    private String role = "0";

    /**
     * 用户头像
     */
    @Column(name = "avatar", nullable = false)
    private String avatar = "";

    
}