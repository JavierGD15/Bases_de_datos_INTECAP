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
    String nombres[];

    public String[] filtro(String nombre, int nit, String correo, String genero) {

        String sql = "select * from clientes where nombre = '" + nombre + "'" + " or nit = " + "'" + nit + "'" + " or correo = " + "'" + correo + "'" + " or genero = " + "'" + genero + "'" + ";";
        try {
            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int x =0;

            while (rs.next()) {
                x++;
            }
            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            nombres = new String [x];
             x = 0;
            while (rs.next()) {
                nombres[x]= rs.getString(2);
                x++;
            }

        } catch (Exception e) {

        }

        return nombres;
    }
    
    public int filtro_nit(String nombre) {

        String sql = "select * from clientes where nombre = '" + nombre + "'" +" ;";
        try {
            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(3);
            }

        } catch (Exception e) {

        }

        return 0;
    }
    
    
    public void crear(int codigo, String nombre, int nit, String correo, String genero){
        String sql = "insert into clientes(Codigo,Nombre,NIT,Correo,Genero) values (?,?,?,?,?)";
        try{
            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.setString(2, nombre);
            ps.setInt(3, nit);
            ps.setString(4, correo);
            ps.setString(5,genero);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
   

   
}
