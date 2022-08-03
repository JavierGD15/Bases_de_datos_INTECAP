package Proyecto_ventas;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class administrador extends JFrame {

    JTabbedPane pestañas = new JTabbedPane();
    
    JPanel vendedores = new JPanel();
    JPanel clientes = new JPanel();
    JPanel productos = new JPanel();

    private void inicio() {
        setTitle("Administrador");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(50, 175, 900, 800);
        setVisible(true);

        
        productos.setLayout(null);
        clientes.setLayout(null);
        vendedores.setLayout(null);
        
        
        sucursales_vistas sv = new sucursales_vistas();
        sv.ejecutar();
        
        
        pestañas.addTab("Sucursales", sv.sucursales);
        pestañas.addTab("Productos", productos);
        pestañas.addTab("Clientes", clientes);
        pestañas.addTab("Vendedores", vendedores);
        
        add(pestañas);
        

    }

    public void ejecutar() {

        inicio();
    }

    public static void main(String[] args) {
        administrador ad = new administrador();
        ad.ejecutar();
    }

}
