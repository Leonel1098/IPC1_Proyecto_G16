package Grupo1.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class Login {

    JFrame login;
    JPanel panel;
    JButton btningresar;
    JLabel lblusuario,lblcontraseña, lbllogo;
    JTextField txtusuario,txtcontraseña;
    JPasswordField contra;
    public String usuario, contraseña;
    public String[] arreglo;
    public int contador;
    //public NewUser[] usuarios;
    //public NuevoUsuario ventanacrear;
    public Menu menu;
    ImageIcon Ilogo;

    public Login(){
        Main.logAcciones();
        //Creo la ventana principal
        login = new JFrame("Login");
        login.setSize(350,300);
        login.setLayout(null);
        login.setVisible(true);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setLocationRelativeTo(null);
        //Creo el panel y lo agrego a la ventana
        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(350,310);
        panel.setVisible(true);
        login.add(panel);
        this.Componentes();
        panel.repaint();
    }

    public void Componentes() {

        Ilogo = new ImageIcon("./src/logo/user.png");
        lbllogo = new JLabel(Ilogo);
        lbllogo.setBounds(95,20,150,106);
        lbllogo.setVisible(true);
        panel.add(lbllogo);

        //Defino los label y se agrega al panel
        lblusuario = new JLabel("Usuario");
        lblusuario.setBounds(20, 146, 50, 20);
        lblusuario.setVisible(true);
        lblusuario.setLayout(null);
        panel.add(lblusuario);

        lblcontraseña = new JLabel("Contraseña");
        lblcontraseña.setBounds(20, 175, 80, 20);
        lblcontraseña.setVisible(true);
        lblcontraseña.setLayout(null);
        panel.add(lblcontraseña);

        //Defino los textfield y los agrego al panel
        txtusuario = new JTextField("");
        txtusuario.setBounds(110, 146, 200, 20);
        txtusuario.setVisible(true);
        panel.add(txtusuario);

        contra = new JPasswordField();
        contra.setBounds(110,175,200,20);
        contra.setVisible(true);
        panel.add(contra);

        /*txtcontraseña = new JTextField("");
        txtcontraseña.setBounds(80, 55, 200, 20);
        txtcontraseña.setVisible(true);
        panel.add(txtcontraseña);*/

        //Creo boton de ingreso y lo  agrego al panel
        btningresar = new JButton("Ingresar");
        btningresar.setBounds(120, 225, 100, 30);
        btningresar.setVisible(true);
        panel.add(btningresar);

        //Acciones del boton de ingreso
        btningresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == btningresar) {
                    usuario = txtusuario.getText();
                   contraseña = contra.getText();
                    for (int i = 0; i < Main.users.size(); i++) {
                        if (usuario.equals(Main.users.get(i).getUsername()) && contraseña.equals(Main.users.get(i).getPassword())){
                            Main.logAcciones+=   Main.HoraFecha()+"\t"+usuario+": Inicio de Sesión Exitoso"+"\n";
                            menu = new Menu();
                            login.setVisible(false);

                        } else if (i==Main.users.size()-1){
                            Main.logAcciones+=   Main.HoraFecha()+"\t"+usuario+": Inicio de Sesión Fallido "+"\n";
                            JOptionPane.showMessageDialog(null,"Datos Incorrectos");
                        }

                    }

                }

            }

        });
    }



}
