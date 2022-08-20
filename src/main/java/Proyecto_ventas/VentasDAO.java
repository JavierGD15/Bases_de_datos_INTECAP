package Proyecto_ventas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VentasDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Object datos[][];

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

    public int filtro() {
        String sql = "select * from compras;";
        int x = 1;
        try {

            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                x++;
            }

        } catch (Exception e) {

        }

        return x;

    }

    public Object[][] filtro_ventas(int factura, int nit, String nombre, String fecha) {

        String sql = "select * from compras where No_Factura = " +"'"+ factura + "'" + " or NIT = " + "'" + nit + "'" + " or Nombre = '" +  nombre + "'" + " or Fecha = " + "'" + fecha + "'" + ";";
        try {
            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int x = 0;
            while (rs.next()) {
                x++;
            }
            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            datos = new Object[x][5];
            x = 0;
            while (rs.next()) {
                datos[x][0] = rs.getInt(1);
                datos[x][1] = rs.getInt(2);
                datos[x][2] = rs.getString(3);
                datos[x][3] = rs.getString(4);
                datos[x][4] = rs.getInt(5);
                x++;
                
            }
            if (datos[0][0] == null) {
                return null;
            }else{
            return datos;}

        } catch (Exception e) {

        }

        return null;
    }

    public Object[][] listar_tabla() {
        String instruccion = "select * from compras";
        try {
            int x = 0;
            con = conectar.Conectar();
            ps = con.prepareStatement(instruccion);
            rs = ps.executeQuery();
            while (rs.next()) {
                x++;
            }

            datos = new Object[x][5];
            x = 0;
            con = conectar.Conectar();
            ps = con.prepareStatement(instruccion);
            rs = ps.executeQuery();
            while (rs.next()) {
                datos[x][0] = rs.getInt(1);
                datos[x][1] = rs.getInt(2);
                datos[x][2] = rs.getString(3);
                datos[x][3] = rs.getDate(4);
                datos[x][4] = rs.getDouble(5);
                x++;
            }

        } catch (Exception e) {
        }

        return datos;

    }
    
   

}
