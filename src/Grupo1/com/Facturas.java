package Grupo1.com;
import java.io.Serializable;

    import java.io.Serializable;
    import java.util.ArrayList;

    public class Facturas implements Serializable  {
    private int id;
    private int client;
    private String date;
    ArrayList<ProductoF>products;

    public Facturas(int id, int client, String date, ArrayList<ProductoF>products) {
        this.id = id;
        this.client = client;
        this.date = date;
        this.products = products;
    }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getClient() {
            return client;
        }

        public void setClient(int client) {
            this.client = client;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public ArrayList<ProductoF> getProducts() {
            return products;
        }

        public void setProducts(ArrayList<ProductoF> products) {
            this.products = products;
        }
    }
