package com.company;

import java.io.Serializable;

public class products implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id,name,description;
    private int cost,price;
    public   Ingredients[] ingredients;


    public products(String id, String name,String description,int cost, int price, Ingredients[] ingredients)
    {
        this.id = id;
        this.name=name;
        this.description=description;
        this.cost=cost;
        this.price=price;
        this.ingredients=ingredients;
    }
    public String getId(){return id;}
    public String getname()
    {
        return name;
    }
    public String getDescription()
    {
        return description;
    }
    public int getCost(){return cost;};
    public int getPrice(){return price;}
    public Ingredients getIngredients(int i){
        return ingredients[i];

    }
}
