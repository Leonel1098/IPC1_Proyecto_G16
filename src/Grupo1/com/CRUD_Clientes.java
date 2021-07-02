package Grupo1.com;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CRUD_Clientes extends JFrame implements ActionListener, MouseListener {
    JButton clientenuevo;
    public CrearCliente nuevocliente;
    public CRUD_Clientes() {
        this.setTitle("-- Clientes --");
        TablaClientes();
        clientenuevo= new JButton("Crear Cliente");
        clientenuevo.setBounds(30,580,150,50);
        clientenuevo.setVisible(true);
        //Dando acción al botón para crear un cliente nuevo
        clientenuevo.addActionListener(this);
        this.add(clientenuevo);
        this.setLayout(null);
        this.setSize(1170, 700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    JFrame Usuarios;
    public static JTable TablaClientes;
    public static JScrollPane sp;
    //Contrullendo Tabla de Alumnos

    public void TablaClientes() {
        //Se va a Crear un Objero con los datos
        //ver Metodo  para guardar los Datos en el Arreglo
        Object datos[][] = Main.DatosClientes();
        //Encabezado del la tabla a ausa r
        String[] columnas = {"Id Cliente", "Nombre  ", "Ciudad ", "Nit","Telefono","Editar","Borra"};
        //Se Crea la Tabla
        TablaClientes = new JTable();
        //Guardando los datos a ala taba
        DefaultTableModel d = new DefaultTableModel(datos, columnas) {
            public boolean isCellEditable(int row, int column) {
                return false;

            }
        };
        //Ingresadno los datos y acciones a la tabal
        TablaClientes.setModel(d);
        TablaClientes.addMouseListener(this);
        //Renderizando al informacion en la tabala para que se vea Bonito
        TablaClientes.getColumnModel().getColumn(0).setPreferredWidth(5);
        TablaClientes.getColumnModel().getColumn(1).setPreferredWidth(30);
        TablaClientes.getColumnModel().getColumn(2).setPreferredWidth(30);
        TablaClientes.getColumnModel().getColumn(3).setPreferredWidth(10);
        TablaClientes.getColumnModel().getColumn(4).setPreferredWidth(10);
        TablaClientes.getColumnModel().getColumn(5).setPreferredWidth(100);
        TablaClientes.getColumnModel().getColumn(6).setPreferredWidth(100);

        // METODO PARA RENDERIZAR LOS DATOS
        // La tabla ahora tiene un Renderizado en especifico que nosotros asignamos, ver la clase Render
        // para entender como es que funciona.
        TablaClientes.setDefaultRenderer(Object.class, new Render());

        sp = new JScrollPane(TablaClientes);
        sp.setBounds(30, 50, 1100, 500);
        sp.setVisible(true);

        this.add(sp);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
        nuevocliente = new CrearCliente();
    }



    @Override
    //Metodo para la acciona del los Botones detro de la tabla
    public void mouseClicked(MouseEvent e) {
        // Hagamos de cuenta que el objeto que recibe el evento, siempre hara este metodo.
        // Segun la logica, nos dice que esta tabla recibira clicks unicamente
        System.out.println("Se le dio click a la tabla");

        // Obtenemos la columna con el MouseEvent.getX
        int columna = TablaClientes.getColumnModel().getColumnIndexAtX(e.getX());
        // Obtenemos la fila con el MouseEvent.getY
        int fila = e.getY() / TablaClientes.getRowHeight();
        System.out.println("Click en la posicion: " + fila + "-" + columna);

        // Solo validamos que se haya dado click dentro de la tabla, pero esto esta de mas.
        if (fila < TablaClientes.getRowCount() && fila >= 0 && columna < TablaClientes.getColumnCount() && columna >= 0) {
            // Obtenemos el objeto que esta dentro de la tabla, tomando en cuenta la fila y columna
            System.out.println("valido click");
            //Aqui se va a poner un mini frame para Mostrar y Editar  la Infomacion
            if (columna == 5) {
                System.out.println("Editar -----");
                Object value = TablaClientes.getValueAt(fila, columna);

                // TABLA DEVOLVEME EL OBJETO QUE TENES EN [FILA][COLUMNA]

                if (value instanceof JButton) {


                    JButton boton = (JButton) value;
                    int IdCliente = Integer.parseInt(boton.getName());
                    System.out.println(IdCliente);
<<<<<<< Updated upstream
                    //EditarCliente Ec = new EditarCliente(IdCliente);
=======
                   // EditarCliente Ec = new EditarCliente(IdCliente);
>>>>>>> Stashed changes
                    this.dispose();
                    //this.dispose();
                    //se tendra que refresacar la tabala con los datos actualizados

                    //this.dispose();

                }
            }
            //Aqui se va a crear un mini frame para Mostrar y dar la opcion de eliminar
            if (columna == 6) {
                System.out.println("Eliminar ");
                Object value = TablaClientes.getValueAt(fila, columna);
                // TABLA DEVOLVEME EL OBJETO QUE TENES EN [FILA][COLUMNA]

                if (value instanceof JButton) {

                    System.out.println("OBTENIENDO EL ID POR EL NOMBRE");
                    JButton boton = (JButton) value;

                    String Usuario = boton.getName();
                    int resp=JOptionPane.showConfirmDialog(null,"Eliminar el Cliente: "+ Usuario+"");
                    if (JOptionPane.OK_OPTION == resp){
                        System.out.println("Eliminado");
                        int id = Integer.parseInt(boton.getName());
                        Main.BotonEliminarClientes(id);
                        this.remove(TablaClientes);
                        this.dispose();
                        CRUD_Clientes uc = new CRUD_Clientes();

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
}




