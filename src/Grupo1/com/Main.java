package Grupo1.com;

import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.google.gson.*;
import com.jtattoo.plaf.noire.NoireLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;

import javax.swing.*;

public class Main {

    static Scanner readStr = new Scanner(System.in);
    static Scanner readNum = new Scanner(System.in);
    static ArrayList<Configuraciones>configs = new ArrayList<>();
    static ArrayList<Usuarios>users = new ArrayList<>();
    static ArrayList<Productos>products = new ArrayList<>();
    static ArrayList<Clientes>clients = new ArrayList<>();
    static ArrayList<Facturas>invoices = new ArrayList<>();
    static ArrayList<Ingredientes>temp = new ArrayList<>();
    static ArrayList<ProductoF>temp2 = new ArrayList<>();
    static int ContadorUsers = 0;
    static int ContadorClients = 0;
    static int ContadorProducts = 0;
    static int ContadorInvoices = 0;
    static Object  [][] arreglo;

    public static void main(String[] args) {

        JFrame.setDefaultLookAndFeelDecorated(true);

        try {
            // COMANDO PARA AGREGAR UN LOOK AND FEEL

            UIManager.setLookAndFeel(new NoireLookAndFeel());

        } catch (Exception e) {
            e.printStackTrace();
        }

        CargaConfig();
        Login login = new Login();

        //Error.vericador();
       //Login();
    }

