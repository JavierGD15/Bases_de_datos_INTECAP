
package Proyecto_ventas;

import com.mycompany.bases_ejemplo.Bases_ejemplo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame{
    JPanel p1 = new JPanel();
    JTextField t1 = new JTextField();
    JPasswordField t2 = new JPasswordField();
    
    //metodos
    private void inicio(){
    
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(50, 175, 400, 400);
        setVisible(true);
        p1.setLayout(null);
        add(p1);
        
        JLabel l1 = new JLabel("Nombre:");
        l1.setBounds(50, 75, 80, 40);
        p1.add(l1);
        
        t1.setBounds(150, 79, 100, 30);
        p1.add(t1);
        
        JLabel l2 = new JLabel("Contraseña:");
        l2.setBounds(50, 175, 80, 40);
        p1.add(l2);
        
        t2.setBounds(150, 179, 100, 30);
        p1.add(t2);
        
        JButton b1 = new JButton("Ingresar");
        b1.setBounds(140, 250, 100, 50);
        p1.add(b1);
        
        ActionListener verificar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                    VendedoresDAO vd = new VendedoresDAO();
                int respuesta = vd.filtro(t1.getText(), t2.getText());
                
                switch (respuesta) {
                    case 1:
                        administrador ad = new administrador();
                        ad.ejecutar();
                        dispose();
                        break;
                    case 0:
                        vendedor vn = new vendedor();
                        vn.inicio();
                        dispose();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Datos incorrectos");
                        break;
                }
            
            }
        };

        b1.addActionListener(verificar);
    
    }
    
    
    public void ejecutar(){
    inicio();
    
    }
    
    
    
    public static void main(String[] args) {
        login l = new login();
        l.ejecutar();
    }
    
}
