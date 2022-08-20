package Proyecto_ventas;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class administrador extends JFrame {
    
    

    JTabbedPane pestañas = new JTabbedPane();
    
    JPanel vendedores = new JPanel();
    JPanel clientes = new JPanel();
    JPanel productos = new JPanel();

    private void inicio() {
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            String[] a={"Salir","Cerrar Sesion","Cancelar"} ;
            int b=JOptionPane.showOptionDialog(null,"¿Que deseas hacer?","Administrador",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,a,a[0]);
                switch (b) {
                    case 0:
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        break;
                    case 1:
                        login l = new login();
                        l.ejecutar();
                        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        break;
                    case 2:
                        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                        break;
                    default:
                        break;
                }
            };
        });
        
        
        
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

    

}
