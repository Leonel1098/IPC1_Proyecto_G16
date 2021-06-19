package com.company;

import java.io.Serializable;

public class Invoices implements Serializable {
    private static final long serialVersionUID = 3L;
    private String date;
    private int id,client;
    public   product[] products;

    public Invoices(int id, int client, String date, product[] products) {
        this.id=id;
        this.client=client;
        this.date = date;
        this.products=products;

    }

    public int getId() {
        return id;
    }

    public int getClient() {
        return client;
    }
    public  String getDate(){
        return date;
    }
    public product getProducts(int i)
    {
        return products[i];
    }
}