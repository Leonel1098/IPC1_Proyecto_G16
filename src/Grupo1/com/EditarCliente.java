package Grupo1.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarCliente extends JFrame implements ActionListener{
    JButton Editar,Atras;
    JLabel lblname, lbladdress, lblphone, lblnit;
    JTextField txtname, txtaddress, txtphone, txtnit;
    String name, address, phone, nit;
    public static int Id;

    EditarCliente(int IdCl) {

        Id = IdCl;

        lblname = new JLabel("Nombre:");
        lblname.setBounds(30,20,150,20);
        lblname.setVisible(true);
        this.add(lblname);

        lbladdress= new JLabel("Dirección:");
        lbladdress.setBounds(30,50,150,20);
        lbladdress.setVisible(true);
        this.add(lbladdress);

        lblphone = new JLabel("Telefono:");
        lblphone.setBounds(30,80,150,20);
        lblphone.setVisible(true);
        this.add(lblphone);

        lblnit = new JLabel("NIT:");
        lblnit.setBounds(30,110,150,20);
        lblnit.setVisible(true);
        this.add(lblnit);

        txtname = new JTextField();
        txtname.setBounds(130,20,180,20);
        txtname.setVisible(true);
        this.add(txtname);

        txtaddress = new JTextField();
        txtaddress.setBounds(130,50,180,20);
        txtaddress.setVisible(true);
        this.add(txtaddress);

        txtphone = new JTextField();
        txtphone.setBounds(130,80,180,20);
        txtphone.setVisible(true);
        this.add(txtphone);

        txtnit = new JTextField();
        txtnit.setBounds(130,110,180,20);
        txtnit.setVisible(true);
        this.add(txtnit);

        Editar = new JButton("Actualizar");
        Editar.setBounds(120, 150, 100, 30);
        Editar.setVisible(true);
        Editar.addActionListener(this);
        this.add(Editar);

        this.setTitle("Actualizar Clientes");
        this.setSize(350, 185);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        for (int i=0; i<Main.clients.size(); i++){
            if(Main.clients.get(i).getId() == Id) {
                txtname.setText(Main.clients.get(i).getName());
                txtaddress.setText(Main.clients.get(i).getAddress());
                txtphone.setText(Main.clients.get(i).getPhone());
                txtnit.setText(Main.clients.get(i).getNit());
            }
        }
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Editar) {
            name = txtname.getText();
            address = txtaddress.getText();
            phone = txtphone.getText();
            nit = txtnit.getText();
            Main.EditarCliente(Id, name, address, phone, nit);
            this.dispose();
            CRUD_Clientes CC = new CRUD_Clientes();
        }
    }


}

