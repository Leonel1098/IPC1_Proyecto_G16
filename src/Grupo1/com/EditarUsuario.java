package Grupo1.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarUsuario extends JFrame implements ActionListener {
    JButton Editar;
    JLabel lbluser, lblpassword;
    JTextField txtuser, txtpassword;
    String user, password;
    public static String username;

    public EditarUsuario(String usernm){
        lbluser = new JLabel("Usuario:");
        lbluser.setBounds(30,20,150,20);
        lbluser.setVisible(true);
        this.add(lbluser);

        username = usernm;

        lblpassword = new JLabel("Contraseña:");
        lblpassword.setBounds(30,50,150,20);
        lblpassword.setVisible(true);
        this.add(lblpassword);

        txtuser = new JTextField();
        txtuser.setBounds(130,20,180,20);
        txtuser.setVisible(true);
        this.add(txtuser);

        txtpassword = new JTextField();
        txtpassword.setBounds(130,50,180,20);
        txtpassword.setVisible(true);
        this.add(txtpassword);

        Editar = new JButton("Actualizar");
        Editar.setBounds(120, 100, 100, 30);
        Editar.setVisible(true);
        Editar.addActionListener(this);
        this.add(Editar);

        this.setTitle("Actualizar Usuario");
        this.setSize(350, 180);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        for (int i=0; i<Main.users.size(); i++){
            if(Main.users.get(i).getUsername().equals(username)) {
                txtuser.setText(Main.users.get(i).getUsername());
                txtpassword.setText(Main.users.get(i).getPassword());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Editar){
            user= txtuser.getText();
            password = txtpassword.getText();
            Main.EditarUsuario(username, user, password);
            this.dispose();
            CRUD_Users CU = new CRUD_Users();
        }
    }
}
