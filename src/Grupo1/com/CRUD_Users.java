package Grupo1.com;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CRUD_Users extends JFrame implements ActionListener, MouseListener {
    JButton usernuevo;
    public CrearUsuario nuevouser;
    public Menu menu;
    public CRUD_Users() {
        this.setTitle("-- Users --");
        TablaUsuarios();
        usernuevo= new JButton("Crear Usuario");
        usernuevo.setBounds(30,600,150,150);
        usernuevo.setVisible(true);
        //Dando acción al botón para crear un cliente nuevo
        usernuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salir();
                nuevouser = new CrearUsuario();
            }
        });
        this.add(usernuevo);
        this.setLayout(null);
        this.setSize(850, 850);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    JFrame Usuarios;
    public static JTable TablaUsuarios;
    public static JScrollPane sp;
    //Contrullendo Tabla
    public void TablaUsuarios() {
        //Se va a Crear un Objero con los datos
        //ver Metodo  para guardar los Datos en el Arreglo
        Object datos[][] = Main.DatosUsuarios();
        //Encabezado del la tabla a ausa r
        String[] columnas = {"Nombre Usuario ", "Password ", "Edit", "Delete"};
        //Se Crea la Tabla
        TablaUsuarios = new JTable();
        //Guardando los datos a ala taba
        DefaultTableModel d = new DefaultTableModel(datos, columnas) {
            public boolean isCellEditable(int row, int column) {
                return false;

            }
        };
        //Ingresadno los datos y acciones a la tabal
        TablaUsuarios.setModel(d);
        TablaUsuarios.addMouseListener(this);
        //Renderizando al informacion en la tabala para que se vea Bonito
        TablaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(10);
        TablaUsuarios.getColumnModel().getColumn(1).setPreferredWidth(10);
        TablaUsuarios.getColumnModel().getColumn(2).setPreferredWidth(10);
        TablaUsuarios.getColumnModel().getColumn(3).setPreferredWidth(100);

        // METODO PARA RENDERIZAR LOS DATOS
        // La tabla ahora tiene un Renderizado en especifico que nosotros asignamos, ver la clase Render
        // para entender como es que funciona.
        TablaUsuarios.setDefaultRenderer(Object.class, new Render());

        sp = new JScrollPane(TablaUsuarios);
        sp.setBounds(30, 50, 650, 500);
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
        int columna = TablaUsuarios.getColumnModel().getColumnIndexAtX(e.getX());
        // Obtenemos la fila con el MouseEvent.getY
        int fila = e.getY() / TablaUsuarios.getRowHeight();
        System.out.println("Click en la posicion: " + fila + "-" + columna);

        // Solo validamos que se haya dado click dentro de la tabla, pero esto esta de mas.
        if (fila < TablaUsuarios.getRowCount() && fila >= 0 && columna < TablaUsuarios.getColumnCount() && columna >= 0) {
            // Obtenemos el objeto que esta dentro de la tabla, tomando en cuenta la fila y columna
            System.out.println("valido click");
            //Aqui se va a poner un mini frame para Mostrar y Editar  la Infomacion del Usuario
            if (columna == 2) {
                System.out.println("Editar -----");
                Object value = TablaUsuarios.getValueAt(fila, columna);
                // TABLA DEVOLVEME EL OBJETO QUE TENES EN [FILA][COLUMNA]

                if (value instanceof JButton) {

                    System.out.println("OBTENIENDO EL ID POR EL NOMBRE");
                    JButton boton = (JButton) value;





                    //se tendra que refresacar la tabala con los datos actualizados

                    //this.dispose();

                }
            }
            //Aqui se va a crear un mini frame para Mostrar y dar la opcion de eliminar el usuario
            if (columna == 3) {
                System.out.println("Eliminar ");
                Object value = TablaUsuarios.getValueAt(fila, columna);
                // TABLA DEVOLVEME EL OBJETO QUE TENES EN [FILA][COLUMNA]

                if (value instanceof JButton) {

                    System.out.println("OBTENIENDO EL ID POR EL NOMBRE");
                    JButton boton = (JButton) value;
                    String Usuario = boton.getName();
                    int resp=JOptionPane.showConfirmDialog(null,"Eliminar el usuario: "+ Usuario+"");
                    if (JOptionPane.OK_OPTION == resp){
                        System.out.println("Eliminado");
                        Main.BotonEliminarUsuario(boton.getName());
                        Main.logAcciones();
                        this.remove(TablaUsuarios);
                        this.dispose();
                        CRUD_Users cs = new CRUD_Users();

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