        public static void Login() {
            String user, pass;
            System.out.print("Ingrese su usuario: ");
            user = readStr.nextLine();
            System.out.print("Ingrese su contraseña ");
            pass = readNum.nextLine();
            System.out.println();
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equalsIgnoreCase(user) && users.get(i).getPassword().equalsIgnoreCase(pass)) {
                    System.out.println("Bienvenido!!!");
                    System.out.println();
                    System.out.println("<------------- "+configs.get(0).getName() +" ------------->");
                    System.out.println("Dirección: "+ configs.get(0).getAddress());
                    System.out.println("Tel: "+configs.get(0).getPhone());
                    System.out.println("<------------------------------------------------>");
                    System.out.println();
                    Menu();
                    break;
                }else {
                    System.out.println("Usuario/Contraseña incorrectos");
                }
            }
        }

        public static void CargaConfig(){
        String ContenidoConfig = Archivos.getContentOfFile("./JPruebas/config.json");
        Gson gson = new Gson();
        Configuraciones configuraciones = gson.fromJson(ContenidoConfig, Configuraciones.class);
        configs.add(configuraciones);

        if (configuraciones.getLoad().equals("bin")){
            System.out.println("BIN");
            users = (ArrayList<Usuarios>) Archivos.deserialize("./Serealizables/users.ipcrm");
            products = (ArrayList<Productos>) Archivos.deserialize("./Serealizables/products.ipcrm");
            clients = (ArrayList<Clientes>) Archivos.deserialize("./Serealizables/clients.ipcrm");
            invoices = (ArrayList<Facturas>) Archivos.deserialize("./Serealizables/invoices.ipcrm");
        } else if (configuraciones.getLoad().equals("json")){
            System.out.println("JSON");
            CargaUsuarios();
            CargaProductos();
            CargaClientes();
            CargaFacturas();
        }
    }

        public static void CargaUsuarios(){
         String ContenidoUsuarios = Archivos.getContentOfFile("./JPruebas/users.json");
         Gson gson = new Gson();
         Usuarios[] usuarios = gson.fromJson(ContenidoUsuarios, Usuarios[].class);

         for (Usuarios user: usuarios){
             users.add(user);
             ContadorUsers++;
            }
        }

        public static void AgregaUsuario(String username, String password){
            Usuarios UsuriosAgregados = new Usuarios(username, password);
            users.add(UsuriosAgregados);
            logAcciones+=HoraFecha()+" Se Agrego al usuario  :"+username+"\n";

            logAcciones();
        }

        public static void EditarUsuario(String user, String username, String password){
        for (int i=0; i<users.size(); i++){
            if(users.get(i).getUsername().equals(user)){
                users.get(i).setUsername(username);
                users.get(i).setPassword(password);
                logAcciones+=HoraFecha()+"\t Se Edito el Usuario "+user+", id :"+username+"\n";
                logAcciones();
            }
        }
        }

        public static void CargaClientes(){
        String ContenidoClientes = Archivos.getContentOfFile("./JPruebas/clients.json");
        Gson gson = new Gson();
        Clientes[] clientes = gson.fromJson(ContenidoClientes, Clientes[].class);

            for (Clientes client: clientes){
                clients.add(client);
                ContadorClients++;
            }

            //Archivos.serialize("./Serealizables/clients.ipcrm", clients);
            //Object UserS = Archivos.deserialize("./Serealizables/users.ipcrm");
        }

        public static void AgregaCliente(int id, String name, String address,String nit, String phone ){
        Clientes ClientesAgregados = new Clientes(id, name, address, phone, nit);
            logAcciones+=HoraFecha()+"\t Se Agrego el Cliente "+name+", id :"+id+"\n";
            logAcciones();
        clients.add(ClientesAgregados);
        }

        public static void EditarCliente(int id, String name, String address, String phone, String nit){
        for (int i=0; i<clients.size(); i++){
            if(clients.get(i).getId() == id){
                clients.get(i).setName(name);
                clients.get(i).setAddress(address);
                clients.get(i).setPhone(phone);
                clients.get(i).setNit(nit);
                logAcciones+=HoraFecha()+"\t Se Edito el Cliente "+name+", id :"+id+"\n";
                logAcciones();
            }
        }
    }

        public static void CargaProductos(){
        String ContenidoProductos = Archivos.getContentOfFile("./JPruebas/products.json");
        Gson gson = new Gson();
        Productos[]productos = gson.fromJson(ContenidoProductos, Productos[].class);

            for (Productos product: productos){
                products.add(product);
                ContadorProducts++;
            }

            //Archivos.serialize("./Serealizables/products.ipcrm", products);
        }

         public static void AgregarIngredienteI(int Index, String name, int quantity, String units){
        Ingredientes IngredientesP = new Ingredientes(name, quantity, units);
        for (int i=0; i<products.size();i++) {
            if (products.get(i).getId() == Index) {
                logAcciones+=HoraFecha()+"\t Se Agrego el ingrediente "+name+", id :"+Index+"\n";
                logAcciones();
                products.get(i).ingredients.add(IngredientesP);
             }
            }
        }


    public static void EditarIngrediente(String index, String name, int quantity, String units, int cont){
        for (int i=0; i<Main.products.size(); i++){
            if (cont == Main.products.get(i).getId()) {
                for (int j = 0; j < Main.products.get(i).getIngredients().size(); j++) {
                    if (Main.products.get(i).getIngredients().get(j).getName().equals(index)){
                        Main.products.get(i).getIngredients().get(j).setName(name);
                        Main.products.get(i).getIngredients().get(j).setQuantity(quantity);
                        Main.products.get(i).getIngredients().get(j).setUnits(units);
                    }
                }
            }
        }
    }

        public static void AgregaProducto(int id, String name, String description, int cost, int price, ArrayList<Ingredientes>ig){
        Productos ProductosAgregados = new Productos(id,name,description,cost,price, ig);
            logAcciones+=HoraFecha()+"\t SeAgrego El Producto  "+name+", id :"+id+"\n";
            logAcciones();
        products.add(ProductosAgregados);
        }

        public static void EditarProducto(int id, String name, String description, double cost, double price){
        for (int i=0; i< products.size(); i++){
            if(products.get(i).getId() == id) {
                products.get(i).setName(name);
                products.get(i).setDescription(description);
                products.get(i).setCost(cost);
                products.get(i).setPrice(price);
                logAcciones+=HoraFecha()+"\t Se Edito el Producto  "+name+", id :"+id+"\n";
                logAcciones();
            }
        }
    }

        public static void ejemplo(){
            AgregaProducto(5, "Beto", "asdfasdfsf", 6, 7, temp);
            temp.clear();
            AgregaFactura(1, 2, "12/12/2020", temp2);
            temp2.clear();
        }

        public static void CargaFacturas(){
        String ContenidoFacturas = Archivos.getContentOfFile("./JPruebas/invoices.json");
        Gson gson = new Gson();
        Facturas[]facturas = gson.fromJson(ContenidoFacturas, Facturas[].class);

        for (Facturas invoice: facturas){
            invoices.add(invoice);
            ContadorInvoices++;
            }

            //Archivos.serialize("./Serealizables/invoices.ipcrm", invoices);
        }

        public static void AgregarProductoF(String name, int price){
        ProductoF PdF = new ProductoF(name, price);
        temp2.add(PdF);
        }

        public static void AgregaFactura(int id, int user, String date, ArrayList<ProductoF>PF){
        Facturas FacturasAgregadas = new Facturas(id, user,date,PF);
        logAcciones+=HoraFecha()+"\t  Se Agrego la Factura "+", id :"+id+"\n";
        logAcciones();
        invoices.add(FacturasAgregadas);
        }

        public static void Menu() {
        int op = 0;
        do {
            System.out.println("==================MENÚ================");
            System.out.println("||            1. Usuarios           ||");
            System.out.println("||            2. Productos          ||");
            System.out.println("||            3. Clientes           ||");
            System.out.println("||            4. Facturas           ||");
            System.out.println("||         5. Guardar Cambios       ||");
            System.out.println("||          6. Cerrar Sesion        ||");
            System.out.println("======================================");
            System.out.print("Ingrese una opcion: ");
            try {
                op = readNum.nextInt();
                switch (op) {
                    case 1:
                        CRUD_Users cu= new CRUD_Users();
                        MenuUsuarios();
                        break;
                    case 2:
                        CRUD_Productos Cp= new CRUD_Productos();
                        MenuProductos();
                        break;
                    case 3:
                        CRUD_Clientes cc = new CRUD_Clientes();
                        MenuClientes();
                        break;
                    case 4:
                        CRUD_Facturas cf = new CRUD_Facturas();
                        MenuFacturas();
                        break;
                    case 5:
                        MenuGuardar();
                        break;
                    case 6:
                        System.out.println("Hasta la Proxima!");
                        break;
                    default:
                        System.out.println("!!!Ingrese una opcion que esté contenida en el menú!!!");
                }
            } catch (Exception e) {
                readNum.nextLine();
                System.out.println("");
                System.out.println("!!!Debe elegir una opcion correcta!!!");
            }
        } while (op != 6);
    }

        public static void MenuUsuarios(){
            int op = 0;
            do {
                System.out.println("================USUARIOS==============");
                System.out.println("||        1. Listar Usuarios        ||");
                System.out.println("||       2. Eliminar Usuarios       ||");
                System.out.println("||        3. Buscar Usuario         ||");
                System.out.println("||        4. Menu Principal         ||");
                System.out.println("======================================");
                System.out.print("Ingrese una opcion: ");
                try {
                    op = readNum.nextInt();
                    switch (op) {
                        case 1:
                            MostrarUsuarios();
                            break;
                        case 2:
                            EliminarUsuario();
                            break;
                        case 3:
                            BuscarUsuario();
                            break;
                        case 4:
                            System.out.println("");
                            break;
                        default:
                            System.out.println("!!!Ingrese una opcion que esté contenida en el menú!!!");
                    }
                } catch (Exception e) {
                    readNum.nextLine();
                    System.out.println("");
                    System.out.println("!!!Debe elegir una opcion correcta!!!");
                }
            } while (op != 4);
    }

        public static void MenuProductos(){
        int op = 0;
        do {
            System.out.println("===============Productos==============");
            System.out.println("||       1. Listar Productos        ||");
            System.out.println("||      2. Eliminar Productos       ||");
            System.out.println("||       3. Buscar Productos        ||");
            System.out.println("||        4. Menu Principal         ||");
            System.out.println("======================================");
            System.out.print("Ingrese una opcion: ");
            try {
                op = readNum.nextInt();
                switch (op) {
                    case 1:
                        MostrarProductos();
                        break;
                    case 2:
                        EliminarProducto();
                        break;
                    case 3:
                        BuscarProducto();
                        break;
                    case 4:
                        System.out.println("");
                        break;
                    default:
                        System.out.println("!!!Ingrese una opcion que esté contenida en el menú!!!");
                }
            } catch (Exception e) {
                readNum.nextLine();
                System.out.println("");
                System.out.println("!!!Debe elegir una opcion correcta!!!");
            }
        } while (op != 4);
    }

        public static void MenuClientes(){
        int op = 0;
        do {
            System.out.println("================CLIENTES==============");
            System.out.println("||        1. Listar Clientes        ||");
            System.out.println("||       2. Eliminar Clientes       ||");
            System.out.println("||        3. Buscar Clientes        ||");
            System.out.println("||        4. Menu Principal         ||");
            System.out.println("======================================");
            System.out.print("Ingrese una opcion: ");
            try {
                op = readNum.nextInt();
                switch (op) {
                    case 1:
                        MostrarClientes();
                        break;
                    case 2:
                        EliminarClientes();
                        break;
                    case 3:
                        BuscarClientes();
                        break;
                    case 4:
                        System.out.println("");
                        break;
                    default:
                        System.out.println("!!!Ingrese una opcion que esté contenida en el menú!!!");
                }
            } catch (Exception e) {
                readNum.nextLine();
                System.out.println("");
                System.out.println("!!!Debe elegir una opcion correcta!!!");
            }
        } while (op != 4);
    }

        public static void MenuFacturas(){
        int op = 0;
        do {
            System.out.println("================FACTURAS==============");
            System.out.println("||        1. Listar Facturas        ||");
            System.out.println("||       2. Eliminar Facturas       ||");
            System.out.println("||        3. Buscar Facturas         ||");
            System.out.println("||        4. Menu Principal         ||");
            System.out.println("======================================");
            System.out.print("Ingrese una opcion: ");
            try {
                op = readNum.nextInt();
                switch (op) {
                    case 1:
                        MostrarFacturas();
                        break;
                    case 2:
                        EliminarFacturas();
                        break;
                    case 3:
                        BuscarFacturas();
                        break;
                    case 4:
                        System.out.println("");
                        break;
                    default:
                        System.out.println("!!!Ingrese una opcion que esté contenida en el menú!!!");
                }
            } catch (Exception e) {
                readNum.nextLine();
                System.out.println("");
                System.out.println("!!!Debe elegir una opcion correcta!!!");
            }
        } while (op != 4);
    }

        public static void MenuGuardar(){
        int op = 0;
        do {
            System.out.println("================GUARDAR===============");
            System.out.println("||              1. JSON             ||");
            System.out.println("||            2. Binario            ||");
            System.out.println("||        3. Menu Principal         ||");
            System.out.println("======================================");
            System.out.print("Ingrese una opcion: ");
            try {
                op = readNum.nextInt();
                switch (op) {
                    case 1:
                        GuardarJson();
                        break;
                    case 2:
                        GuardarBin();
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("!!!Ingrese una opcion que esté contenida en el menú!!!");
                }
            } catch (Exception e) {
                readNum.nextLine();
                System.out.println("");
                System.out.println("!!!Debe elegir una opcion correcta!!!");
            }
        } while (op != 3);
    }

        public static void MostrarUsuarios() {
            for (int i = 0; i < users.size(); i++) {
                System.out.println("=============================");
                System.out.println(users.get(i).getUsername());
                System.out.println("=============================");
                System.out.println("-----------------------------");
            }
        }

        public static void BuscarUsuario(){
        String username;
            System.out.print("Ingrese el nombre de usuario: ");
            username = readStr.nextLine();
            for (int i = 0; i < users.size(); i++) {
                if (username.equals(users.get(i).getUsername())){
                    System.out.println("=============================");
                    System.out.println(users.get(i).getUsername());
                    System.out.println("=============================");
                }
            }
        }

        public static void EliminarUsuario() {
            String username;
            System.out.print("Ingrese el nombre de usuario: ");
            username = readStr.nextLine();
            for (int i = 0; i < users.size(); i++) {
                if (username.equals(users.get(i).getUsername())) {
                    users.remove(i);
                }
            }
        }

        public static void MostrarProductos() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println("===========PRODUCTO==========");
            System.out.println("Id: " + products.get(i).getId());
            System.out.println("Nombre: " + products.get(i).getName());
            System.out.println("Descripcion: " +products.get(i).getDescription());
            System.out.println("Costo: " +products.get(i).getCost());
            System.out.println("Precio: " +products.get(i).getPrice());
            System.out.println("=========INGREDIENTES========");
            for (int j = 0; j < products.get(i).getIngredients().size(); j++){
            System.out.println("Nombre: " +products.get(i).getIngredients().get(j).getName());
            System.out.println("Cantidad: " +products.get(i).getIngredients().get(j).getQuantity());
            System.out.println("Unidades: " +products.get(i).getIngredients().get(j).getUnits());
            System.out.println("");
            }
            System.out.println("=============================");
            System.out.println("-----------------------------");
        }
    }

        public static void BuscarProducto(){
        int idproducto;
        System.out.print("Ingrese el id del producto: ");
        idproducto = readNum.nextInt();
        for (int i = 0; i < products.size(); i++) {
            if (idproducto == products.get(i).getId()){
                    System.out.println("===========PRODUCTO "+ products.get(i).getId()+"==========");
                    System.out.println("Nombre: " + products.get(i).getName());
                    System.out.println("Descripcion: " +products.get(i).getDescription());
                    System.out.println("Costo: " +products.get(i).getCost());
                    System.out.println("Precio: " +products.get(i).getPrice());
                    System.out.println("=========INGREDIENTES========");
                    for (int j = 0; j < products.get(i).getIngredients().size(); j++){
                    System.out.println("Nombre: " +products.get(i).getIngredients().get(j).getName());
                    System.out.println("Cantidad: " +products.get(i).getIngredients().get(j).getQuantity());
                    System.out.println("Unidades: " +products.get(i).getIngredients().get(j).getUnits());
                    System.out.println("");
                }
                    System.out.println("=============================");
            }
        }
    }

        public static void EliminarProducto() {
        int idproducto;
        System.out.print("Ingrese el id del producto: ");
        idproducto = readNum.nextInt();
        for (int i = 0; i < products.size(); i++) {
            if (idproducto == products.get(i).getId()) {
                products.remove(i);
            }
        }
    }

        public static void MostrarClientes() {
        for (int i = 0; i < clients.size(); i++) {
                System.out.println("=============================");
                System.out.println("Id: " + clients.get(i).getId());
                System.out.println("Nombre: " + clients.get(i).getName());
                System.out.println("Direccion: " + clients.get(i).getAddress());
                System.out.println("Tel: " + clients.get(i).getPhone());
                System.out.println("NIT: " + clients.get(i).getNit());
                System.out.println("=============================");
                System.out.println("-----------------------------");
        }
    }

        public static void BuscarClientes(){
        int idcliente;
        System.out.print("Ingrese el id del cliente: ");
        idcliente = readNum.nextInt();
        for (int i = 0; i < clients.size(); i++) {
            if (idcliente == clients.get(i).getId()){
                    System.out.println("===========CLIENTE "+ clients.get(i).getId()+"==========");
                    System.out.println("Nombre: " + clients.get(i).getName());
                    System.out.println("Direccion: " + clients.get(i).getAddress());
                    System.out.println("Tel: " + clients.get(i).getPhone());
                    System.out.println("NIT: " + clients.get(i).getNit());
                    System.out.println("=============================");
                }
            }
        }

        public static void EliminarClientes() {
        int idcliente;
        System.out.print("Ingrese el id del cliente: ");
        idcliente = readNum.nextInt();
        for (int i = 0; i < clients.size(); i++) {
            if (idcliente == clients.get(i).getId()) {
                clients.remove(i);
            }
        }
    }

        public static void MostrarFacturas() {
        for (int i = 0; i < invoices.size(); i++) {
                System.out.println("============FACTURA==========");
                System.out.println("Id: " + invoices.get(i).getId());
                System.out.println("Cliente: " + invoices.get(i).getClient());
                System.out.println("Fecha: " + invoices.get(i).getDate());
                System.out.println("===========PRODUCTO==========");
                for (int j = 0; j < invoices.get(i).getProducts().size(); j++){
                System.out.println("Nombre: " + invoices.get(i).getProducts().get(j).getName());
                System.out.println("Precio: " + invoices.get(i).getProducts().get(j).getPrice());
                System.out.println("");
            }
                System.out.println("=============================");
                System.out.println("-----------------------------");
        }
    }

        public static void BuscarFacturas(){
        int idFactura;
        System.out.print("Ingrese el id de la factura: ");
        idFactura = readNum.nextInt();
        for (int i = 0; i < invoices.size(); i++) {
            if (idFactura == invoices.get(i).getId()){
                    System.out.println("===========FACTURA " + invoices.get(i).getId()+"==========");
                    System.out.println("Cliente: " + invoices.get(i).getClient());
                    System.out.println("Fecha: " + invoices.get(i).getDate());
                    System.out.println("===========PRODUCTO==========");
                     for (int j = 0; j < invoices.get(i).getProducts().size(); j++){
                    System.out.println("Nombre: " + invoices.get(i).getProducts().get(j).getName());
                    System.out.println("Precio: " + invoices.get(i).getProducts().get(j).getPrice());
                    System.out.println("");
                }
                    System.out.println("=============================");
            }
        }
    }

        public static void EliminarFacturas() {
        int idFactura;
        System.out.print("Ingrese el id de la factura: ");
        idFactura = readNum.nextInt();
        for (int i = 0; i < invoices.size(); i++) {
            if (idFactura == invoices.get(i).getId()) {
                invoices.remove(i);
            }
        }
    }

        public static void GuardarJson(){
            Gson gson = new Gson();
            String JUsuarios = gson.toJson(users);
            Archivos.createFile("./JPruebas/users.json", JUsuarios);
            String JProductos = gson.toJson(products);
            Archivos.createFile("./JPruebas/products.json", JProductos);
            String JClientes = gson.toJson(clients);
            Archivos.createFile("./JPruebas/clients.json", JClientes);
            String JFacturas = gson.toJson(invoices);
            Archivos.createFile("./JPruebas/invoices.json", JFacturas);
        }

        public static void GuardarBin(){
            Archivos.serialize("./Serealizables/clients.ipcrm", clients);
            Archivos.serialize("./Serealizables/users.ipcrm", users);
            Archivos.serialize("./Serealizables/products.ipcrm", products);
            Archivos.serialize("./Serealizables/invoices.ipcrm", invoices);
        }
        //Tablas
    //Users


        public static Object[][] DatosUsuarios(){
            Object[][] arreglo= new Object[users.size()][4];

            for (int i =0 ; i< users.size(); i++){
                arreglo [i][0]=users.get(i).getUsername();
                arreglo[i][1]=users.get(i).getPassword();
                JButton edit = new JButton("Edit");
                edit.setName(users.get(i).getUsername());
                arreglo[i][2]=edit;
                JButton delete = new JButton("Delete");
                delete.setName(users.get(i).getUsername());
                arreglo[i][3]=delete;


            }
            return arreglo;
        }
        //Clientes
    public static Object [][]DatosClientes(){
        Object [][] arreglo = new Object[clients.size()][7];
        for (int i =0 ; i<clients.size();i++){
            arreglo[i][0]=clients.get(i).getId();
            arreglo[i][1]=clients.get(i).getName();
            arreglo[i][2]=clients.get(i).getAddress();
            arreglo[i][3]=clients.get(i).getNit();
            arreglo [i][4]=clients.get(i).getPhone();
            JButton edit = new JButton("Edit");
            edit.setName(clients.get(i).getId()+"");
            arreglo[i][5]=edit;
            JButton delete = new JButton("Delete");
            delete.setName(clients.get(i).getId()+"");
            arreglo[i][6]=delete;


        }
        return  arreglo;
    }

    //Productos
    public static Object [][]DatosProductos(){

        Object  [][] arreglo = new Object [products.size()][8];
        for (int i =0 ; i<products.size();i++){
            arreglo[i][0]=products.get(i).getId();
            arreglo[i][1]=products.get(i).getName();
            arreglo[i][2]=products.get(i).getCost();
            arreglo[i][3]=products.get(i).getPrice();
            arreglo[i][4]=products.get(i).getDescription();
            arreglo[i][5]=products.get(i).Ingredietes();
            JButton edit = new JButton("Edit");
            edit.setName(""+products.get(i).getId());
            arreglo[i][6]=edit;
            JButton delete = new JButton("Delete");
            delete.setName(""+products.get(i).getId());
            arreglo[i][7]=delete;

        }
     return  arreglo;
    }
    //Facturas
    public static Object [][]DatosFacturas(){
        Object  [][] arreglo = new Object [invoices.size()][7];
        for (int i =0 ; i<invoices.size();i++){
            arreglo[i][0]=invoices.get(i).getId();
            //
            arreglo[i][1]=ClienteId(invoices.get(i).getClient());

            arreglo[i][2]=invoices.get(i).getDate();
            arreglo[i][3]=invoices.get(i).NombreProducto();
            arreglo[i][4]=invoices.get(i).Precio();
            JButton edit = new JButton("Edit");
            edit.setName(invoices.get(i).getId()+"");
            arreglo[i][5]=edit;
            JButton delete = new JButton("Delete");
            delete.setName(invoices.get(i).getId()+"");
            arreglo[i][6]=delete;

        }
        return arreglo;

    }

    public static Object [][]DatosIngredientes(int IdPr){
        for (int k = 0; k<products.size(); k++) {
            if (products.get(k).getId() == IdPr) {
                arreglo = new Object[products.get(k).getIngredients().size()][5];
            }
        }
        for (int i=0; i<products.size(); i++) {
            if (products.get(i).getId() == IdPr){
                for (int j = 0; j < products.get(i).getIngredients().size(); j++) {
                    arreglo[j][0] = products.get(i).getIngredients().get(j).getName();
                    arreglo[j][1] = products.get(i).getIngredients().get(j).getQuantity();
                    arreglo[j][2] = products.get(i).getIngredients().get(j).getUnits();
                    JButton edit = new JButton("Edit");
                    edit.setName("" + products.get(i).getIngredients().get(j).getName());
                    arreglo[j][3] = edit;
                    JButton delete = new JButton("Delete");
                    delete.setName("" + products.get(i).getIngredients().get(j).getName());
                    arreglo[j][4] = delete;
                }

            }
        }
        return arreglo;
    }

    //Buscar Producto por idde factura
    public static String ProductosIdFactura(int idFactura){
        for (int i =0; i<invoices.size();i++){
            if (invoices.get(i).getId()==idFactura){
                return invoices.get(i).NombreProducto();
            }
        }
        return "";
    }
    public static String ClienteId(int idCliente){
        for (int i=0; i<clients.size();i++){
            if (clients.get(i).getId()==idCliente){
                return clients.get(i).getName();
            }
        }
        return "";
    }
    public static void BotonEliminarUsuario(String username) {

        for (int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i).getUsername())) {
                logAcciones+=HoraFecha()+"\t Se Eliminoel Usuario "+users.get(i).getUsername()+"\n";
                logAcciones();
                users.remove(i);

            }
        }
    }
    public static void BotonEliminarClientes(int idcliente) {

        for (int i = 0; i < clients.size(); i++) {
            if (idcliente == clients.get(i).getId()) {
                logAcciones+= HoraFecha()+ "\tSe Elimino el Cliente "+clients.get(i).getName()+", id:" +clients.get(i).getId()+"\n";
                logAcciones();
                clients.remove(i);


            }
        }
    }
    public static void BotonEliminarProducto(int iidproducto ) {

        for (int i = 0; i < products.size(); i++) {
            if (iidproducto == products.get(i).getId()) {
                logAcciones+=HoraFecha()+"\tSe Elimino el Producto "+products.get(i).getName()+", id:"+products.get(i).getId()+"\n";
                logAcciones();
                products.remove(i);

            }
        }
    }

    public static void BotonEliminarIngrediente(int IdProd, String Nombre){
        for (int i=0; i<products.size();i++){
            if (IdProd == products.get(i).getId()){
                for (int j=0; j<products.get(i).getIngredients().size();j++){
                    if (Nombre.equals(products.get(i).getIngredients().get(j).getName())){
                        logAcciones+=HoraFecha()+"\tSe Elimino el Ingrediente "+products.get(i).getIngredients().get(j).getName() +", id:"+products.get(i).getId()+"\n";
                        logAcciones();
                        products.get(i).getIngredients().remove(j);
                    }
                }
            }
        }
    }

    public static void BotonEliminarFacturas(int idFactura) {

        for (int i = 0; i < invoices.size(); i++) {
            if (idFactura == invoices.get(i).getId()) {
                logAcciones+=HoraFecha()+"\t Se Elimino la Factura  "+invoices.get(i).getId()+", id :"+invoices.get(i).getId()+"\n";
                logAcciones();
                invoices.remove(i);

            }
        }
    }
    //----------------------------------------------Log de Acciones-----------------------------------



    public static String logAcciones ="Log Acciones \n";
    public static void logAcciones(){



        try {

            FileWriter archivo = new FileWriter("logAcciones.log");

            archivo.write(logAcciones + "\n");


            archivo.close();

        } catch (Exception e) {

        }
    }

    public static String HoraFecha() {
        Date date = new Date();
        //Caso 1: obtener la hora y salida por pantalla con formato:
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        String d = String.format(dateFormat.format(date))+" "+ String.format(hourFormat.format(date));
        return d;
    }

    ////REVISION DE ID REPETIDO

    public static boolean g(ArrayList<Productos> j, int ID)
    {
        boolean t = false;
        for (Productos p: j)
            if (p.getId()==ID)
                t=true;

        return t;
    }
    public static boolean n(ArrayList<Usuarios> j, String nombre)
    {
        boolean t = false;
        for (Usuarios p: j)
            if (p.getUsername()==nombre)
                t=true;

        return t;
    }
    public static boolean f(ArrayList<Facturas> j, int ID)
    {
        boolean t = false;
        for (Facturas p: j)
            if (p.getId()==ID)
                t=true;

        return t;
    }
    public static boolean q(ArrayList<Clientes> j, int ID)
    {
        boolean t = false;
        for (Clientes p: j)
            if (p.getId()==ID)
                t=true;

        return t;
    }

    public static  boolean idCliente(int id ){
        for (int i =0 ; i<clients.size();i++){
            if (id == clients.get(i).getId()){
                return false;
            }
        }
        return true;
    }
    public static  boolean idusuario(String username){
        for (int i =0 ; i<users.size();i++){
            if (username.equals(users.get(i).getUsername()) ){
                return false;
            }
        }
        return true;
    }
    public static  boolean idfacturas(int  id ){
        for (int i =0 ; i<invoices.size();i++){
            if (id == invoices.get(i).getId()){
                return false;
            }
        }
        return true;
    }
    public static boolean idProducts(int  id ){
        for (int i =0 ; i<products.size();i++){
            if (id == products.get(i).getId()){
                return false;
            }
        }
        return true;
    }


}
