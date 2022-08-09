
package Proyecto_ventas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Nueva_venta {
    
    JPanel general = new JPanel();
    JPanel filtro = new JPanel();
    JPanel ventas = new JPanel();
    
    //cajas filtro
    JTextField nombre = new JTextField();
    JTextField nit = new JTextField();
    JTextField correo = new JTextField();
    JTextField genero = new JTextField();
    
    String nombres [] ={"hola"};
    JComboBox resultado;
    
    
    public void filtro_panel(){
    general.setBounds(50, 175, 900, 800);
    general.setLayout(null);
    filtro.setBackground(Color.WHITE);
    filtro.setBounds(50, 50, 800, 200);
    filtro.setLayout(null);
    general.add(filtro);
    
        JLabel l1 = new JLabel("Nombre");
        l1.setBounds(140, 20, 75, 30);
        
        JLabel l2 = new JLabel("NIT");
        l2.setBounds(420, 20, 75, 30);
        
        JLabel l3 = new JLabel("Correo");
        l3.setBounds(140, 100, 75, 30);
        
        JLabel l4 = new JLabel("Género");
        l4.setBounds(420, 100, 75, 30);
        
        nombre.setBounds(225, 20, 160, 30);
        nit.setBounds(520, 20, 160, 30);
        
        correo.setBounds(225, 100, 160, 30);
        genero.setBounds(520, 100, 160, 30);
        
        JButton b1 = new JButton("Buscar");
        b1.setBounds(710, 30, 80, 80);
        filtro.add(b1);
        
        ActionListener verificar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                ClientesDAO cd = new ClientesDAO();
                cd.filtro(nombre.getText(), Integer.parseInt(nit.getText()), correo.getText(), genero.getText());
            
            }
        };

        b1.addActionListener(verificar);
        
    
        filtro.add(l1);
        filtro.add(l2);
        filtro.add(l3);
        filtro.add(l4);
        
        filtro.add(nombre);
        filtro.add(nit);
        filtro.add(correo);
        filtro.add(genero);
        
        JLabel l5 = new JLabel("Cliente: ");
        l5.setBounds(140, 150, 75, 35);
        filtro.add(l5);
        
        resultado = new JComboBox(nombres);
        resultado.setBounds(225, 150, 280, 40);
        filtro.add(resultado);
        
        JButton b2 = new JButton("Nuevo Cliente");
        b1.setBounds(520, 150, 160, 40);
        filtro.add(b2);
    
    }
    
}
