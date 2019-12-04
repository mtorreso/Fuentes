/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Conexion;
import Modelo.Reserva;
import Modelo.Reservas;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class ReservaDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conex = new Conexion();
    int res;
    String msj;

    Reserva r = new Reserva();
    Reservas re = new Reservas();

    public List listarreserva(String rut) {
        System.out.println("rut" + rut);
        List<Reservas> datos = new ArrayList<>();
        String sql = "select r.id_reserva , r.fecha_reserva,r.cantidad_personas,r.fecha_salida,r.rut,r.id_departamento,\n"
                + "u.id_usuario,u.nombre,u.rut as cedula,d.nombre as residencia , d.ubicacion,d.banos,d.habitaciones,\n"
                + "d.valorarriendo,d.descripcion,d.fecha from reserva r inner join usuario u on r.rut=u.rut \n"
                + "inner join departamento d on d.id=r.id_departamento where u.rut = '" + rut + "'";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                re = new Reservas();
                re.setId_reserva(rs.getInt("id_reserva"));
                re.setFecha_reserva(rs.getString("fecha_reserva"));
                re.setCantidad_personas(rs.getString("cantidad_personas"));
                re.setFecha_salida(rs.getString("fecha_salida"));
                re.setRut(rs.getString("rut"));
                re.setId_departamento(rs.getString("id_departamento"));
                re.setCedula(rs.getString("rut"));
                re.setNombre(rs.getString("nombre"));
                re.setNombre_1(rs.getString("residencia"));
                re.setUbicacion(rs.getString("ubicacion"));
                re.setValorarriendo(rs.getString("valorarriendo"));
                datos.add(re);
            }
        } catch (Exception e) {
            System.err.println("ERROR AL LISTAR RESERVAS POR RUT" + e.getMessage());
        }
        System.out.println("datos" + datos.toString());
        return datos;

    }

    public List Listar3omaspersonas() {
        List<Reservas> datos = new ArrayList<>();
        String sql = "select r.id_reserva , r.fecha_reserva,r.cantidad_personas,r.fecha_salida,r.rut,r.id_departamento,\n"
                + "u.id_usuario,u.nombre,u.rut as cedula,d.nombre as residencia , d.ubicacion,d.direccion,d.banos,d.habitaciones,\n"
                + "d.valorarriendo,d.descripcion,d.fecha,d.habilitado from reserva r inner join usuario u on r.rut=u.rut \n"
                + "inner join departamento d on d.id=r.id_departamento where r.cantidad_personas>3";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Reservas re1 = new Reservas();
                re1.setId_reserva(rs.getInt("id_reserva"));
                re1.setFecha_reserva(rs.getString("fecha_reserva"));
                re1.setCantidad_personas(rs.getString("cantidad_personas"));
                re1.setFecha_salida(rs.getString("fecha_salida"));
                re1.setRut(rs.getString("rut"));
                re1.setId_departamento(rs.getString("id_departamento"));
                re1.setCedula(rs.getString("rut"));
                re1.setNombre(rs.getString("nombre"));
                re1.setNombre_1(rs.getString("residencia"));
                re1.setUbicacion(rs.getString("ubicacion"));
                re1.setValorarriendo(rs.getString("valorarriendo"));
                datos.add(re1);
            }
        } catch (Exception e) {
        }
        return datos;
    }

    public Reserva listarIDaddReserva(int id_reserva) {
        String sql = "select * from reserva where id_reserva =" + id_reserva;
        r = new Reserva();
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                r.setId_reserva(rs.getInt("id_reserva"));
                r.setFecha_reserva(rs.getString("fecha_reserva"));
                r.setCantidad_personas(rs.getString("cantidad_personas"));
                r.setFecha_salida(rs.getString("fecha_salida"));
                r.setRut(rs.getString("rut"));
                r.setId_departamento(rs.getString("id_departamento"));
            }
        } catch (Exception e) {
        }
        return r;
    }

    public String addReserva(String fecha_reserva, String cantidad_personas, String fecha_salida, String rut, String id_departamento) {
        String sql = "insert into reserva(fecha_reserva,cantidad_personas,fecha_salida,rut,id_departamento) values(?,?,?,?,?)";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, fecha_reserva);
            ps.setString(2, cantidad_personas);
            ps.setString(3, fecha_salida);
            ps.setString(4, rut);
            ps.setString(5, id_departamento);

            res = ps.executeUpdate();
            if (res == 1) {
                msj = "Reserva generada correctamente";
            } else {
                msj = "Error reserva existe";
            }

        } catch (Exception e) {
        }
        return msj;
    }

    public String editReserva(int id_reserva, String fecha_reserva, String cantidad_personas, String fecha_salida, String rut, String id_departamento) {

        String sql = "update reserva set fecha_reserva=?,cantidad_personas=?,fecha_salida=?,rut=?,id_departamento=? where id_reserva =" + id_reserva;
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, fecha_reserva);
            ps.setString(2, cantidad_personas);
            ps.setString(3, fecha_salida);
            ps.setString(4, rut);
            ps.setString(5, id_departamento);

            res = ps.executeUpdate();
            if (res == 1) {
                msj = "Reserva Actualizada correctamente";
            } else {
                msj = "Error en la actualización";
            }

        } catch (Exception e) {
        }
        return msj;
    }

    public String eliminar(int id_reserva) {
        String sql = "delete from reserva where id_reserva =" + id_reserva;
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            res = ps.executeUpdate();
            if (res == 1) {
                msj = "Reserva ha sido anulada correctamente";
            } else {
                msj = "Error en la anulación";
            }

        } catch (Exception e) {
        }
        return msj;
    }

    public List listarreservasporfechas(String fechainicial, String fechafinal) {
        System.out.println("fechainiicial" + fechainicial);
        System.out.println("fechafinal" + fechafinal);
        List<Reservas> datos = new ArrayList<>();
        String sql = "select r.id_reserva , r.fecha_reserva,r.cantidad_personas,r.fecha_salida,r.rut,r.id_departamento,\n"
                + "u.id_usuario,u.nombre,u.rut as cedula,d.nombre as residencia , d.ubicacion,d.banos,d.habitaciones,\n"
                + "d.valorarriendo,d.descripcion,d.fecha from reserva r inner join usuario u on r.rut=u.rut \n"
                + "inner join departamento d on d.id=r.id_departamento where r.fecha_reserva between '" + fechainicial + "' and '" + fechafinal + "'";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Reservas re2 = new Reservas();
                re2.setId_reserva(rs.getInt("id_reserva"));
                re2.setFecha_reserva(rs.getString("fecha_reserva"));
                re2.setCantidad_personas(rs.getString("cantidad_personas"));
                re2.setFecha_salida(rs.getString("fecha_salida"));
                re2.setRut(rs.getString("rut"));
                re2.setId_departamento(rs.getString("id_departamento"));
                re2.setCedula(rs.getString("rut"));
                re2.setNombre(rs.getString("nombre"));
                re2.setNombre_1(rs.getString("residencia"));
                re2.setUbicacion(rs.getString("ubicacion"));
                re2.setValorarriendo(rs.getString("valorarriendo"));
                datos.add(re2);
            }
        } catch (Exception e) {
            System.err.println("ERROR AL LISTAR RESERVAS POR FECHAS" + e.getMessage());
        }
        System.out.println("datos" + datos.toString());
        return datos;

    }

    public List listarreservaspornumeropersonas(String cantidad_personas) {
        System.out.println("nùmero personas" + cantidad_personas);
        List<Reservas> datos = new ArrayList<>();
        String sql = "select r.id_reserva , r.fecha_reserva,r.cantidad_personas,r.fecha_salida,r.rut,r.id_departamento,\n"
                + "u.id_usuario,u.nombre,u.rut as cedula,d.nombre as residencia , d.ubicacion,d.banos,d.habitaciones,\n"
                + "d.valorarriendo,d.descripcion,d.fecha from reserva r inner join usuario u on r.rut=u.rut \n"
                + "inner join departamento d on d.id=r.id_departamento where r.cantidad_personas = '" + cantidad_personas + "'";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                re = new Reservas();
                re.setId_reserva(rs.getInt("id_reserva"));
                re.setFecha_reserva(rs.getString("fecha_reserva"));
                re.setCantidad_personas(rs.getString("cantidad_personas"));
                re.setFecha_salida(rs.getString("fecha_salida"));
                re.setRut(rs.getString("rut"));
                re.setId_departamento(rs.getString("id_departamento"));
                re.setCedula(rs.getString("rut"));
                re.setNombre(rs.getString("nombre"));
                re.setNombre_1(rs.getString("residencia"));
                re.setUbicacion(rs.getString("ubicacion"));
                re.setValorarriendo(rs.getString("valorarriendo"));
                datos.add(re);
            }
        } catch (Exception e) {
            System.err.println("ERROR AL LISTAR RESERVAS POR CANTIDAD PERSONAS" + e.getMessage());
        }
        System.out.println("datos" + datos.toString());
        return datos;

    }
    
        public List listarreservasporcomuna(String comuna) {
        System.out.println("comuna" + comuna);
        List<Reservas> datos = new ArrayList<>();
        String sql = "select r.id_reserva , r.fecha_reserva,r.cantidad_personas,r.fecha_salida,r.rut,r.id_departamento,\n"
                + "u.id_usuario,u.nombre,u.rut as cedula,d.nombre as residencia , d.ubicacion,d.banos,d.habitaciones,\n"
                + "d.valorarriendo,d.descripcion,d.fecha from reserva r inner join usuario u on r.rut=u.rut \n"
                + "inner join departamento d on d.id=r.id_departamento where d.ubicacion = '" + comuna + "'";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                re = new Reservas();
                re.setId_reserva(rs.getInt("id_reserva"));
                re.setFecha_reserva(rs.getString("fecha_reserva"));
                re.setCantidad_personas(rs.getString("cantidad_personas"));
                re.setFecha_salida(rs.getString("fecha_salida"));
                re.setRut(rs.getString("rut"));
                re.setId_departamento(rs.getString("id_departamento"));
                re.setCedula(rs.getString("rut"));
                re.setNombre(rs.getString("nombre"));
                re.setNombre_1(rs.getString("residencia"));
                re.setUbicacion(rs.getString("ubicacion"));
                re.setValorarriendo(rs.getString("valorarriendo"));
                datos.add(re);
            }
        } catch (Exception e) {
            System.err.println("ERROR AL LISTAR RESERVAS POR CANTIDAD COMUNA" + e.getMessage());
        }
        System.out.println("datos" + datos.toString());
        return datos;

    }

}
