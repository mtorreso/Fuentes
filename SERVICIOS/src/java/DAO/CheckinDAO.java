/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Checkin;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author torre
 */
public class CheckinDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conex = new Conexion();
    int res;
    String msj;
    Checkin c = new Checkin();

    public String nuevocheckin(String fecha_checkin, String descripcion, String id_reserva) {
        String sql = "insert into checkin(fecha_checkin,descripcion,id_reserva)values(?,?,?)";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, fecha_checkin);
            ps.setString(2, descripcion);
            ps.setString(3, id_reserva);
            res = ps.executeUpdate();
            if (res == 1) {
                msj = "Checkin registrado correctamente ";
            } else {
                msj = "Error en el registro";
            }
        } catch (Exception e) {
        }
        return msj;
    }

    public Checkin ListarCheckin(String id_reserva) {
        String sql = "select * from checkin where id_reserva = '" + id_reserva + "'";
        c = new Checkin();
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setId_checkin(rs.getInt("id_checkin"));
                c.setFecha_checkin(rs.getString("fecha_checkin"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setId_reserva(rs.getString("id_reserva"));

            }
        } catch (Exception e) {
        }
        return c;
    }

}
