package Grupo1.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    JFrame menu;
    JPanel panelmenu;
    JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btneditar;
    JLabel lblnombre,lbldireccion,lblphone,lblload;
    JTextField txtnombre,txtdireccion,txtphone,txtload;
    public Login login;


    public Menu(){
        Main.logAcciones();
        //Ventana que mostrara el menu de las opciones
        menu = new JFrame("Menú");
        menu.setSize(350,350);
        menu.setLayout(null);
        menu.setVisible(true);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setLocationRelativeTo(null);
        //Creo el panel y lo agrego a la ventana
        panelmenu = new JPanel();
        panelmenu.setLayout(null);
        panelmenu.setSize(350,350);
        panelmenu.setVisible(true);
        menu.add(panelmenu);
        this.Components();

    }
    public void Components(){

        //Creo los botenes que contienen las opciones del menú
        btn1 = new JButton("Información del Restaurante");
        btn1.setBounds(70,20,200,20);
        btn1.setVisible(true);
        panelmenu.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoRestaurante();
            }
        });

        btn2 = new JButton("CRUD Usuarios");
        btn2.setBounds(70,60,200,20);
        btn2.setVisible(true);
        panelmenu.add(btn2);
        //Dando accion al boton
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                     CRUD_Users usuariosframe = new CRUD_Users();

                     //menu.setVisible(false);
            }
        });

        btn3 = new JButton("CRUD Clientes");
        btn3.setBounds(70,100,200,20);
        btn3.setVisible(true);
        panelmenu.add(btn3);

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CRUD_Clientes clientesframe = new CRUD_Clientes();
               // menu.setVisible(false);
            }
        });

        btn4 = new JButton("CRUD Productos");
        btn4.setBounds(70,140,200,20);
        btn4.setVisible(true);
        panelmenu.add(btn4);

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CRUD_Productos productosframe = new CRUD_Productos();
               // menu.setVisible(false);
            }
        });

        btn6 = new  JButton("Facturas");
        btn6.setBounds(70,180,200,20);
        btn6.setVisible(true);
        panelmenu.add(btn6);

        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               CRUD_Facturas facturasframe = new CRUD_Facturas();
              //  menu.setVisible(false);
            }
        });

        btn7 = new JButton("Serialización");
        btn7.setBounds(70,220,200,20);
        btn7.setVisible(true);
        panelmenu.add(btn7);

        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.GuardarJson();
                JOptionPane.showMessageDialog(null, "Datos Guardados");
            }
        });

        btn5 = new JButton("Cerrar Sesión");
        btn5.setBounds(20,270,120,20);
        btn5.setVisible(true);
        panelmenu.add(btn5);

        //Acciones del boton regresar
        btn5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                login = new Login();
                menu.dispose();
            }
        });

    }
    public void InfoRestaurante (){
        menu = new JFrame("Información del Restaurante");
        menu.setSize(440,270);
        menu.setLayout(null);
        menu.setVisible(true);
        menu.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        menu.setLocationRelativeTo(null);
        //Creo el panel y lo agrego a la ventana
        panelmenu = new JPanel();
        panelmenu.setLayout(null);
        panelmenu.setSize(450,350);
        panelmenu.setVisible(true);
        menu.add(panelmenu);

        lblnombre = new JLabel("Nombre del Restaurante");
        lblnombre.setBounds(20,10,160,20);
        lblnombre.setLayout(null);
        lblnombre.setVisible(true);
        panelmenu.add(lblnombre);

        lbldireccion = new JLabel("Dirección del Restaurante");
        lbldireccion.setBounds(20,50,160,20);
        lbldireccion.setLayout(null);
        lbldireccion.setVisible(true);
        panelmenu.add(lbldireccion);

        lblphone = new JLabel("Telefono del Restaurante");
        lblphone.setBounds(20,90,160,20);
        lblphone.setLayout(null);
        lblphone.setVisible(true);
        panelmenu.add(lblphone);

        lblload = new JLabel("Load");
        lblload.setBounds(20,130,160,20);
        lblload.setLayout(null);
        lblload.setVisible(true);
        panelmenu.add(lblload);

        txtnombre= new JTextField();
        txtnombre.setVisible(true);
        txtnombre.setBounds(200,10,200,20);
        txtnombre.setLayout(null);
        panelmenu.add(txtnombre);

        txtdireccion= new JTextField();
        txtdireccion.setVisible(true);
        txtdireccion.setBounds(200,50,200,20);
        txtdireccion.setLayout(null);
        panelmenu.add(txtdireccion);

        txtphone= new JTextField();
        txtphone.setVisible(true);
        txtphone.setBounds(200,90,200,20);
        txtphone.setLayout(null);
        panelmenu.add(txtphone);

        txtload= new JTextField();
        txtload.setVisible(true);
        txtload.setBounds(200,130,200,20);
        txtload.setLayout(null);
        panelmenu.add(txtload);

        for (int i=0; i<Main.configs.size(); i++){
            txtnombre.setText(Main.configs.get(i).getName());
            txtdireccion.setText(Main.configs.get(i).getAddress());
            txtphone.setText(Integer.toString(Main.configs.get(i).getPhone()));
            txtload.setText(Main.configs.get(i).getLoad());
        }

        btneditar = new JButton("Editar");
        btneditar.setBounds(180,190,80,30);
        btneditar.setVisible(true);
        panelmenu.add(btneditar);

        btneditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0; i<Main.configs.size(); i++){
                    Main.configs.get(i).setName(txtnombre.getText());
                    Main.configs.get(i).setAddress(txtdireccion.getText());
                    Main.configs.get(i).setPhone(Integer.parseInt(txtphone.getText()));
                    Main.configs.get(i).setLoad(txtload.getText());
                }
            }
        });
    }

}



