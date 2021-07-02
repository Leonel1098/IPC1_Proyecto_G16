package Grupo1.com;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EditarProductos extends JFrame implements ActionListener, MouseListener {

    JButton IngredienteNuevo, btnactualizar;
    public CrearProducto nuevoproducto;
    JLabel lblnombre, lbldescripcion, lblcost, lblprice;
    JTextField txtnombre, txtdescripcion, txtcost, txtprice;
    String nombre, descripcion;
    int cost, price;
    public Menu menu;
    public static int IDPR;

    public EditarProductos(int IdPr) {
        this.setTitle("-- Ingredientes --");
        Tabla(IdPr);
        IngredienteNuevo = new JButton("Crear Ingrediente");
        IngredienteNuevo.setBounds(30,500,150,30);
        IngredienteNuevo.setVisible(true);
        //Dando acción al botón para crear un cliente nuevo
        IngredienteNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarIngrediente AI = new AgregarIngrediente(IdPr);
                salir();
            }
        });
        //Botón para regresar al Login
        btnactualizar = new JButton ("Actualizar");
        btnactualizar.setBounds(230,500,150,30);
        btnactualizar.setVisible(true);
        this.add(btnactualizar);
        //Acciones del boton regresar
        btnactualizar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                nombre = txtnombre.getText();
                descripcion = txtdescripcion.getText();
                cost = Integer.parseInt(txtcost.getText());
                price = Integer.parseInt(txtprice.getText());
                for (int i=0; i<Main.products.size(); i++) {
                    if (Main.products.get(i).getId()== IdPr) {
                        Main.EditarProducto(IdPr, nombre, descripcion, cost, price);
                    }
                }
                CRUD_Productos CP = new CRUD_Productos();
            }
        });
        this.add(IngredienteNuevo);
        this.setLayout(null);
        this.setSize(420, 580);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    JFrame Usuarios;
    public static JTable Tabla;
    public static JScrollPane sp;
    //Contrullendo Tabla
    public void Tabla(int IdPr) {
        //Se va a Crear un Objero con los datos
        //ver Metodo para guardar los Datos en el Arreglo
        Object datos[][] = Main.DatosIngredientes(IdPr);
        //Encabezado del la tabla a ausa r
        String[] columnas = {"Nombre ", "Cantidad", "Unidades ", "Editar","Borra"};
        //Se Crea la Tabla
        Tabla = new JTable();
        //Guardando los datos a ala taba
        DefaultTableModel d = new DefaultTableModel(datos, columnas) {
            public boolean isCellEditable(int row, int column) {
                return false;

            }
        };
        //Ingresadno los datos y acciones a la tabal
        Tabla.setModel(d);
        Tabla.addMouseListener(this);
        //Renderizando al informacion en la tabala para que se vea Bonito
        Tabla.getColumnModel().getColumn(0).setPreferredWidth(5);
        Tabla.getColumnModel().getColumn(1).setPreferredWidth(5);
        Tabla.getColumnModel().getColumn(2).setPreferredWidth(5);
        Tabla.getColumnModel().getColumn(3).setPreferredWidth(10);
        Tabla.getColumnModel().getColumn(4).setPreferredWidth(10);

        // METODO PARA RENDERIZAR LOS DATOS
        // La tabla ahora tiene un Renderizado en especifico que nosotros asignamos, ver la clase Render
        // para entender como es que funciona.
        Tabla.setDefaultRenderer(Object.class, new Render());

        sp = new JScrollPane(Tabla);
        sp.setBounds(30, 150, 350, 300);
        sp.setVisible(true);

        this.add(sp);

        lblnombre = new JLabel("Nombre:");
        lblnombre.setBounds(90, 20,120,30);
        lblnombre.setVisible(true);
        this.add(lblnombre);

        lbldescripcion = new JLabel("Descripcion:");
        lbldescripcion.setBounds(90, 50,120,30);
        lbldescripcion.setVisible(true);
        this.add(lbldescripcion);

        lblcost = new JLabel("Costo:");
        lblcost.setBounds(90, 80,120,30);
        lblcost.setVisible(true);
        this.add(lblcost);

        lblprice = new JLabel("Precio:");
        lblprice.setBounds(90, 110,120,30);
        lblprice.setVisible(true);
        this.add(lblprice);

        txtnombre = new JTextField();
        txtnombre.setBounds(200, 20,120,20);
        txtnombre.setVisible(true);
        this.add(txtnombre);

        txtdescripcion = new JTextField();
        txtdescripcion.setBounds(200, 50,120,20);
        txtdescripcion.setVisible(true);
        this.add(txtdescripcion);

        txtprice = new JTextField();
        txtprice.setBounds(200, 110,120,20);
        txtprice.setVisible(true);
        this.add(txtprice);

        txtcost = new JTextField();
        txtcost.setBounds(200, 80,120,20);
        txtcost.setVisible(true);
        this.add(txtcost);
        IDPR = IdPr;

        for (int i=0; i<Main.products.size(); i++){
            if (IdPr == Main.products.get(i).getId()){
                txtnombre.setText(Main.products.get(i).getName());
                txtdescripcion.setText(Main.products.get(i).getDescription());
                txtcost.setText(String.valueOf(Main.products.get(i).getCost()));
                txtprice.setText(String.valueOf(Main.products.get(i).getPrice()));
            }
        }
        salir();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    //Metodo para la acciona del los Botones detro de la tabla
    public void mouseClicked(MouseEvent e) {
        // Hagamos de cuenta que el objeto que recibe el evento, siempre hara este metodo.
        // Segun la logica, nos dice que esta tabla recibira clicks unicamente
        System.out.println("Se le dio click a la tabla");

        // Obtenemos la columna con el MouseEvent.getX
        int columna = Tabla.getColumnModel().getColumnIndexAtX(e.getX());
        // Obtenemos la fila con el MouseEvent.getY
        int fila = e.getY() / Tabla.getRowHeight();
        System.out.println("Click en la posicion: " + fila + "-" + columna);

        // Solo validamos que se haya dado click dentro de la tabla, pero esto esta de mas.
        if (fila < Tabla.getRowCount() && fila >= 0 && columna < Tabla.getColumnCount() && columna >= 0) {
            // Obtenemos el objeto que esta dentro de la tabla, tomando en cuenta la fila y columna
            System.out.println("valido click");
            //Aqui se va a poner un mini frame para Mostrar y Editar  la Infomacion
            if (columna == 4) {
                System.out.println("Editar -----");
                Object value = Tabla.getValueAt(fila, columna);
                // TABLA DEVOLVEME EL OBJETO QUE TENES EN [FILA][COLUMNA]

                if (value instanceof JButton) {

                    System.out.println("OBTENIENDO EL ID POR EL NOMBRE");
                    JButton boton = (JButton) value;
                    String NP = boton.getName();
                    //AgregarIngrediente AI = new AgregarIngrediente(IDPR, NP);

                    //se tendra que refresacar la tabala con los datos actualizados

                    //this.dispose();

                }
            }
            //Aqui se va a crear un mini frame para Mostrar y dar la opcion de eliminar
            if (columna == 4) {
                System.out.println("Eliminar ");
                Object value = Tabla.getValueAt(fila, columna);
                // TABLA DEVOLVEME EL OBJETO QUE TENES EN [FILA][COLUMNA]

                if (value instanceof JButton) {

                    System.out.println("OBTENIENDO EL ID POR EL NOMBRE");
                    JButton boton = (JButton) value;

                    String ingrediente = boton.getName();
                    int resp=JOptionPane.showConfirmDialog(null,"Eliminar el Producto: "+ ingrediente+"");
                    if (JOptionPane.OK_OPTION == resp){
                        System.out.println("Eliminado");
                        String nom = boton.getName();
                        Main.BotonEliminarIngrediente(IDPR, nom);
                        System.out.println(nom);
                        System.out.println(IDPR);
                        this.remove(Tabla);
                        this.dispose();
                        EditarProductos EP = new EditarProductos(IDPR);

                    }
                    else{
                        System.out.println("");
                    }


                    //se tendra que repintar la tabla y mostrar los datos actualizados

                    //this.dispose();

                }

            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public  void salir(){
        this.dispose();
    }
}


