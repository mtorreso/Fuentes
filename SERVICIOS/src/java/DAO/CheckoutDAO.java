/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Checkin;
import Modelo.Checkout;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author torre
 */
public class CheckoutDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conex = new Conexion();
    int res;
    String msj;
    Checkout c = new Checkout();

    public String nuevocheckout(String fecha_checkout, String descripcion, String id_reserva) {
        String sql = "insert into checkout(fecha_checkout,descripcion,id_reserva)values(?,?,?)";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, fecha_checkout);
            ps.setString(2, descripcion);
            ps.setString(3, id_reserva);
            res = ps.executeUpdate();
            if (res == 1) {
                msj = "Checkout registrado correctamente ";
            } else {
                msj = "Error en el registro";
            }
        } catch (Exception e) {
        }
        return msj;
    }

    public Checkout ListarCheckout(String id_reserva) {
        String sql = "select * from checkout where id_reserva = '" + id_reserva + "'";
        c = new Checkout();
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setId_checkout(rs.getInt("id_checkout"));
                c.setFecha_checkout(rs.getString("fecha_checkout"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setId_reserva(rs.getString("id_reserva"));

            }
        } catch (Exception e) {
        }
        return c;
    }

}
