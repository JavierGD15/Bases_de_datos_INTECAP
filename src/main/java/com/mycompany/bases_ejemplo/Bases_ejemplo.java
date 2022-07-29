package com.mycompany.bases_ejemplo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Bases_ejemplo {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Object datos[][];

    public void menu() {
        while (true) {
            Scanner sp = new Scanner(System.in);
            System.out.println("=================================");
            System.out.println("|           Menu Principal      |");
            System.out.println("| 1. Mostrar                    |");
            System.out.println("| 2. Crear                      |");
            System.out.println("| 3. Eliminar                   |");
            System.out.println("| 4. Modificar                  |");
            System.out.println("| 5. Cerrar                     |");
            System.out.println("=================================");
            int respuesta = sp.nextInt();

            switch (respuesta) {
                case 1:
                    listar();
                    break;
                case 2:
                    Scanner sc = new Scanner(System.in);
                    
                    System.out.println("Ingrese su carnet");
                    int carnet = sc.nextInt();
                    
                    System.out.println("Ingrese su nombre");
                    String nombre = sc.nextLine();
                    
                    crear(carnet, nombre, 0, 0);
                    break;
                case 3:
                    int id = sp.nextInt();
                    eliminar(id);
                    break;
                case 4:

                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    throw new AssertionError();
            }
        }

    }

    public Object[][] listar() {

        String instruccion = "select * from alumnos";
        
        try {
            int x = 0;
            con = conectar.Conectar();
            ps = con.prepareStatement(instruccion);
            rs = ps.executeQuery();
            

            while (rs.next()) {
               x++;
            }
            
             datos = new Object[x][4];
            
            con = conectar.Conectar();
            ps = con.prepareStatement(instruccion);
            rs = ps.executeQuery();
            x =0;

            while (rs.next()) {
                datos[x][0]= rs.getInt(1);
                datos[x][1] = rs.getString(2);
                datos[x][2] = rs.getInt(3);
                datos[x][3] = rs.getInt(4);
               x++;
            }

        } catch (Exception e) {
            System.out.println("fallo");
        }
        
        return datos;

    }

    public void crear(int carnet, String nombre, int numero, int id) {
        String sql = "insert into alumnos(carnet,nombre,telefono,estado) values (?,?,?,?)";

        try {
            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, carnet);
            ps.setString(2, nombre);
            ps.setInt(3, numero);
            ps.setInt(4, id);
            ps.executeUpdate();

        } catch (Exception e) {
        }

    }

    public void modificar(int carnet, String nombre, int numero, int estado) {

        String sql = "update alumnos set nombre='" + nombre + "', telefono='" + numero + "', estado='" + estado + "' where carnet ='" + carnet + "'";
        try {
            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void eliminar(int id) {
        String sql = "delete from alumnos where carnet = ?";
        try {

            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

    public static void main(String[] args) {
        Bases_ejemplo bj = new Bases_ejemplo();
        bj.menu();
    }

}
