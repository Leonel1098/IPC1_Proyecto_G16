package com.company;

import java.io.Serializable;

;

    public class products implements Serializable {
        private String id;
        private String name;
        private String description;
        private int cost;
        private int price;
        private ingredients[] ingredients;
        public  products(String id , String name ,String description,int cost,int price ,ingredients [] ingredients){



        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
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

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public ingredients[] getIngredients() {
            return ingredients;
        }

        public void setIngredients(ingredients[] ingredients) {
            this.ingredients[] = ingredients[];
        }
    }

