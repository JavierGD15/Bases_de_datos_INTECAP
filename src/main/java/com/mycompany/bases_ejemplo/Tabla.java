package com.mycompany.bases_ejemplo;

import java.awt.Color;
import javax.swing.*;

public class Tabla extends JFrame {

    JTable table = new JTable();
    JPanel p1 = new JPanel();
    JScrollPane sp = new JScrollPane();

    public void inicio() {
        setTitle("Tabla");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(300, 200, 600, 500);
        setVisible(true);
        
        
        p1.setBackground(Color.YELLOW);
        p1.setLayout(null);
        add(p1);

    }
    
    public void  tabla (){
    
        String [] columnas = {"carnet","nombre","telefono","estado"};
        Bases_ejemplo be = new Bases_ejemplo();
        table = new JTable(be.listar(),columnas);
        sp = new JScrollPane(table);
        sp.setSize(500, 400);
        sp.setLocation(25, 50);
        sp.setVisible(true);
        p1.add(sp);
        String fecha = "2020-01-15";
    
    
    }
    
    public static void main(String[] args) {
        Tabla t = new Tabla();
        t.inicio();
        t.tabla();
    }
}
