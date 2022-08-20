package Proyecto_ventas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class vendedor extends JFrame {

    JTabbedPane pestañas = new JTabbedPane();

    public void inicio() {
        
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
    
        

        setTitle("Ventas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(50, 175, 900, 800);
        setVisible(true);

        Nueva_venta nv = new Nueva_venta();
        nv.ejecutar();

        ventas_realizadas vr = new ventas_realizadas();
        vr.ejecutar();

        pestañas.addTab("Nueva venta", nv.general);
        pestañas.addTab("Productos", vr.ventas_general);
        add(pestañas);

        
        
    }
    

}
