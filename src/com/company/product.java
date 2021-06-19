package com.company;

import java.io.Serializable;

public class product implements Serializable {
    private String name;
    private int price;

    public product(String name, int price) {
    this.name=name;
    this.price=price;

    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}