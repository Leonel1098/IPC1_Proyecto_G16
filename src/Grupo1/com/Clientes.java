package Grupo1.com;
import java.io.Serializable;

public class Clientes implements Serializable {
    private int id;
    private String name;
    private String address;
    private String phone;
    private String nit;

    public Clientes(int id, String name, String address, String phone, String nit) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.nit = nit;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}


