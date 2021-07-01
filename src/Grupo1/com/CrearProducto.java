package Grupo1.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearProducto {
    JFrame ventanacrear;
    JPanel panelcrear;
    JButton btnregistro, btnatras;
    JLabel lblnombreproducto, lblidproducto, lblcostoproducto, lblprecioproducto, lbldescripcionprod, lblingredienteproducto;
    JTextField txtnombre,txtidproducto, txtcosto,txtprecio, txtdescripcion, txtingredientes;
    public Menu menu;
    public CRUD_Productos producto;
    //Variables utilizadas para guardas los datos ingresados en los jtextfield
    public String nombre, username, password,confpassword;
    // Arreglos con los que trabajaremos dentro de esta ventana.
    public String[] arreglo;
    public int contador;
    //public static NewUser[] usuarios;


    public CrearProducto(){
        // Creo la venta para registrar un nuevo usuario
        ventanacrear = new JFrame("Registrar Producto");
        ventanacrear.setVisible(true);
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

        txtingredientes = new JTextField("");
        txtingredientes.setBounds(160,170,180,20);
        txtingredientes.setVisible(true);
        panelcrear.add(txtingredientes);

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
                //nombre = txtnombre.getText();
               // password = txtcontraseña.getText();
                //confpassword = txtconfcontra.getText();
                //usuarios[contador] = new NewUser(username,nombre,password,confpassword);
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
}
