package Grupo1.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearFactura {
    JFrame ventanacrear;
    JPanel panelcrear;
    JButton btnregistro, btnatras;
    JLabel lblidfactura,lblnombrecliente,lblfecha,lblproducto,lblmonto;
    JTextField txtfactura,txtcliente,txtfecha,txtproducto, txtmonto;
    public Menu menu;
    public CRUD_Facturas facturas;
    //Variables utilizadas para guardas los datos ingresados en los jtextfield
    public String nombre, username, password,confpassword;
    // Arreglos con los que trabajaremos dentro de esta ventana.
    public String[] arreglo;
    public int contador;
    //public static NewUser[] usuarios;


    public CrearFactura(){
        // Creo la venta para registrar un nuevo usuario
        ventanacrear = new JFrame("Registrar Factura");
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
        this.Componentes();
        panelcrear.repaint();
        //Pasar los datos a las variables de los arreglos para no perder los datos entre las ventanas

    }
    public void Componentes(){
        //Defino los label y se agrega al panel
        lblidfactura = new JLabel("ID de la Factura");
        lblidfactura.setBounds(10,20,150,20);
        lblidfactura.setVisible(true);
        lblidfactura.setLayout(null);
        panelcrear.add(lblidfactura);

        lblnombrecliente = new JLabel ("Nombre del Cliente");
        lblnombrecliente.setBounds(10,50,150,20);
        lblnombrecliente.setVisible(true);
        lblnombrecliente.setLayout(null);
        panelcrear.add(lblnombrecliente);

        lblfecha = new JLabel("Fecha");
        lblfecha.setBounds(10,80,150,20);
        lblfecha.setVisible(true);
        lblfecha.setLayout(null);
        panelcrear.add(lblfecha);

        lblproducto = new JLabel("Producto");
        lblproducto.setBounds(10,110,150,20);
        lblproducto.setVisible(true);
        lblproducto.setLayout(null);
        panelcrear.add(lblproducto);

        lblmonto = new JLabel("Monto");
        lblmonto.setBounds(10,140,150,20);
        lblmonto.setVisible(true);
        lblmonto.setLayout(null);
        panelcrear.add(lblmonto);


        //Defino los textfield y los agrego al panel
        txtfactura = new JTextField("");
        txtfactura.setBounds(140,20,180,20);
        txtfactura.setVisible(true);
        panelcrear.add(txtfactura);

        txtcliente = new JTextField("");
        txtcliente.setBounds(140,50,180,20);
        txtcliente.setVisible(true);
        panelcrear.add(txtcliente);

        txtfecha = new JTextField("");
        txtfecha.setBounds(140,80,180,20);
        txtfecha.setVisible(true);
        panelcrear.add(txtfecha);

        txtproducto = new JTextField("");
        txtproducto.setBounds(140,110,180,20);
        txtproducto.setVisible(true);
        panelcrear.add(txtproducto);

        txtmonto = new JTextField("");
        txtmonto.setBounds(140,140,180,20);
        txtmonto.setVisible(true);
        panelcrear.add(txtmonto);

        //Creo boton de registro y lo  agrego al panel
        btnregistro = new JButton ("Registrar");
        btnregistro.setBounds(200,220,100,20);
        btnregistro.setVisible(true);
        panelcrear.add(btnregistro);

        //Acciones del boton registro
        btnregistro.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {

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

