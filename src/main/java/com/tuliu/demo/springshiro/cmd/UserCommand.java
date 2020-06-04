package com.tuliu.demo.springshiro.cmd;

import lombok.Data;

/**
 * @author xuyanbo
 * @date 2020/6/4
 */
@Data
public class UserCommand {

    private String username;
    private String password;
    private boolean remember;

}
