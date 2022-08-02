
package Proyecto_ventas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VendedoresDAO {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();

    public int filtro(String nombre, String contra ){
    
    String sql = "select * from vendedor where nombre = "+"'"+nombre+"'"+" and password = "+"'"+contra+"'"+";";
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
