package com.company;

import java.io.Serializable;

public class users implements Serializable  {
    private String username, password;
    private int phone;

    public users(String username, String password,int phone) {
        this.username = username;
        this.password = password;
        this.phone = phone ;
    }

    public String getusername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}