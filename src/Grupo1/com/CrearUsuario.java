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
    public String nombre, username, password,confpassword;
    // Arreglos con los que trabajaremos dentro de esta ventana.
    public String[] arreglo;
    public int contador;
    //public static NewUser[] usuarios;



    public CrearUsuario(){
        // Creo la venta para registrar un nuevo usuario
        ventanacrear = new JFrame("Registrar Usuario");
        ventanacrear.setVisible(true);
        ventanacrear.setSize(350,300);
        ventanacrear.setLayout(null);
        ventanacrear.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanacrear.setLocationRelativeTo(null);
        //Creo el panel y lo agrego a la ventana
        panelcrear = new JPanel();
        panelcrear.setLayout(null);
        panelcrear.setSize(350,300);
        panelcrear.setVisible(true);
        panelcrear.setBackground(Color.GRAY);
        ventanacrear.add(panelcrear);
        Componentes();
        //Pasar los datos a las variables de los arreglos para no perder los datos entre las ventanas

    }
    public void Componentes(){
        //Defino los label y se agrega al panel
        lblnombreusuario = new JLabel ("Nombre del Usuario");
        lblnombreusuario.setBounds(10,50,150,20);
        lblnombreusuario.setVisible(true);
        lblnombreusuario.setLayout(null);
        panelcrear.add(lblnombreusuario);


        lblcontrausuario = new JLabel("Contraseña");
        lblcontrausuario.setBounds(10,110,150,20);
        lblcontrausuario.setVisible(true);
        lblcontrausuario.setLayout(null);
        panelcrear.add(lblcontrausuario);


        //Defino los textfield y los agrego al panel

        txtnombre = new JTextField("");
        txtnombre.setBounds(140,50,180,20);
        txtnombre.setVisible(true);
        panelcrear.add(txtnombre);

        txtcontraseña = new JTextField("");
        txtcontraseña.setBounds(140,110,180,20);
        txtcontraseña.setVisible(true);
        panelcrear.add(txtcontraseña);

        //Creo boton de registro y lo  agrego al panel
        btnregistro = new JButton ("Registrar");
        btnregistro.setBounds(200,220,100,20);
        btnregistro.setVisible(true);
        panelcrear.add(btnregistro);

        //Acciones del boton registro
        btnregistro.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               // username = txtusuario.getText();
                nombre = txtnombre.getText();
                password = txtcontraseña.getText();
                //confpassword = txtconfcontra.getText();
                //usuarios[contador] = new NewUser(username,nombre,password,confpassword);
                ventanacrear.setVisible(false);
                Main.AgregaUsuario(nombre,password);
                Main.logAcciones();
               ventanacrear.dispose();
                CrearUsuario.super.dispose();
                CRUD_Users cu = new CRUD_Users();

            }
        });
        //Botón para regresar al Login
        btnatras = new JButton ("Atras");
        btnatras.setBounds(10,220,120,20);
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
