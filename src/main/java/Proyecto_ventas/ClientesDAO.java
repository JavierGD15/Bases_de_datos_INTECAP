/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_ventas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author javie
 */
public class ClientesDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();

    public int filtro(String nombre, int nit, String correo, String genero) {

        String sql = "select * from clientes where nombre = '" + nombre + "'" + " or nit = " + "'" + nit + "'" + " or correo = " + "'" + correo + "'" +" or genero = " + "'" + genero + "'" +";";
        try {
            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(7);
            }

        } catch (Exception e) {

        }

        return -1;
    }

}
