package Grupo1.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearCliente {
    JFrame ventanacrear;
    JPanel panelcrear;
    JButton btnregistro, btnatras;
    JLabel lblidcliente,lblnombrecliente,lblciudadcliente,lblnitcliente,lbltelefonocliente;
    JTextField txtusuario,txtnombre,txtcontraseña,txtconfcontra, txttelefono;
    public Login login;
    public CRUD_Clientes clientes;
    //Variables utilizadas para guardas los datos ingresados en los jtextfield
    public String nombre, direccion, phone,nit;
    public int IdCl;

    public CrearCliente(){
        // Creo la venta para registrar un nuevo usuario
        ventanacrear = new JFrame("Registrar Usuario");
        ventanacrear.setVisible(true);
        ventanacrear.setSize(350,270);
        ventanacrear.setLayout(null);
        ventanacrear.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        ventanacrear.setLocationRelativeTo(null);
        //Creo el panel y lo agrego a la ventana
        panelcrear = new JPanel();
        panelcrear.setLayout(null);
        panelcrear.setSize(350,300);
        panelcrear.setVisible(true);
        ventanacrear.add(panelcrear);
        this.Componentes();
        panelcrear.repaint();
        //Pasar los datos a las variables de los arreglos para no perder los datos entre las ventanas

    }
    public void Componentes(){
        //Defino los label y se agrega al panel
        lblidcliente = new JLabel("ID del Cliente");
        lblidcliente.setBounds(10,20,150,20);
        lblidcliente.setVisible(true);
        lblidcliente.setLayout(null);
        panelcrear.add(lblidcliente);

        lblnombrecliente = new JLabel ("Nombre del Cliente");
        lblnombrecliente.setBounds(10,50,150,20);
        lblnombrecliente.setVisible(true);
        lblnombrecliente.setLayout(null);
        panelcrear.add(lblnombrecliente);

        lblciudadcliente = new JLabel("Ciudad del Cliente");
        lblciudadcliente.setBounds(10,80,150,20);
        lblciudadcliente.setVisible(true);
        lblciudadcliente.setLayout(null);
        panelcrear.add(lblciudadcliente);

        lblnitcliente = new JLabel("Nit del Cliente");
        lblnitcliente.setBounds(10,110,150,20);
        lblnitcliente.setVisible(true);
        lblnitcliente.setLayout(null);
        panelcrear.add(lblnitcliente);

        lbltelefonocliente = new JLabel("Telefóno del Cliente");
        lbltelefonocliente.setBounds(10,140,150,20);
        lbltelefonocliente.setVisible(true);
        lbltelefonocliente.setLayout(null);
        panelcrear.add(lbltelefonocliente);


        //Defino los textfield y los agrego al panel
        txtusuario = new JTextField();
        txtusuario.setBounds(140,20,180,20);
        txtusuario.setVisible(true);
        panelcrear.add(txtusuario);

        txtnombre = new JTextField();
        txtnombre.setBounds(140,50,180,20);
        txtnombre.setVisible(true);
        panelcrear.add(txtnombre);

        txtcontraseña = new JTextField();
        txtcontraseña.setBounds(140,80,180,20);
        txtcontraseña.setVisible(true);
        panelcrear.add(txtcontraseña);

        txtconfcontra = new JTextField();
        txtconfcontra.setBounds(140,110,180,20);
        txtconfcontra.setVisible(true);
        panelcrear.add(txtconfcontra);

        txttelefono = new JTextField();
        txttelefono.setBounds(140,140,180,20);
        txttelefono.setVisible(true);
        panelcrear.add(txttelefono);

        //Creo boton de registro y lo  agrego al panel
        btnregistro = new JButton ("Registrar");
        btnregistro.setBounds(190,200,120,20);
        btnregistro.setVisible(true);
        panelcrear.add(btnregistro);

        //Acciones del boton registro
        btnregistro.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                IdCl = Integer.parseInt(txtusuario.getText());
                nombre = txtnombre.getText();
                direccion = txtcontraseña.getText();
                phone = txtconfcontra.getText();
                nit = txttelefono.getText();
                boolean flag =Main.idCliente(IdCl);
                if (flag){
                    Main.AgregaCliente(IdCl, nombre, direccion,nit, phone);
                    ventanacrear.setVisible(false);
                    CRUD_Clientes CC = new CRUD_Clientes();
                }else{

                JOptionPane.showMessageDialog(null, "El id Ya Existe Cambiarlo ");
                }
            }
        });
        //Botón para regresar al Login
        btnatras = new JButton ("Atras");
        btnatras.setBounds(20,200,120,20);
        btnatras.setVisible(true);
        panelcrear.add(btnatras);
        //Acciones del boton regresar
        btnatras.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {

                CRUD_Clientes CC = new CRUD_Clientes();
                ventanacrear.setVisible(false);
            }
        });
    }
}
