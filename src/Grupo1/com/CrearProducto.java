package Grupo1.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CrearProducto extends CRUD_Productos {
    JFrame ventanacrear,ventanaingrediente;
    JPanel panelcrear,panelingrediente;
    JButton btnregistro, btnatras,btningredientes;
    JLabel lblnombreproducto, lblidproducto, lblcostoproducto, lblprecioproducto, lbldescripcionprod, lblingredienteproducto,lblcantidad,lblunidad,lblnombre;
    JTextField txtnombre,txtidproducto, txtcosto,txtprecio, txtdescripcion, txtingredientes,txtcantidad,txtunidad;
    public Menu menu;
    public CRUD_Productos producto;
    //Variables utilizadas para guardas los datos ingresados en los jtextfield
    public String nombre,descripcion,name,units;
    public int id,costo,precio,quantity;



    public CrearProducto(){
        // Creo la venta para registrar un nuevo usuario
        ventanacrear = new JFrame("Registrar Producto");

        ventanacrear.setSize(380,300);
        ventanacrear.setLayout(null);
        ventanacrear.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanacrear.setLocationRelativeTo(null);
        //Creo el panel y lo agrego a la ventana
        panelcrear = new JPanel();
        panelcrear.setLayout(null);
        panelcrear.setSize(380,300);
        panelcrear.setVisible(true);
        panelcrear.setBackground(Color.GRAY);
        ventanacrear.add(panelcrear);
        this.Componentes();
        panelcrear.repaint();
        ventanacrear.setVisible(true);
        //Pasar los datos a las variables de los arreglos para no perder los datos entre las ventanas

    }
    public void Componentes(){
        //Defino los label y se agrega al panel
        lblidproducto = new JLabel("ID del Producto");
        lblidproducto.setBounds(10,20,150,20);
        lblidproducto.setVisible(true);
        lblidproducto.setLayout(null);
        panelcrear.add(lblidproducto);

        lblnombreproducto = new JLabel ("Nombre del Producto");
        lblnombreproducto.setBounds(10,50,150,20);
        lblnombreproducto.setVisible(true);
        lblnombreproducto.setLayout(null);
        panelcrear.add(lblnombreproducto);


        lblcostoproducto = new JLabel("Costo del Producto");
        lblcostoproducto.setBounds(10,80,150,20);
        lblcostoproducto.setVisible(true);
        lblcostoproducto.setLayout(null);
        panelcrear.add(lblcostoproducto);

        lblprecioproducto = new JLabel("Precio del Producto");
        lblprecioproducto.setBounds(10,110,150,20);
        lblprecioproducto.setVisible(true);
        lblprecioproducto.setLayout(null);
        panelcrear.add(lblprecioproducto);

        lbldescripcionprod = new JLabel("Descripción del Producto");
        lbldescripcionprod.setBounds(10,140,150,20);
        lbldescripcionprod.setVisible(true);
        lbldescripcionprod.setLayout(null);
        panelcrear.add(lbldescripcionprod);

        lblingredienteproducto = new JLabel("Ingredientes del Producto");
        lblingredienteproducto.setBounds(10,170,150,20);
        lblingredienteproducto.setVisible(true);
        lblingredienteproducto.setLayout(null);
        panelcrear.add(lblingredienteproducto);

        //Defino los textfield y los agrego al panel

        txtidproducto = new JTextField("");
        txtidproducto.setBounds(160,20,180,20);
        txtidproducto.setVisible(true);
        panelcrear.add(txtidproducto);

        txtnombre = new JTextField("");
        txtnombre.setBounds(160,50,180,20);
        txtnombre.setVisible(true);
        panelcrear.add(txtnombre);

        txtcosto = new JTextField("");
        txtcosto.setBounds(160,80,180,20);
        txtcosto.setVisible(true);
        panelcrear.add(txtcosto);

        txtprecio = new JTextField("");
        txtprecio.setBounds(160,110,180,20);
        txtprecio.setVisible(true);
        panelcrear.add(txtprecio);

        txtdescripcion = new JTextField("");
        txtdescripcion.setBounds(160,140,180,20);
        txtdescripcion.setVisible(true);
        panelcrear.add(txtdescripcion);

        btningredientes = new JButton("Agregar Ingredientes");
        btningredientes.setBounds(160,170,180,20);
        btningredientes.setVisible(true);
        panelcrear.add(btningredientes);
        //Accion del boton para agregar los ingredientes al producto
        btningredientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ingredientes();
            }
        });

        //Creo boton de registro y lo  agrego al panel
        btnregistro = new JButton ("Registrar");
        btnregistro.setBounds(200,220,100,20);
        btnregistro.setVisible(true);
        panelcrear.add(btnregistro);

        //Acciones del boton registro
        btnregistro.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {

                id = Integer.parseInt(txtidproducto.getText());
                nombre = txtnombre.getText();
                costo = Integer.parseInt(txtcosto.getText());
                precio = Integer.parseInt((txtprecio.getText()));
                descripcion = txtdescripcion.getText();

                Main.AgregaProducto(id,nombre,descripcion,costo,precio,addIngre());

                CrearProducto.super.dispose();

                CRUD_Productos up= new CRUD_Productos();

                ventanacrear.setVisible(false);

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
    public void Ingredientes (){
        ventanaingrediente = new JFrame("Agregar Ingredientes");
        ventanaingrediente.setVisible(true);
        ventanaingrediente.setSize(380,300);
        ventanaingrediente.setLayout(null);
        ventanaingrediente.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        ventanaingrediente.setLocationRelativeTo(null);
        //Creo el panel y lo agrego a la ventana
        panelingrediente = new JPanel();
        panelingrediente.setLayout(null);
        panelingrediente.setSize(380,300);
        panelingrediente.setVisible(true);
        panelingrediente.setBackground(Color.GRAY);
        ventanaingrediente.add(panelingrediente);
        this.ComponentesIngrediente();
        panelingrediente.repaint();
    }
    public void ComponentesIngrediente(){
        lblnombre = new JLabel("Nombre del Ingrediente");
        lblnombre.setBounds(10,20,150,20);
        lblnombre.setVisible(true);
        lblnombre.setLayout(null);
        panelingrediente.add(lblnombre);

        lblcantidad = new JLabel ("Cantidad");
        lblcantidad.setBounds(10,50,150,20);
        lblcantidad.setVisible(true);
        lblcantidad.setLayout(null);
        panelingrediente.add(lblcantidad);

        lblunidad = new JLabel("Unidades");
        lblunidad.setBounds(10,80,150,20);
        lblunidad.setVisible(true);
        lblunidad.setLayout(null);
        panelingrediente.add(lblunidad);

        txtingredientes = new JTextField("");
        txtingredientes.setBounds(160,20,180,20);
        txtingredientes.setVisible(true);
        panelingrediente.add(txtingredientes);

        txtcantidad = new JTextField("");
        txtcantidad.setBounds(160,50,180,20);
        txtcantidad.setVisible(true);
        panelingrediente.add(txtcantidad);

        txtunidad = new JTextField("");
        txtunidad.setBounds(160,80,180,20);
        txtunidad.setVisible(true);
        panelingrediente.add(txtunidad);

        btningredientes = new JButton("Agregar");
        btningredientes.setBounds(160,170,180,20);
        btningredientes.setVisible(true);
        panelingrediente.add(btningredientes);
        //Accion del boton para agregar los ingredientes al producto


        btningredientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             name = txtingredientes.getText();
             quantity = Integer.parseInt(txtcantidad.getText());
             units = txtunidad.getText();
             Ingredientes nuevo= new Ingredientes(name,quantity,units);
            ingredientesTemp.add(nuevo);



             ventanaingrediente.dispose();


            }
        });
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
