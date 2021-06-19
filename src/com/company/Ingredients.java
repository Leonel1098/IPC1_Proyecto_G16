package com.company;

import java.io.Serializable;

public class Ingredients implements Serializable {
    private String name,units;
    private int  quantity;
    //patito

    public Ingredients(String name, int quantity, String units) {
        this.name = name;
        this.quantity = quantity;
        this.units = units;

    }

    public String getName() {
        return name;
    }

    public int getQuantity () {
        return quantity;
    }

    public String getUnits()
    {
        return units;
    }

}
