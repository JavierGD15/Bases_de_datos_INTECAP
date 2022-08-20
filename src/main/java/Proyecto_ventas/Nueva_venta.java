package Proyecto_ventas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Nueva_venta {

    //global
    int x = 0;
    double cantidad = 0;
    JLabel total = new JLabel();

    JPanel general = new JPanel();
    JPanel filtro = new JPanel();
    JPanel ventas = new JPanel();

    //cajas filtro
    JTextField nombre = new JTextField();
    JTextField nit = new JTextField();
    JTextField correo = new JTextField();
    JTextField genero = new JTextField();

    JTextField text6 = new JTextField();
    JTextField text7 = new JTextField();

    String nombres[] = {"No hay resultados"};
    JComboBox resultado;
    Object productos[][] = new Object[10][5];

    JTable tabla;
    JScrollPane sp;

    public void filtro_panel() {
        
        
        
        
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
        b1.setBounds(550, 150, 80, 30);
        filtro.add(b1);

        ActionListener verificar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombres_uso;
                if (nombre.getText().trim().equals("")) {
                    nombres_uso = null;
                } else {

                    nombres_uso = nombre.getText().trim();

                }
                int nit_uso;
                if (nit.getText().trim().equals("")) {
                    nit_uso = 0;
                } else {

                    nit_uso = Integer.parseInt(nit.getText().trim());

                }

                String correo_uso;
                if (correo.getText().trim().equals("")) {
                    correo_uso = null;
                } else {

                    correo_uso = correo.getText().trim();

                }
                String genero_uso;
                if (genero.getText().trim().equals("")) {
                    genero_uso = null;
                } else {

                    genero_uso = genero.getText().trim();

                }

                ClientesDAO cd = new ClientesDAO();
                nombres = cd.filtro(nombres_uso, nit_uso, correo_uso, genero_uso);
                resultado.setVisible(false);
                box();
            }
        };

        b1.addActionListener(verificar);

        JButton b2 = new JButton("Nuevo Cliente");
        b2.setBounds(650, 150, 130, 30);
        filtro.add(b2);

        ActionListener funcion_crear = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crear();
            }
        };

        b2.addActionListener(funcion_crear);

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

    }

    public void vender() {

        ventas.setBackground(Color.WHITE);
        ventas.setBounds(50, 300, 800, 400);
        ventas.setLayout(null);
        general.add(ventas);

        //Etiquetas
        JLabel label4 = new JLabel("Fecha: ");
        label4.setLocation(460, 10);
        label4.setSize(100, 15);
        label4.setFont(new Font("Serig", Font.PLAIN, 15));

        JLabel label = new JLabel();
        label.setBounds(520, 10, 100, 15);
        label.setFont(new Font("Serig", Font.PLAIN, 15));
        Calendar calendar = new GregorianCalendar();
        label.setText("" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH));

        JLabel label1 = new JLabel("No. ");
        label1.setBounds(650, 10, 80, 15);
        label1.setFont(new Font("Serig", Font.PLAIN, 15));
        VentasDAO vd = new VentasDAO();
        int ventas_realizadas = vd.filtro();
        JLabel no_venta = new JLabel(ventas_realizadas + "");
        no_venta.setBounds(700, 10, 100, 15);
        no_venta.setFont(new Font("Serig", Font.PLAIN, 15));

        ventas.add(label);

        ventas.add(label1);

        ventas.add(no_venta);

        ventas.add(label4);

        JLabel label3 = new JLabel("Código: ");
        label3.setBounds(50, 50, 80, 20);
        label3.setFont(new Font("Serig", Font.PLAIN, 15));

        text6.setBounds(120, 50, 150, 20);

        JLabel label5 = new JLabel("Cantidad: ");
        label5.setBounds(300, 50, 80, 15);
        label5.setFont(new Font("Serig", Font.PLAIN, 15));
        text7.setBounds(400, 50, 150, 20);

        JButton agregar = new JButton("Agregar");
        agregar.setBounds(600, 50, 150, 20);

        ActionListener agregar_accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductosDAO pd = new ProductosDAO();
                Object temporal[] = pd.filtro(Integer.parseInt(text6.getText()));

                productos[x][0] = temporal[0];
                productos[x][1] = temporal[1];
                productos[x][2] = Integer.parseInt(text7.getText());
                productos[x][3] = temporal[2];
                productos[x][4] = Integer.parseInt(text7.getText()) * Double.parseDouble(temporal[2].toString());
                x++;
                sp.setVisible(false);
                total.setVisible(false);
                total_etiqueta(Integer.parseInt(text7.getText()) * Double.parseDouble(temporal[2].toString()));

                tabla();
            }
        };

        //Acción del evento
        agregar.addActionListener(agregar_accion);

        ventas.add(agregar);
        ventas.add(label3);
        ventas.add(text6);
        ventas.add(label5);
        ventas.add(text7);

        JButton vender = new JButton("Vender");
        vender.setBackground(Color.GREEN);
        vender.setBounds(50, 320, 300, 30);

        ActionListener vender_accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviar_venta();
            }
        };

        //Acción del evento
        vender.addActionListener(vender_accion);

        ventas.add(vender);

        JLabel l1 = new JLabel("Total");
        l1.setBounds(600, 300, 80, 80);
        ventas.add(l1);

        total_etiqueta(0);

    }

    public void total_etiqueta(double suma) {
        cantidad += suma;

        total.setBounds(650, 330, 123, 30);
        total.setText(cantidad + "");
        total.setVisible(true);
        ventas.add(total);
    }

    private void tabla() {

        String columnas[] = {"Código", "Nombre", "Cantidad", "Precio", "Subtotal"};
        tabla = new JTable(productos, columnas);
        sp = new JScrollPane(tabla);
        sp.setBounds(50, 100, 700, 200);
        ventas.add(sp);
    }

    public void box() {

        resultado = new JComboBox(nombres);

        resultado.setBounds(225, 150, 280, 40);
        filtro.add(resultado);
    }

    private void crear() {

        JFrame frame_sucursal = new JFrame();
        frame_sucursal.setTitle("Nueva Sucursal");
        frame_sucursal.setLocationRelativeTo(null);
        frame_sucursal.setBounds(50, 175, 350, 400);
        frame_sucursal.setVisible(true);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        frame_sucursal.add(p1);

        JLabel l1 = new JLabel("Código");
        l1.setBounds(50, 20, 80, 50);
        p1.add(l1);

        JTextField t1 = new JTextField();
        t1.setBounds(150, 32, 130, 25);
        p1.add(t1);

        JLabel l2 = new JLabel("Nombre");
        l2.setBounds(50, 80, 80, 50);
        p1.add(l2);

        JTextField t2 = new JTextField();
        t2.setBounds(150, 92, 130, 25);
        p1.add(t2);

        JLabel l3 = new JLabel("NIT");
        l3.setBounds(50, 140, 80, 50);
        p1.add(l3);

        JTextField t3 = new JTextField();
        t3.setBounds(150, 152, 130, 25);
        p1.add(t3);

        JLabel l4 = new JLabel("Correo");
        l4.setBounds(50, 200, 80, 50);
        p1.add(l4);

        JTextField t4 = new JTextField();
        t4.setBounds(150, 212, 130, 25);
        p1.add(t4);

        JLabel l5 = new JLabel("Género");
        l5.setBounds(50, 260, 80, 50);
        p1.add(l5);

        JTextField t5 = new JTextField();
        t5.setBounds(150, 272, 130, 25);
        p1.add(t5);

        JButton b1 = new JButton("Guardar");
        b1.setBounds(130, 330, 80, 15);
        p1.add(b1);

        ActionListener guardar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientesDAO cd = new ClientesDAO();
                cd.crear(Integer.parseInt(t1.getText()), t2.getText(), Integer.parseInt(t3.getText()), t4.getText(), t5.getText());
                frame_sucursal.dispose();
            }
        };

        b1.addActionListener(guardar);

    }

    private void enviar_venta() {

        String nombre = resultado.getSelectedItem() + "";

        ClientesDAO cl = new ClientesDAO();
        int nit = cl.filtro_nit(nombre);

        VentasDAO vd = new VentasDAO();
        int factura = vd.filtro();

        //fecha
        Calendar calendar = new GregorianCalendar();
        String fecha = ("" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH));

        vd.insertar(factura, nit, nombre, fecha, cantidad);
        vaciar();

    }

    private void vaciar() {

         JOptionPane.showMessageDialog(null, "Venta realizada");
        //cajas filtro
        nombre.setText("");
        nit.setText("");
        correo.setText("");
        genero.setText("");

        text6.setText("");
        text7.setText("");

        productos = new Object[10][5];
        sp.setVisible(false);
        tabla();

    }

    public void ejecutar() {
        filtro_panel();
        vender();
        box();
        tabla();

    }

}
