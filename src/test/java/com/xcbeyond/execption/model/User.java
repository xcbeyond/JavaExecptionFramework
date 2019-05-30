package com.xcbeyond.execption.model;

import java.io.Serializable;

/**
 * @Auther: xcbeyond
 * @Date: 2019/5/28 16:59
 */
public class User implements Serializable {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
