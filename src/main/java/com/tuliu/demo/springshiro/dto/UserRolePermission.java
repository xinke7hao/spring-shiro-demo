package com.tuliu.demo.springshiro.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author xuyanbo
 * @date 2020/6/5
 */
@Data
@Builder
public class UserRolePermission {

    private String username;
    private String rolename;
    private String permission;

}
