package Grupo1.com;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CRUD_Productos extends JFrame implements ActionListener, MouseListener {
    JButton productonuevo;
    public CrearProducto nuevoproducto;
    public Menu menu;
    public CRUD_Productos() {
        this.setTitle("-- Productos --");
        Tabla();
        productonuevo= new JButton("Crear Producto");
        productonuevo.setBounds(30,600,150,150);
        productonuevo.setVisible(true);
        //Dando acción al botón para crear un cliente nuevo
        productonuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salir();
                nuevoproducto = new CrearProducto();
            }
        });
        this.add(productonuevo);
        this.setLayout(null);
        this.setSize(1200, 850);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    JFrame Usuarios;
    public static JTable Tabla;
    public static JScrollPane sp;
    //Contrullendo Tabla
    public void Tabla() {
        //Se va a Crear un Objero con los datos
        //ver Metodo para guardar los Datos en el Arreglo
        Object datos[][] = Main.DatosProductos();
        //Encabezado del la tabla a ausa r
        String[] columnas = {"Id ", "Nombre  ", "Cost ", "Price","Description ","Ingredientes ","Editar","Borra"};
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
        Tabla.getColumnModel().getColumn(1).setPreferredWidth(10);
        Tabla.getColumnModel().getColumn(2).setPreferredWidth(10);
        Tabla.getColumnModel().getColumn(3).setPreferredWidth(10 );
        Tabla.getColumnModel().getColumn(4).setPreferredWidth(100);
        Tabla.getColumnModel().getColumn(5).setPreferredWidth(100);

        Tabla.getColumnModel().getColumn(6).setPreferredWidth(100);

        // METODO PARA RENDERIZAR LOS DATOS
        // La tabla ahora tiene un Renderizado en especifico que nosotros asignamos, ver la clase Render
        // para entender como es que funciona.
        Tabla.setDefaultRenderer(Object.class, new Render());

        sp = new JScrollPane(Tabla);
        sp.setBounds(30, 50, 1100, 500);
        sp.setVisible(true);

        this.add(sp);


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
            if (columna == 6) {
                System.out.println("Editar -----");
                Object value = Tabla.getValueAt(fila, columna);
                // TABLA DEVOLVEME EL OBJETO QUE TENES EN [FILA][COLUMNA]

                if (value instanceof JButton) {

                    System.out.println("OBTENIENDO EL ID POR EL NOMBRE");
                    JButton boton = (JButton) value;




                    //se tendra que refresacar la tabala con los datos actualizados

                    //this.dispose();

                }
            }
            //Aqui se va a crear un mini frame para Mostrar y dar la opcion de eliminar
            if (columna == 7) {
                System.out.println("Eliminar ");
                Object value = Tabla.getValueAt(fila, columna);
                // TABLA DEVOLVEME EL OBJETO QUE TENES EN [FILA][COLUMNA]

                if (value instanceof JButton) {

                    System.out.println("OBTENIENDO EL ID POR EL NOMBRE");
                    JButton boton = (JButton) value;

                    String Usuario = boton.getName();
                    int resp=JOptionPane.showConfirmDialog(null,"Eliminar el Producto: "+ Usuario+"");
                    if (JOptionPane.OK_OPTION == resp){
                        System.out.println("Eliminado");
                        int id = Integer.parseInt(boton.getName());
                        Main.BotonEliminarProducto(id);

                        this.remove(Tabla);
                        this.dispose();
                        CRUD_Productos up= new CRUD_Productos();

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
    public void salir(){
        this.dispose();
    }
}





