package Grupo1.com;

import java.io.Serializable;

public class configs implements Serializable{
    private String name,address,load;
    private int phone;

    public configs(String name, String address, int phone, String load)
    {
        this.name = name;
        this.address=address;
        this.phone=phone;
        this.load=load;
    }
    public String getname()
    {
        return name;
    }
    public String getaddress()
    {
        return address;
    }
    public int getPhone(){return phone;};
    public String getLoad(){return load;}
}
