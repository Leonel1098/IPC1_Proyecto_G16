package Grupo1.com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarIngrediente extends JFrame implements ActionListener {
    JButton Agregar;
    JLabel lblname, lblcant, lblunit;
    JTextField txtname, txtcant, txtunit;
    String name, unit;
    int cant;
    public static int IdProd;
    public static String nam;

    public EditarIngrediente(int Id, String nm){
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

        Agregar = new JButton("Actualizar");
        Agregar.setBounds(120, 130, 100, 30);
        Agregar.setVisible(true);
        Agregar.addActionListener(this);
        this.add(Agregar);

        this.setTitle("Editar Ingrediente");
        this.setSize(350, 210);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        IdProd = Id;
        nam = nm;

        for (int i=0; i<Main.products.size(); i++){
            if (Id == Main.products.get(i).getId()) {
                for (int j = 0; j < Main.products.get(i).getIngredients().size(); j++) {
                    if (Main.products.get(i).getIngredients().get(j).getName().equals(nm)){
                        txtname.setText(Main.products.get(i).getIngredients().get(j).getName());
                        txtcant.setText(String.valueOf(Main.products.get(i).getIngredients().get(j).getQuantity()));
                        txtunit.setText(Main.products.get(i).getIngredients().get(j).getUnits());
                    }
                }
            }
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
    name = txtname.getText();
    cant = Integer.parseInt(txtcant.getText());
    unit = txtunit.getText();
    Main.EditarIngrediente(nam,name,cant,unit,IdProd);
    this.dispose();
    EditarProductos EP = new EditarProductos(IdProd);
    }
}
