
package com.mycompany.bases_ejemplo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class formulario {
    JFrame f = new JFrame();
    JPanel p1 = new JPanel();
    
    
    public void form(){
        f.setTitle("Ejemplo");
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setBounds(50, 175, 400, 400);
        f.setVisible(true);
        
        p1.setBackground(Color.YELLOW);
        p1.setLayout(null);
        f.add(p1);
        
        JLabel l1 = new JLabel("Codigo:");
        l1.setBounds(50, 50, 100, 25);
        p1.add(l1);
        
        JTextField t1 = new JTextField();
        t1.setBounds(150, 50, 100, 25);
        p1.add(t1);
        
        JLabel l2 = new JLabel("Nombre:");
        l2.setBounds(50, 125, 100, 25);
        p1.add(l2);
        
        JTextField t2 = new JTextField();
        t2.setBounds(150, 125, 100, 25);
        p1.add(t2);
        
        JLabel l3 = new JLabel("Lugar:");
        l3.setBounds(50, 200, 100, 25);
        p1.add(l3);
        
        JTextField t3 = new JTextField();
        t3.setBounds(150, 200, 100, 25);
        p1.add(t3);
        
        Calendar calendar = new GregorianCalendar();
        String date =  "" +calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH)+1)  + "-" + calendar.get(Calendar.DAY_OF_MONTH);
        
        JButton b1 = new JButton("Guardar");
        b1.setBounds(125, 325, 100, 25);
        p1.add(b1);
        
        ActionListener guardar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bases_ejemplo base = new Bases_ejemplo();
                base.crear(Integer.parseInt(t1.getText()), t2.getText(), t3.getText(), date);
            }
        };

        b1.addActionListener(guardar);
        
        
        
    }
    
    public static void main(String[] args) {
        formulario f = new formulario();
        f.form();
    }
    
}
