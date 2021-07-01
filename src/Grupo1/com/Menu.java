package Grupo1.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    JFrame menu;
    JPanel panelmenu;
    JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7;
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
        btn1.setBounds(70,30,200,20);
        btn1.setVisible(true);
        panelmenu.add(btn1);

        btn2 = new JButton("CRUD Usuarios");
        btn2.setBounds(70,70,200,20);
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
        btn3.setBounds(70,110,200,20);
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
        btn4.setBounds(70,150,200,20);
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
        btn6.setBounds(70,190,200,20);
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
        btn7.setBounds(70,230,200,20);
        btn7.setVisible(true);
        panelmenu.add(btn7);

        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btn5 = new JButton("Atras");
        btn5.setBounds(10,270,120,20);
        btn5.setVisible(true);
        panelmenu.add(btn5);

        //Acciones del boton regresar
        btn5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                login = new Login();
                menu.setVisible(false);
            }
        });
    }
}
