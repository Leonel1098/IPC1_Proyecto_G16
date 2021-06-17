package com.company;

import java.io.Serializable;

public class users  {
    private String username, password;
    private int phone;

    public users(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public String getusername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}