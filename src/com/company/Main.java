package com.company;


import com.google.gson.*;


import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//
public class Main implements Serializable {
    public static Gson gson = new Gson();
    public static Scanner u = new Scanner(System.in);
    public static config configuracion;
    public static ArrayList<users> Users = new ArrayList<>();
    public static ArrayList<products> Products = new ArrayList<>();
    public static ArrayList<Invoices> Invoices = new ArrayList<>();
    public static ArrayList<Clients> Clients = new ArrayList<>();
    public static String dir;
    //path lugar donde estan las cargas JSON


    public static void main(String[] args) {

        Users();
        loguin();

    }

    //Login de los Usuariosn
    public static String usuario ;
    public static void loguin() {
        System.out.println("Ingrese el nombre de Usuario");
        usuario = u.nextLine();
        System.out.println("Ingrese la contraseña");
        String contraseña = u.nextLine();
        boolean verificar = false;
        for (int i = 0; i < Users.size(); i++) {

            if (usuario.equals(Users.get(i).getusername()) && contraseña.equals(Users.get(i).getPassword())) {

                verificar = true;
            }
        }

        if (verificar) {
            System.out.println("Hola " + usuario + " :)");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

            String HoraFecha=dtf.format(LocalDateTime.now());
            logAcciones+=HoraFecha+" \t"+usuario +" :"+ "Ingreso Exitoso "+"\n";
            logAcciones();
            Menu();

        } else {
            System.out.println("Los datos ingresados no son correctos");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

            String HoraFecha=dtf.format(LocalDateTime.now());
            logAcciones+=HoraFecha+" \t" +usuario +" : "+"Ingreso Fallido"+"\n";
            logAcciones();
            loguin();
        }
    }

    public static void Menu() {
        boolean flag = true;
        do {
            //Opciones del Menu
            System.out.println("---Menu----");
            System.out.println("Información del Restaurante");
            System.out.println("1.Usuarios ");
            System.out.println("2.Productos");
            System.out.println("3.Clientes ");
            System.out.println("4.Facturas");
            System.out.println("5.Guardar Cambios");
            System.out.println("6.Salir");
            String Op = u.nextLine();
            switch (Op) {
                case "1":
                    SubmenuUsuarios();
                    break;
                case "2":
                    SubmenuProductos();
                    break;
                case "3":
                    SubmenuClientes();
                    break;
                case "4":
                    SubmenuFacturas();
                    break;
                case "5":
                    SubmenuGuardarCambios();
                    break;
                case "6":
                    System.out.println("-----Vuelve pronto-----");
                    flag = false;
                    break;
                default:
                    System.out.println("ERROR: OPCION INVALIDA ");
                    System.out.println();
                    break;
            }
        } while (flag);
    }

    public static void SubmenuUsuarios() {
        boolean flag = true;
        do {
            //Opciones del Menu
            System.out.println("------Usuarios------");
            System.out.println("1.Listar Usuarios ");
            System.out.println("2.Eliminar Usuario");
            System.out.println("3.Ver Usuario ");
            System.out.println("4.Regresar al Menú Principal");
            String Op = u.nextLine();
            switch (Op) {
                case "1":
                    System.out.println("-----Listar Usuarios-----");
                    MostrarUsuarios();
                    System.out.println("-------------------------");
                    break;
                case "2":
                    System.out.println("------Eliminar Usuario------");
                    System.out.println("t----------------------");
                    System.out.println("Ingrese Username del Usuario");
                    String name = u.nextLine();
                    EliminarUsuario(name);
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

                    String HoraFecha=dtf.format(LocalDateTime.now());
                    logAcciones+=HoraFecha+" \t"+usuario +" :"+ "Elimnio a : "+name+"\n";
                    logAcciones();

                    System.out.println("t----------------------");
                    break;
                case "3":
                    System.out.println("-----Ver Usuario----- ");
                    System.out.println("t----------------------");
                    System.out.println("Ingrese Username del Usuario");
                    String nombre = u.nextLine();
                    VerUsuario(nombre);
                    System.out.println("t----------------------");
                    break;
                case "4":
                    System.out.println("-----Regresar al Menú Principal-----");
                    Menu();
                    break;
                default:
                    System.out.println("ERROR: OPCION INVALIDA ");
                    System.out.println();
                    break;
            }
        } while (flag);
    }

