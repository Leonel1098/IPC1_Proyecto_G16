package Grupo1.com;

import java.util.ArrayList;
import java.io.Serializable;

public class Productos implements Serializable{
    private int id;
    private String name;
    private String description;
    private double cost;
    private double price;
    ArrayList<Ingredientes>ingredients;
    public Productos(){

    }
    public Productos(int id, String name, String description, double cost, double price, ArrayList<Ingredientes>ingredients) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.price = price;
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<Ingredientes> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredientes> ingredients) {
        this.ingredients = ingredients;
    }
    public String  Ingredietes(){
        String Ingredientes="";
        for (int i =0 ; i< ingredients.size();i++){
            Ingredientes+=ingredients.get(i).getName()+",";

        }
        return Ingredientes;
    }

}
