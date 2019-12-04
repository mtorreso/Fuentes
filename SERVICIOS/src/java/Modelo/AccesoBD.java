package Modelo;
import java.sql.*;
public class AccesoBD {
    private static final AccesoBD abd = new AccesoBD();
    private static Connection conexion;

    public AccesoBD() {
        
    }
    
    public static AccesoBD getABD(){
        return abd;
    }
    
    public Connection Conectar(){
        try {
            conexion = null;
            Class.forName("oracle.jdbc.OracleDriver");
            String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:xe";
            conexion = DriverManager.getConnection(BaseDeDatos, "portafolio", "portafolio");
        } catch (Exception e) {
            conexion=null;
            System.out.println("Error: "+ e.toString());
        }
        
        return conexion;
    }
    
    
}
