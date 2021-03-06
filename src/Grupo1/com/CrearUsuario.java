package Grupo1.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CrearUsuario extends CRUD_Users{
    JFrame ventanacrear;
    JPanel panelcrear;
    JButton btnregistro, btnatras;
    JLabel lblnombreusuario, lblcontrausuario;
    JTextField txtnombre,txtcontraseña;
    public Menu menu;
    public CRUD_Users usuario;
    //Variables utilizadas para guardas los datos ingresados en los jtextfield
    public String nombre, password;


    public static  String  username,confpassword;
    // Arreglos con los que trabajaremos dentro de esta ventana.
    public String[] arreglo;
    public int contador;



    public CrearUsuario(){
        // Creo la venta para registrar un nuevo usuario
        ventanacrear = new JFrame("Registrar Usuario");
        ventanacrear.setVisible(true);
        ventanacrear.setSize(350,210);
        ventanacrear.setLayout(null);
        ventanacrear.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        ventanacrear.setLocationRelativeTo(null);
        //Creo el panel y lo agrego a la ventana
        panelcrear = new JPanel();
        panelcrear.setLayout(null);
        panelcrear.setSize(350,300);
        panelcrear.setVisible(true);
        ventanacrear.add(panelcrear);
        Componentes();
        //Pasar los datos a las variables de los arreglos para no perder los datos entre las ventanas

    }
    public void Componentes(){
        //Defino los label y se agrega al panel
        lblnombreusuario = new JLabel ("Nombre del Usuario");
        lblnombreusuario.setBounds(10,30,150,20);
        lblnombreusuario.setVisible(true);
        lblnombreusuario.setLayout(null);
        panelcrear.add(lblnombreusuario);


        lblcontrausuario = new JLabel("Contraseña");
        lblcontrausuario.setBounds(10,70,150,20);
        lblcontrausuario.setVisible(true);
        lblcontrausuario.setLayout(null);
        panelcrear.add(lblcontrausuario);


        //Defino los textfield y los agrego al panel

        txtnombre = new JTextField("");
        txtnombre.setBounds(140,30,180,20);
        txtnombre.setVisible(true);
        panelcrear.add(txtnombre);

        txtcontraseña = new JTextField("");
        txtcontraseña.setBounds(140,70,180,20);
        txtcontraseña.setVisible(true);
        panelcrear.add(txtcontraseña);

        //Creo boton de registro y lo  agrego al panel
        btnregistro = new JButton ("Registrar");
        btnregistro.setBounds(190,130,120,20);
        btnregistro.setVisible(true);
        panelcrear.add(btnregistro);

        //Acciones del boton registro
        btnregistro.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                nombre = txtnombre.getText();
                password = txtcontraseña.getText();
                String username = nombre;
                boolean flag =Main.idusuario(username);
                if (flag) {
                    Main.AgregaUsuario(nombre,password);

                    ventanacrear.dispose();
                    CrearUsuario.super.dispose();
                    CRUD_Users cu = new CRUD_Users();
                    ventanacrear.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "El Username Ya Existe Cambiarlo ");
                }


            }
        });
        //Botón para regresar al Login
        btnatras = new JButton ("Atras");
        btnatras.setBounds(20,130,120,20);
        btnatras.setVisible(true);
        panelcrear.add(btnatras);
        //Acciones del boton regresar
        btnatras.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {

                ventanacrear.setVisible(false);
            }

        });
    }
}