    public static void SubmenuProductos() {
        boolean flag = true;
        do {
            //Opciones del Menu
            System.out.println("------Productos------");
            System.out.println("1.Listar Productos ");
            System.out.println("2.Eliminar Producto");
            System.out.println("3.Ver Producto ");
            System.out.println("4.Regresar al Menú Principal");
            String Op = u.nextLine();
            switch (Op) {
                case "1":
                    System.out.println("-----Listar Productos-----");
                    MostrarProductos();
                    System.out.println("-------------------------");
                    break;
                case "2":
                    System.out.println("------Eliminar Producto------");
                    System.out.println("t----------------------");
                    System.out.println("Ingrese el ID del Producto");
                    String id = u.nextLine();
                    EliminarProducto(id);

                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

                    String HoraFecha=dtf.format(LocalDateTime.now());
                    logAcciones+=HoraFecha+" \t"+usuario +" :"+ "Elimnio a : "+id+"\n";
                    logAcciones();

                    System.out.println("t----------------------");
                    break;
                case "3":
                    System.out.println("-----Ver Producto----- ");
                    System.out.println("t----------------------");
                    System.out.println("Ingrese ID del Producto");
                    String Id = u.nextLine();
                    VerProducto(Id);
                    System.out.printf("t----------------------");
                    break;
                case "4":
                    System.out.println("-----Regresar al Menú Principal-----");
                    Menu();
                    break;
                default:
                    System.out.println("ERROR: OPCION INVALIDA ");
                    System.out.println();
                    break;
            }
        } while (flag);
    }

    public static void SubmenuClientes() {
        boolean flag = true;
        do {
            //Opciones del Menu
            System.out.println("------Clientes------");
            System.out.println("1.Listar Clientes ");
            System.out.println("2.Eliminar Cliente");
            System.out.println("3.Ver Cliente ");
            System.out.println("4.Regresar al Menú Principal");
            String Op = u.nextLine();
            switch (Op) {
                case "1":
                    System.out.println("-----Listar Clientes-----");
                    MostrarClientes();
                    System.out.println("-------------------------");
                    break;
                case "2":
                    System.out.println("------Eliminar Cliente------");
                    System.out.printf("t----------------------");
                    System.out.println("Ingrese el ID del Cliente");
                    String id = u.nextLine();
                    EliminarCliente(id);

                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

                    String HoraFecha=dtf.format(LocalDateTime.now());
                    logAcciones+=HoraFecha+" \t"+usuario +" :"+ "Elimnio a : "+id+"\n";
                    logAcciones();
                    System.out.println("t----------------------");
                    break;
                case "3":
                    System.out.println("-----Ver Cliente----- ");
                    System.out.println("t----------------------");
                    System.out.println("Ingrese ID del Cliente");
                    String Id = u.nextLine();
                    VerCliente(Id);
                    System.out.printf("t----------------------");
                    break;
                case "4":
                    System.out.println("-----Regresar al Menú Principal-----");
                    Menu();
                    break;
                default:
                    System.out.println("ERROR: OPCION INVALIDA ");
                    System.out.println();
                    break;
            }
        } while (flag);
    }

    public static void SubmenuFacturas() {
        boolean flag = true;
        do {
            //Opciones del Menu
            System.out.println("------Facturas------");
            System.out.println("1.Listar Facturas ");
            System.out.println("2.Eliminar Factura");
            System.out.println("3.Ver Factura ");
            System.out.println("4.Regresar al Menú Principal");
            String Op = u.nextLine();
            switch (Op) {
                case "1":
                    System.out.println("-----Listar Factura-----");
                    MostrarFacturas();
                    System.out.println("-------------------------");
                    break;
                case "2":
                    System.out.println("------Eliminar Factura------");
                    System.out.println("t----------------------");
                    System.out.println("Ingrese el ID de las Facturas");
                    String id = u.nextLine();
                    EliminarFacturas(id);
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

                    String HoraFecha=dtf.format(LocalDateTime.now());
                    logAcciones+=HoraFecha+" \t"+usuario +" :"+ "Elimnio a : "+id+"\n";
                    logAcciones();
                    System.out.println("t----------------------");
                    break;
                case "3":
                    System.out.println("-----Ver Factura----- ");
                    System.out.println("t----------------------");
                    System.out.println("Ingrese ID del Cliente");
                    String Id = u.nextLine();
                    VerFacturas(Id);
                    System.out.printf("t----------------------");
                    break;
                case "4":
                    System.out.println("-----Regresar al Menú Principal-----");
                    Menu();
                    break;
                default:
                    System.out.println("ERROR: OPCION INVALIDA ");
                    System.out.println();
                    break;
            }
        } while (flag);
    }

