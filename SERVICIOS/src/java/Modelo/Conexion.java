/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author torre
 */
public class Conexion {

    Connection con;

    public Conexion() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "portafolio", "portafolio");

        } catch (Exception e) {
        }
    }
    public Connection getConnection(){
        return con;
        
    }

}
