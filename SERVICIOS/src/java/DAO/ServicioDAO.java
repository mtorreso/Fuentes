/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Conexion;
import Modelo.Servicioreserva;
import Modelo.Serviciosdepto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author torre
 */
public class ServicioDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conex = new Conexion();
    int res;
    String msj;

    Serviciosdepto srv = new Serviciosdepto();

    public List listarServicios(int id) {
        System.out.println("id departamento" + id);
        List<Serviciosdepto> datos = new ArrayList<>();
        String sql = "select s.id_srv,s.nombre_srv,s.precio,s.id_departamento from servicio s inner join departamento d on d.id=s.id_departamento where s.id_departamento=" + id;
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Serviciosdepto srv = new Serviciosdepto();
                srv.setId_srv(rs.getInt("id_srv"));
                srv.setNombre_srv(rs.getString("nombre_srv"));
                srv.setPrecio(rs.getString("precio"));
                datos.add(srv);
            }
        } catch (Exception e) {
            System.err.println("ERROR AL LISTAR SERVICIOS POR DEPARTAMENTO" + e.getMessage());
        }
        System.out.println("datos" + datos.toString());
        return datos;
    }

    public List listarserv() {
        List<Serviciosdepto> datos = new ArrayList<>();
        String sql = "select * from servicio";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Serviciosdepto s = new Serviciosdepto();
                srv.setId_srv(rs.getInt("id_srv"));
                srv.setNombre_srv(rs.getString("nombre_srv"));
                srv.setPrecio(rs.getString("precio"));

                datos.add(srv);
            }
        } catch (Exception e) {
        }
        return datos;
    }

    public String addServicio(String nombre_srv, String precio, String id_departamento) {
        String sql = "insert into servicio(nombre_srv,precio,id_departamento)values(?,?,?)";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre_srv);
            ps.setString(2, precio);
            ps.setString(3, id_departamento);
            res = ps.executeUpdate();
            if (res == 1) {
                msj = "Servicio ha sido registrado correctamente ";
            } else {
                msj = "Error en el registro";
            }
        } catch (Exception e) {
        }
        return msj;
    }

    public String deleteServicio(int id) {
        String sql = "delete from servicio where id_srv=" + id;
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            res = ps.executeUpdate();
            if (res == 1) {
                msj = "Servicio ha sido eliminado correctamente";
            } else {
                msj = "Error en la eliminación";
            }

        } catch (Exception e) {
        }
        return msj;
    }

    public Serviciosdepto BuscarServicio(int id) {
        String sql = "select * from servicio where id_srv=" + id;
        Serviciosdepto srv = new Serviciosdepto();
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                srv.setId_srv(rs.getInt("id_srv"));
                srv.setNombre_srv(rs.getString("nombre_srv"));
                srv.setPrecio(rs.getString("precio"));
            }
        } catch (Exception e) {
        }
        return srv;
    }

    public String editServicio(int id_srv, String nombre_srv, String precio) {
        String sql = "update servicio set nombre_srv=?,precio=? where id_srv =" + id_srv;
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre_srv);
            ps.setString(2, precio);

            res = ps.executeUpdate();
            if (res == 1) {
                msj = "Servicio actualizado correctamente";
            } else {
                msj = "Error en la actualización";
            }
        } catch (Exception e) {
        }
        return msj;
    }

    public String contratarservicio(String fecha_contratacion, String id_srv, String id_reserva) {
        String sql = "insert into serv(fecha_contratacion,id_srv,id_reserva)values(?,?,?)";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, fecha_contratacion);
            ps.setString(2, id_srv);
            ps.setString(3, id_reserva);
            res = ps.executeUpdate();
            if (res == 1) {
                msj = "Servicio ha sido contratado correctamente ";
            } else {
                msj = "Error en el registro";
            }
        } catch (Exception e) {
        }
        return msj;
    }

    public List servicioscontratados(String id_reserva) {
        System.out.println("id reserva" + id_reserva);
        List<Servicioreserva> datos = new ArrayList<>();
        String sql = "select se.id_srv,se.nombre_srv,se.precio,s.fecha_contratacion,s.id_reserva from servicio se inner join serv s on se.id_srv=s.id_srv where s.id_reserva ='" + id_reserva + "'";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Servicioreserva serv = new Servicioreserva();
                serv.setId_srv(rs.getInt("id_srv"));
                serv.setNombre_srv(rs.getString("nombre_srv"));
                serv.setPrecio(rs.getString("precio"));
                serv.setFecha_contratacion(rs.getString("fecha_contratacion"));
                serv.setId_reserva(rs.getString("id_reserva"));
                datos.add(serv);
            }
        } catch (Exception e) {
            System.err.println("ERROR AL LISTAR SERVICIOS POR RESERVA" + e.getMessage());
        }
        System.out.println("datos" + datos.toString());
        return datos;
    }

}
