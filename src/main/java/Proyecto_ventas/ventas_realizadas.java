/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_ventas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author javie
 */
public class ventas_realizadas {
    
    JPanel ventas_general = new JPanel();
    JTable tabla;
    JScrollPane sp;
    
    private void tabla(){
        String columnas []= {"No_Factura","NIT","Nombre","Fecha","Total"};
        VentasDAO vd = new VentasDAO();
        
        Object filas [][] = vd.listar_tabla();
        
        tabla = new JTable(filas,columnas);
        ventas_general.add(tabla);
    }
}