    public static void SubmenuGuardarCambios() {
        boolean flag = true;
        do {
            //Opciones del Menu
            System.out.println("------Serializar------");
            System.out.println("1.Json ");
            System.out.println("2.Binario");
            System.out.println("3.Regresar al Menú Principal");
            String Op = u.nextLine();
            switch (Op) {
                case "1":
                    System.out.println("-----Json-----");
                    representacionBonita = "";
                    System.out.println("Serealizando....");
                    SerializacionJson("users.json", Users);
                    System.out.println("Serealizado....");

                    System.out.println("Serealizando....");
                    SerializacionJson("products.json", Products);
                    System.out.println("Serealizado....");

                    System.out.println("Serealizando....");
                    SerializacionJson("clients.json", Clients);
                    System.out.println("Serealizado....");

                    System.out.println("Serealizando....");
                    SerializacionJson("invoices.json", Invoices);
                    System.out.println("Serealizado....");
                    break;
                case "2":
                    System.out.println("------Bin------");
                    System.out.println("Serealizando....");
                    SerializeBin("users.ipcrm", Users);
                    System.out.println("Serealizado....");

                    System.out.println("Serealizando....");
                    SerializeBin("products.ipcrm",Products);
                    System.out.println("Serealizado....");

                    System.out.println("Serealizando....");
                    SerializeBin("clients.ipcrm", Clients);
                    System.out.println("Serealizado....");

                    System.out.println("Serealizando....");
                    SerializeBin("invoices.ipcrm", Invoices);
                    System.out.println("Serealizado....");
                    break;
                case "3":
                    System.out.println("-----Regresar al Menú Principal-----");
                    Menu();
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
            ReadBinUsers();
            ReadBinProducts();
            ReadBinInvoices();
            ReadBinClients();

        }
        else
        {
            System.out.println("Deserealización desde json");
            Users();
            productos();
            Invoices();
            Clients();
            RevisionUsers();
            RevisionProducts();
            RevisionInvoices();
            RevisionClients();


        }

    }
    //INGRESOPORJAVA
    public static void productos() {
        try {

            dir = "C:\\Users\\Alberto\\Desktop\\borar\\products.json";


            Products.addAll(Arrays.asList(gson.fromJson(getContentOfFile(dir),products[].class)));
            RevisionProducts();
            ShowProducts();
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
    public static void Users() {
        try {

            dir = "C:\\Users\\Alberto\\Desktop\\borar\\users.json";

            Users.addAll(Arrays.asList(gson.fromJson(getContentOfFile(dir),users[].class)));
            RevisionUsers();
            ShowUsers();


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
    public static void Invoices() {
        try {

            dir = "C:\\Users\\Alberto\\Desktop\\borar\\invoices.json";

            Invoices.addAll(Arrays.asList(gson.fromJson(getContentOfFile(dir),Invoices[].class)));
            RevisionInvoices();
            ShowInvoices();

        }
        catch (Exception e)
        {
            File j = new File(dir);

            if (j.exists()) {
                System.out.println("El archivo json tiene errores");
                System.out.println("Ingrese un archivo sin errores");
                Invoices();
            }
            else   {
                System.out.println("El archivo no existe");
                System.out.println("Ingrese una dirección correcta");
                Invoices();
            }

        }
    }
    public static void  Clients(){
        try {

            dir = "C:\\Users\\Alberto\\Desktop\\borar\\clients.json";
            Clients.addAll(Arrays.asList(gson.fromJson(getContentOfFile(dir),Clients[].class)));
            RevisionClients();
            ShowClients();

        }
        catch (Exception e)
        {
            File j = new File(dir);

            if (j.exists()) {
                System.out.println("El archivo json tiene errores");
                System.out.println("Ingrese un archivo sin errores");
                Clients();
            }
            else   {
                System.out.println("El archivo no existe");
                System.out.println("Ingrese una dirección correcta");
                Clients();
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
    //MUESTRA
    public static void ShowProducts()
    {
        for (products p: Products) {

            System.out.println("   Numero de ID:    " + p.getId() + "    Nombre: " + p.getname() + "    Descripcion:   " + p.getDescription() + "   Costo:     " + p.getCost() + "   Precio:    " + p.getPrice() + "\nIngredientes:  " );
            for(int i =0; i<p.ingredients.length;i++) {
                System.out.println("Nombre:  " + p.getIngredients(i).getName() + "\nCantidad:  " + p.getIngredients(i).getQuantity() + "\nUnidades:   " + p.getIngredients(i).getUnits()+"\n");

            }  System.out.println();
            System.out.println();
            System.out.println();

        }
    }
    public static void ShowUsers()
    {
        for (users p:Users)
            System.out.println("\nNombre de Usuario: "+p.getusername()+"\nContraseña:  "+p.getPassword());
    }
    public static void ShowInvoices()
    {
        for (Invoices p:Invoices) {
            System.out.println(p.getClient() + p.getId() + p.getDate());
            for (int i = 0; i<p.products.length;i++)System.out.println(p.getProducts(i).getPrice() + p.getProducts(i).getName());
        }

    }
    public static void ShowClients(){
        for (Clients p: Clients)
            System.out.println(p.getAddress()+p.getName()+p.getId()+p.getNit()+p.getPhone());
    }
    //INGRESOPORBIN
    public static void ReadBinProducts()
    {
        try
        {
            Products.addAll((ArrayList<products>)deserializeArrayList("products.ipcmr"));
            RevisionProducts();
            ShowProducts();

        }
        catch (Exception e)
        {
            System.out.println("El archivo no existe");
        }
    }
    public static void ReadBinUsers()
    {
        try
        {
            Users.addAll((ArrayList<users>)deserializeArrayList("users.ipcmr"));
            RevisionUsers();
            ShowUsers();

        }
        catch (Exception e)
        {
            System.out.println("El archivo no existe");
        }
    }
    public static void ReadBinInvoices()
    {
        try
        {
            Invoices.addAll((ArrayList<Invoices>)deserializeArrayList("invoices.ipcmr"));
            RevisionInvoices();
            ShowInvoices();

        }
        catch (Exception e)
        {
            System.out.println("El archivo no existe");
        }
    }
    public static void ReadBinClients()
    {
        try
        {
            Clients.addAll((ArrayList<Clients>)deserializeArrayList("clients.ipcmr"));
            RevisionClients();
            ShowClients();


        }
        catch (Exception e)
        {
            System.out.println("El archivo no existe");
        }
    }
    //REVISIONES
    public static void  RevisionUsers(){

        int cont=0;
        for (int i = 0;i<Users.size();i++)
        {
            for(int j=0;j<Users.size();j++)
            {
                if(Users.get(i).getusername().equals(Users.get(j).getusername())) {
                    cont++;
                    if (cont > 1) {
                        System.out.println("Se repitió el nombre de usuario:  " + Users.get(i).getusername());
                        Users.remove(j);
                    }
                }
            }
            cont=0;
        }



    }
    public static void RevisionProducts(){
        int cont=0;
        for (int i = 0;i<Products.size();i++)
        {
            for(int j=0;j<Products.size();j++)
            {
                if(Products.get(i).getId().equals(Products.get(j).getId())) {
                    cont++;
                    if (cont > 1) {
                        System.out.println("Se repitió el nombre de usuario:  " + Products.get(i).getId());
                        Products.remove(j);
                    }
                }
            }
            cont=0;
        }

    }
    public static void RevisionInvoices(){
        int cont=0;
        for (int i = 0;i<Invoices.size();i++)
        {
            for(int j=0;j<Invoices.size();j++)
            {
                if(Invoices.get(i).getId()==(Invoices.get(j).getId())) {
                    cont++;
                    if (cont > 1) {
                        System.out.println("Se repitió el nombre de ID:  " + Invoices.get(i).getId());
                        Invoices.remove(j);
                    }
                }
            }
            cont=0;
        }

    }
    public static void RevisionClients(){
        int cont=0;
        for (int i = 0;i<Clients.size();i++)
        {
            for(int j=0;j<Clients.size();j++)
            {
                if(Clients.get(i).getId()==(Clients.get(j).getId())) {
                    cont++;
                    if (cont > 1) {
                        System.out.println("Se repitió el ID:  " + Clients.get(i).getId());
                        Clients.remove(j);
                    }
                }
            }
            cont=0;
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

    //----------------------------Mostrar Datos-----------------------------------
    public static void MostrarUsuarios() {
        for (int i = 0; i < Users.size(); i++) {

            System.out.println("UserName : " + Users.get(i).getusername() + "|| Password : " + Users.get(i).getPassword());
        }
    }
    public static void MostrarProductos (){
        for (int i = 0; i < Products.size(); i++){
            System.out.println("  Numero de ID:  " + Products.get(i).getId() + "  || Nombre: " + Products.get(i).getname() + "  || Descripcion:  " + Products.get(i).getDescription() +
                    "  || Costo:  " + Products.get(i).getCost() + "  || Precio:    " + Products.get(i).getPrice() );
            System.out.println("  Ingredientes:  " );
            System.out.println("  Nombre: " + Products.get(i).getIngredients(i).getName() + "  || Cantidad:  " + Products.get(i).getIngredients(i).getQuantity() +
                    "  ||Unidades:  " + Products.get(i).getIngredients(i).getUnits() );
        }
    }
    public static void MostrarClientes(){
        for (int i = 0; i < Clients.size(); i++) {
            System.out.println("Número de ID: " + Clients.get(i).getId() + "  || Name: " + Clients.get(i).getName() + "|| Dirección: " + Clients.get(i).getAddress()
                    + "  || Telefóno:  " + Clients.get(i).getPhone() + "  || NIT: " + Clients.get(i).getNit());
        }
    }
    public static void MostrarFacturas(){
        for (int i = 0; i < Invoices.size(); i++){
            System.out.println("  Numero de ID:  " + Invoices.get(i).getId() + "  || CLiente: " + Invoices.get(i).getClient() + "  || Fecha: " + Invoices.get(i).getDate());
            System.out.println("  Productos:  " );
            System.out.println("  Nombre: " + Invoices.get(i).getProducts(i).getName() + "  || Precio:  " + Invoices.get(i).getProducts(i).getPrice());
        }
    }
    //----------------------------Eliminar Datos----------------------------------
    public static void EliminarUsuario(String name) {

        for (int i = 0; i < Users.size(); i++) {
            if (name.equals(Users.get(i).getusername())) {
                System.out.println("Se Elimino a:" + Users.get(i).getusername());
                Users.remove(i);
            }
            if (name.equals(null)) {
                System.out.printf("No se encontro el usuario ");
            }

        }
    }
    public static void EliminarProducto(String id) {
        for (int i = 0; i < Products.size(); i++) {
            if (id.equals(Products.get(i).getId())) {
                System.out.println("Se eliminó el Producto: " + Products.get(i).getId());
                Products.remove(i);
            }
            if (id.equals(null)) {
                System.out.printf("No se encontro el producto ");
            }
        }
    }
    public static void EliminarCliente(String id){
        for (int i = 0; i < Clients.size(); i++) {
            if (id.equals(Clients.get(i).getId())) {
                System.out.println("Se eliminó al cliente con ID: " + Clients.get(i).getId());
                Clients.remove(i);
            }
            if (id.equals(null)) {
                System.out.printf("No se encontro el cliente ");
            }

        }
    }
    public static void EliminarFacturas (String id){
        for (int i = 0; i < Invoices.size(); i++) {
            if (id.equals(Invoices.get(i).getId())) {
                System.out.println("Se eliminó la factura con ID: " + Invoices.get(i).getId());
                Invoices.remove(i);
            }
            if (id.equals(null)) {
                System.out.printf("No se encontró la factura ");
            }

        }

    }
    //----------------------------Ver Datos Específicos---------------------------
    public static void VerUsuario(String nombre) {

        for (int i = 0; i < Users.size(); i++) {
            if (nombre.equals(Users.get(i).getusername())) {
                System.out.println("UserName : " + Users.get(i).getusername() + "|| Password : " + Users.get(i).getPassword());
            }
            if (nombre.equals(null)) {
                System.out.printf("No se Encontro el Usuario ");
            }

        }
    }
    public static void VerProducto(String Id){
        for (int i = 0; i < Products.size(); i++) {
            if (Id.equals(Products.get(i).getId())) {
                System.out.println("El Producto es:  ");
                System.out.println("  Numero de ID:  " + Products.get(i).getId() + "  || Nombre: " + Products.get(i).getname() + "  || Descripcion:  " + Products.get(i).getDescription() +
                        "  || Costo:  " + Products.get(i).getCost() + "  || Precio:    " + Products.get(i).getPrice() );
                System.out.println("  Ingredientes:  " );
                System.out.println("  Nombre: " + Products.get(i).getIngredients(i).getName() + "  || Cantidad:  " + Products.get(i).getIngredients(i).getQuantity() +
                        "  ||Unidades:  " + Products.get(i).getIngredients(i).getUnits() );
            }
            if (Id.equals(null)) {
                System.out.printf("No se Encontro el producto");
            }
        }
    }
    public static void VerCliente(String Id){
        for (int i = 0; i <Clients.size(); i++) {
            if (Id.equals(Clients.get(i).getId())) {
                System.out.println("El Cliente es:  ");
                System.out.println("Número de ID: " + Clients.get(i).getId() + "  || Name: " + Clients.get(i).getName() + "|| Dirección: " + Clients.get(i).getAddress()
                        + "  || Telefóno:  " + Clients.get(i).getPhone() + "  || NIT: " + Clients.get(i).getNit());
            }
            if (Id.equals(null)) {
                System.out.printf("No se Encontro el Cliente");
            }
        }
    }
    public static void VerFacturas(String Id){
        for (int i = 0; i <Invoices.size(); i++) {
            if (Id.equals(Invoices.get(i).getId())) {
                System.out.println("  Numero de ID:  " + Invoices.get(i).getId() + "  || CLiente: " + Invoices.get(i).getClient() + "  || Fecha: " + Invoices.get(i).getDate());
                System.out.println("  Productos:  " );
                System.out.println("  Nombre: " + Invoices.get(i).getProducts(i).getName() + "  || Precio:  " + Invoices.get(i).getProducts(i).getPrice());
            }
            if (Id.equals(null)) {
                System.out.printf("No se Encontro la Factura");
            }
        }
    }
    //<----------------------------------------------------------------------Serializacion
    public static String representacionBonita = "";


    public static void SerializacionJson(String pathname, Object object) {

        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        representacionBonita += prettyGson.toJson(object);
        String Datos[] = representacionBonita.split("\n");
        System.out.println(representacionBonita);

        try {
            FileWriter archivo = new FileWriter(pathname);

            archivo.write(representacionBonita + "\n");


            archivo.close();

        } catch (Exception e) {

        }


    }

    public static Object deserialize(String pathname) {
        // Leer un objeto serializado
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathname));
            Object data = objectInputStream.readObject();
            objectInputStream.close();
            return data;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public  static ObjectOutputStream oos;
    public static void SerializeBin(String pathname, Object object) {

        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        final String representacionBonita = prettyGson.toJson(object);
        System.out.println(representacionBonita);

        try {
            // Creamos un archivo, entre comillas va la ruta donde queremos almacenar el archivo
            // SE RECOMIENDA UTILIZAR RUTAS RELATIVAS PARA ESTE CASO.
            oos = new ObjectOutputStream(new FileOutputStream(pathname));
            // Utilizamos el metodo writeObject, para convertir el objeto serializable en parte del archivo
            oos.writeObject(object);
            // Cerramos el archivo para que se efectuen los cambios
            oos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static Object deserializeArrayList(String pathname) {
        // Leer un objeto serializado
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathname));
            Object data = objectInputStream.readObject();
            objectInputStream.close();
            return data;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String logAcciones ="";
    public static void logAcciones(){

        try {
            FileWriter archivo = new FileWriter("log.log");

            archivo.write(logAcciones + "\n");


            archivo.close();

        } catch (Exception e) {

        }
    }
}