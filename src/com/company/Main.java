package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.*;

public class main {
    public  static Gson gson = new Gson();
    public static Scanner u = new Scanner(System.in);
    public static config configuracion;
    public static ArrayList<users> Users = new ArrayList<>();
    public static ArrayList<products> Products = new ArrayList<>();
    public static String dir;

    public static void main(String[] args) {
	// write your code here
    }
    public static void Menu() {
        boolean flag = true;
        do {
            //Opciones del Menu
            System.out.println("---Menu----");
            System.out.println("1.Inicio de Sesión ");
            System.out.println("2.Información del Restaurante");
            System.out.println("3.Usuarios ");
            System.out.println("4.Productos");
            System.out.println("5.Clientes ");
            System.out.println("6.Facturas");
            System.out.println("7.Guardar Cambios");
            System.out.println("8.Cerrar Sesion");
            System.out.println("9.Salir");
            String Op = sc.nextLine();
            switch (Op) {
                case "1":
                    System.out.println("--Inicio de Sesión");
                    System.out.printf("t----------------------");
                    System.out.println("-------------------------");
                    break;
                case "2":
                    System.out.println("--Información del Restaurante---");
                    System.out.printf("t----------------------");
                    System.out.printf("t----------------------");
                    break;
                case "3":
                    System.out.println("**Usuarios--");
                    System.out.printf("t----------------------");
                    System.out.printf("t----------------------");
                    break;
                case "4":
                    System.out.println("--Productos-- ");
                    break;
                case "5":
                    System.out.println("--Clientes--");
                    System.out.printf("t----------------------");

                    break;
                case "6":
                    System.out.println("--Facturas--");
                    System.out.printf("t----------------------");
                    System.out.printf("t----------------------");

                    break;
                case "7":
                    System.out.println("--Guardar Cambios--");
                    break;
                case "8":
                    System.out.println("--Cerrar Sesión-");
                    break;
                case "9":
                    System.out.println("Vuelve pronto");
                    flag = false;
                    break;
                default:
                    System.out.println("ERROR: OPCION INVALIDA ");
                    System.out.println();
                    break;
            }
        } while (flag);
    }
    public static void jalada() {
        try {



            System.out.println("Ingrese la dirección de la configuración");
            dir = u.nextLine();
            dir = "C:\\Users\\Alberto\\Desktop\\borar\\config.json";

            configuracion = gson.fromJson(getContentOfFile(dir), config.class);
            System.out.println("Restaurante:  " + configuracion.getname() + "  Dirección:   " + configuracion.getaddress() + "  Load:  " + configuracion.getLoad() + "  Telefono:  " + configuracion.getPhone());
        }
        catch (Exception e)
        {
            File j = new File(dir);

            if (j.exists()) {
                System.out.println("El archivo json tiene errores");
                System.out.println("Ingrese un archivo sin errores");
                jalada();
            }
            else   {
                System.out.println("El archivo no existe");
                System.out.println("Ingrese una dirección correcta");
                jalada();
            }

        }
        if(configuracion.getLoad().equalsIgnoreCase("bin"))
        {
            System.out.println("Deserealización desde bin");

        }
        else
        {
            System.out.println("Deserealización desde json");
            Users();
            productos();

        }

    }
    public static void productos()
    {
        try {
            System.out.println("Ingrese la dirección de los productos");
            dir = u.nextLine();
            dir = "C:\\Users\\Alberto\\Desktop\\borar\\products.json";


            Products.addAll(Arrays.asList(gson.fromJson(getContentOfFile(dir),products[].class)));
            System.out.println(Products.get(2).getIngredients(1).getName());


           /* for (products p: Products) {
                System.out.println("   Numero de ID:    " + p.getId() + "    Nombre: " + p.getname() + "    Descripcion:   " + p.getDescription() + "   Costo:     " + p.getCost() + "   Precio:    " + p.getPrice() + "    Ingredientes:   " + "\n"+p.getIngredients(0).getName()+p.getIngredients(0).getQuantity()+p.getIngredients(0).getUnits());

            }*/
        }
        catch (Exception e)
        {
            File j = new File(dir);

            if (j.exists()) {
                System.out.println("El archivo json tiene errores");
                System.out.println("Ingrese un archivo sin errores");
                Users();
            }
            else   {
                System.out.println("El archivo no existe");
                System.out.println("Ingrese una dirección correcta");
                Users();
            }

        }


    }
    public static void Users()
    {
        try {
            System.out.println("Ingrese la dirección de llos usuarios");
            dir = u.nextLine();
            dir = "C:\\Users\\Alberto\\Desktop\\borar\\users.json";

            Users.addAll(Arrays.asList(gson.fromJson(getContentOfFile(dir),users[].class)));
            for (users p:Users)
                System.out.println(p.getusername()+p.getPassword());

        }
        catch (Exception e)
        {
            File j = new File(dir);

            if (j.exists()) {
                System.out.println("El archivo json tiene errores");
                System.out.println("Ingrese un archivo sin errores");
                Users();
            }
            else   {
                System.out.println("El archivo no existe");
                System.out.println("Ingrese una dirección correcta");
                Users();
            }

        }

    }
    public static String getContentOfFile(String pathname) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(pathname);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String content = "";
            String linea;
            while ((linea = br.readLine()) != null) {
                content += linea + "\n";
            }
            return content;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

}
