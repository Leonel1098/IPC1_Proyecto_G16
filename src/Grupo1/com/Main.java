package Grupo1.com;

import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.*;

public class Main {

    static Scanner readStr = new Scanner(System.in);
    static Scanner readNum = new Scanner(System.in);
    static ArrayList<Configuraciones>configs = new ArrayList<>();
    static ArrayList<Usuarios>users = new ArrayList<>();
    static ArrayList<Productos>products = new ArrayList<>();
    static ArrayList<Clientes>clients = new ArrayList<>();
    static ArrayList<Facturas>invoices = new ArrayList<>();
    static int ContadorUsers = 0;
    static int ContadorClients = 0;
    static int ContadorProducts = 0;
    static int ContadorInvoices = 0;

    public static void main(String[] args) {
        Error.vericador();
        CargaConfig();
        Login();
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
                        MenuUsuarios();
                        break;
                    case 2:
                        MenuProductos();
                        break;
                    case 3:
                        MenuClientes();
                        break;
                    case 4:
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
}
