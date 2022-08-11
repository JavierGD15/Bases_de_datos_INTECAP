package Proyecto_ventas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VentasDAO {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();

    public void insertar(int no_factura, int nit, String nombre, String fecha, double total) {

        String sql = "insert into compras(No_Factura,NIT,Nombre,Fecha,Total) values (?,?,?,?,?)";
        try {
            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, no_factura);
            ps.setInt(2, nit);
            ps.setString(3, nombre);
            ps.setString(4, fecha);
            ps.setDouble(5, total);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
