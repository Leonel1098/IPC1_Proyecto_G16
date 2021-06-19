package com.company;

import java.io.Serializable;

public class Clients implements Serializable {
    private static final long serialVersionUID = 4L;
    private String name, address,nit;
    private int id,phone;

    public Clients(int id, String name, String address, int phone,String nit) {
        this.id=id;
        this.name= name;
        this.address=address;
        this.phone = phone;
        this.nit = nit;


    }

   public int getId()
   {
       return id;
   }
   public String getName(){
        return name;
   }
   public  String getAddress()
   {
       return address;
   }
   public int getPhone(){
        return phone;
   }
   public String getNit(){
        return nit;
   }
}