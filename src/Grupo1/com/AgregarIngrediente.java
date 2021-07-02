package Grupo1.com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AgregarIngrediente extends JFrame implements ActionListener {
    JButton Agregar;
    JLabel lblname, lblcant, lblunit;
    JTextField txtname, txtcant, txtunit;
    String name, unit;
    int cant;
    public static int IdProd;

    public AgregarIngrediente(int Id){
        lblname = new JLabel("Nombre:");
        lblname.setBounds(30,20,150,20);
        lblname.setVisible(true);
        this.add(lblname);

        lblcant = new JLabel("Cantidad:");
        lblcant.setBounds(30,50,150,20);
        lblcant.setVisible(true);
        this.add(lblcant);

        lblunit = new JLabel("Unidades:");
        lblunit.setBounds(30,80,150,20);
        lblunit.setVisible(true);
        this.add(lblunit);


        txtname = new JTextField();
        txtname.setBounds(130,20,180,20);
        txtname.setVisible(true);
        this.add(txtname);

        txtcant = new JTextField();
        txtcant.setBounds(130,50,180,20);
        txtcant.setVisible(true);
        this.add(txtcant);

        txtunit = new JTextField();
        txtunit.setBounds(130,80,180,20);
        txtunit.setVisible(true);
        this.add(txtunit);

        Agregar = new JButton("Agregar");
        Agregar.setBounds(120, 150, 100, 30);
        Agregar.setVisible(true);
        Agregar.addActionListener(this);
        this.add(Agregar);

        this.setTitle("Agregar Ingrediente");
        this.setSize(350, 300);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        IdProd = Id;
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            name = txtname.getText();
            unit = txtunit.getText();
            cant = Integer.parseInt(txtcant.getText());
            Main.AgregarIngredienteI(IdProd, name, cant, unit);
            Salir();
            EditarProductos EP = new EditarProductos(IdProd);

    }

    public void Salir(){
        this.dispose();
    }

    public static ArrayList<Ingredientes> ingredientesTemp  = new ArrayList<>();
    public static  ArrayList addIngre(){
        ArrayList<Ingredientes> ingrediente = new ArrayList<>();
        for (int i =0; i<ingredientesTemp.size();i++){

            ingrediente.add(ingredientesTemp.get(i));
        }
        ingredientesTemp.clear();
        return ingrediente;
    }
}

