package Grupo1.com;
import java.io.Serializable;

public class ProductoF implements Serializable {
    private String name;
    private double price;

    public ProductoF(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

