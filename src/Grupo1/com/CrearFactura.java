package Grupo1.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class CrearFactura extends CRUD_Facturas {
    JFrame ventanacrear,ventanafactura;
    JPanel panelcrear,panelfactura;
    JButton btnregistro, btnatras,btnproductos,btnagregarfactura;
    JLabel lblidfactura,lblnombrecliente,lblfecha,lblproducto,lblmonto,lblprecio,lblnombre;
    JTextField txtfactura,txtcliente,txtfecha,txtproducto, txtmonto,txtnombre,txtprecio;
    public Menu menu;
    public CRUD_Facturas facturas;
    //Variables utilizadas para guardas los datos ingresados en los jtextfield
    public String nombreproducto,fecha;
    public int precio,idfactura,idcliente;


    public CrearFactura() {
        // Creo la venta para registrar un nuevo usuario
        ventanacrear = new JFrame("Registrar Factura");
        ventanacrear.setVisible(true);
        ventanacrear.setSize(350, 300);
        ventanacrear.setLayout(null);
        ventanacrear.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        ventanacrear.setLocationRelativeTo(null);
        //Creo el panel y lo agrego a la ventana
        panelcrear = new JPanel();
        panelcrear.setLayout(null);
        panelcrear.setSize(350, 300);
        panelcrear.setVisible(true);
        ventanacrear.add(panelcrear);
        this.Componentes();
        panelcrear.repaint();
        //Pasar los datos a las variables de los arreglos para no perder los datos entre las ventanas

    }

    public void Componentes() {
        //Defino los label y se agrega al panel
        lblidfactura = new JLabel("ID de la Factura");
        lblidfactura.setBounds(10, 20, 150, 20);
        lblidfactura.setVisible(true);
        lblidfactura.setLayout(null);
        panelcrear.add(lblidfactura);

        lblnombrecliente = new JLabel("ID del Cliente");
        lblnombrecliente.setBounds(10, 50, 150, 20);
        lblnombrecliente.setVisible(true);
        lblnombrecliente.setLayout(null);
        panelcrear.add(lblnombrecliente);

        lblfecha = new JLabel("Fecha");
        lblfecha.setBounds(10, 80, 150, 20);
        lblfecha.setVisible(true);
        lblfecha.setLayout(null);
        panelcrear.add(lblfecha);

        lblfecha = new JLabel("Producto");
        lblfecha.setBounds(10, 110, 150, 20);
        lblfecha.setVisible(true);
        lblfecha.setLayout(null);
        panelcrear.add(lblfecha);
        //Defino los textfield y los agrego al panel
        txtfactura = new JTextField("");
        txtfactura.setBounds(140, 20, 180, 20);
        txtfactura.setVisible(true);
        panelcrear.add(txtfactura);

        txtcliente = new JTextField("");
        txtcliente.setBounds(140, 50, 180, 20);
        txtcliente.setVisible(true);
        panelcrear.add(txtcliente);

        txtfecha = new JTextField("");
        txtfecha.setBounds(140, 80, 180, 20);
        txtfecha.setVisible(true);
        panelcrear.add(txtfecha);

        btnagregarfactura = new JButton("Agregar Producto");
        btnagregarfactura.setBounds(140, 110, 180, 20);
        btnagregarfactura.setVisible(true);
        panelcrear.add(btnagregarfactura);

        btnagregarfactura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductosFactura();
            }
        });

        //Creo boton de registro y lo  agrego al panel
        btnregistro = new JButton("Registrar");
        btnregistro.setBounds(200, 220, 100, 20);
        btnregistro.setVisible(true);
        panelcrear.add(btnregistro);


        //Acciones del boton registro
        btnregistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                idfactura = Integer.parseInt(txtfactura.getText());
                idcliente = Integer.parseInt(txtcliente.getText());
                fecha = txtfecha.getText();
                Main.AgregaFactura(idfactura, idcliente, fecha, addFactura());
                CrearFactura.super.dispose();
                CRUD_Facturas uc = new CRUD_Facturas();
                ventanacrear.setVisible(false);
            }
        });
        //Botón para regresar al Login
        btnatras = new JButton("Atras");
        btnatras.setBounds(10, 220, 120, 20);
        btnatras.setVisible(true);
        panelcrear.add(btnatras);
        //Acciones del boton regresar
        btnatras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                ventanacrear.setVisible(false);
            }
        });
    }

    public void ProductosFactura() {
        ventanafactura = new JFrame("Agregar Ingredientes");
        ventanafactura.setVisible(true);
        ventanafactura.setSize(380, 300);
        ventanafactura.setLayout(null);
        ventanafactura.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        ventanafactura.setLocationRelativeTo(null);
        //Creo el panel y lo agrego a la ventana
        panelfactura = new JPanel();
        panelfactura.setLayout(null);
        panelfactura.setSize(380, 300);
        panelfactura.setVisible(true);
        ventanafactura.add(panelfactura);
        this.ComponentesProductos();
        panelfactura.repaint();
    }

    public void ComponentesProductos() {
        lblnombre = new JLabel("Nombre del Producto");
        lblnombre.setBounds(10, 20, 150, 20);
        lblnombre.setVisible(true);
        lblnombre.setLayout(null);
        panelfactura.add(lblnombre);

        lblprecio = new JLabel("Precio del Producto");
        lblprecio.setBounds(10, 50, 150, 20);
        lblprecio.setVisible(true);
        lblprecio.setLayout(null);
        panelfactura.add(lblprecio);

        txtnombre = new JTextField("");
        txtnombre.setBounds(160, 20, 180, 20);
        txtnombre.setVisible(true);
        panelfactura.add(txtnombre);

        txtprecio = new JTextField("");
        txtprecio.setBounds(160, 50, 180, 20);
        txtprecio.setVisible(true);
        panelfactura.add(txtprecio);


        btnproductos = new JButton("Agregar");
        btnproductos.setBounds(160, 170, 180, 20);
        btnproductos.setVisible(true);
        panelfactura.add(btnproductos);
        //Accion del boton para agregar los ingredientes al producto
        btnproductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreproducto = txtnombre.getText();
                precio = Integer.parseInt(txtprecio.getText());
                ProductoF nuevo= new ProductoF(nombreproducto,precio);
                facturasTemp.add(nuevo);

                ventanafactura.setVisible(false);

            }
        });
    }
    public static ArrayList<ProductoF> facturasTemp  = new ArrayList<>();
    public static  ArrayList addFactura(){
        ArrayList<ProductoF> factura = new ArrayList<>();
        for (int i =0; i<facturasTemp.size();i++){

            factura.add(facturasTemp.get(i));

        }
        facturasTemp.clear();

        return factura;
    }

}



