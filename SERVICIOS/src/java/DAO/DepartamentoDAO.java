/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.CuentasDAO.conexion;
import Modelo.AccesoBD;
import Modelo.Conexion;
import Modelo.Departamento;
import Modelo.Localidad;
import Modelo.Reservasdepto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author torre
 */
public class DepartamentoDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conex = new Conexion();
    Departamento d = new Departamento();
    Localidad l = new Localidad();
    Reservasdepto re = new Reservasdepto();
    int res;
    String msj;

    public List Listar() {
        List<Departamento> datos = new ArrayList<>();
        String sql = "select * from departamento";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                d = new Departamento();
                d.setId(rs.getInt("id"));
                d.setNombre(rs.getString("nombre"));
                d.setUbicacion(rs.getString("ubicacion"));
                d.setBanos(rs.getString("banos"));
                d.setHabitaciones(rs.getString("habitaciones"));
                d.setValorarriendo(rs.getString("valorarriendo"));
                d.setDescripcion(rs.getString("descripcion"));
                d.setFecha(rs.getString("fecha"));
                d.setDireccion(rs.getString("direccion"));
                d.setHabilitado(rs.getString("habilitado"));
                datos.add(d);
            }
        } catch (Exception e) {
        }
        return datos;
    }

    public List ListarHabilitados() {
        List<Departamento> datos = new ArrayList<>();
        String sql = "select * from departamento where habilitado=1";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                d = new Departamento();
                d.setId(rs.getInt("id"));
                d.setNombre(rs.getString("nombre"));
                d.setUbicacion(rs.getString("ubicacion"));
                d.setBanos(rs.getString("banos"));
                d.setHabitaciones(rs.getString("habitaciones"));
                d.setValorarriendo(rs.getString("valorarriendo"));
                d.setDescripcion(rs.getString("descripcion"));
                d.setFecha(rs.getString("fecha"));
                d.setDireccion(rs.getString("direccion"));
                d.setHabilitado(rs.getString("habilitado"));
                datos.add(d);
            }
        } catch (Exception e) {
        }
        return datos;
    }

    public Departamento listarID(int id) {
        String sql = "select * from departamento where id= " + id;
        d = new Departamento();
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                d.setId(rs.getInt("id"));
                d.setNombre(rs.getString("nombre"));
                d.setUbicacion(rs.getString("ubicacion"));
                d.setBanos(rs.getString("banos"));
                d.setHabitaciones(rs.getString("habitaciones"));
                d.setValorarriendo(rs.getString("valorarriendo"));
                d.setDescripcion(rs.getString("descripcion"));
                d.setFecha(rs.getString("fecha"));
                d.setDireccion(rs.getString("direccion"));
                d.setHabilitado(rs.getString("habilitado"));
            }
        } catch (Exception e) {
        }
        return d;
    }

    public String add(String nombre, String ubicacion, String banos, String habitaciones, String valorarriendo, String descripcion, String fecha, String direccion) {
        String sql = "insert into departamento(nombre,ubicacion,banos,habitaciones,valorarriendo,descripcion,fecha,direccion) values(?,?,?,?,?,?,?,?)";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, ubicacion);
            ps.setString(3, banos);
            ps.setString(4, habitaciones);
            ps.setString(5, valorarriendo);
            ps.setString(6, descripcion);
            ps.setString(7, fecha);
            ps.setString(8, direccion);
            res = ps.executeUpdate();
            if (res == 1) {
                msj = "Departamento Agregado";
            } else {
                msj = "Error en el registro";
            }

        } catch (Exception e) {
        }
        return msj;
    }
    


    public String edit(int id, String nombre, String ubicacion, String banos, String habitaciones, String valorarriendo, String descripcion, String fecha, String direccion) {
        String sql = "update departamento set nombre=?,ubicacion=?,banos=?,habitaciones=?,valorarriendo=?,descripcion=?,fecha=?,direccion=? where id = " + id;
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, ubicacion);
            ps.setString(3, banos);
            ps.setString(4, habitaciones);
            ps.setString(5, valorarriendo);
            ps.setString(6, descripcion);
            ps.setString(7, fecha);
            ps.setString(8, direccion);
            res = ps.executeUpdate();
            if (res == 1) {
                msj = "Departamento Actualizado";
            } else {
                msj = "Error en la actualización";
            }

        } catch (Exception e) {
        }
        return msj;
    }

    public String actualizarestado(int id, String habilitado) {
        String sql = "update departamento set habilitado=? where id = " + id;
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, habilitado);

            res = ps.executeUpdate();
            if (res == 1) {
                msj = "Estado  Actualizado";
            } else {
                msj = "Error en la actualización";
            }

        } catch (Exception e) {
        }
        return msj;
    }

    public String delete(int id) {
        String sql = "delete from departamento where id = " + id;
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            res = ps.executeUpdate();
            if (res == 1) {
                msj = "Departamento ha sido eliminado correctamente";
            } else {
                msj = "Error en la eliminación";
            }

        } catch (Exception e) {
        }
        return msj;
    }

    public List listarporubicacion(String ubicacion) {
        System.out.println("localidad" + ubicacion);
        List<Departamento> datos = new ArrayList<>();
        String sql = "select * from departamento where ubicacion = '" + ubicacion + "'";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                d = new Departamento();
                d.setId(rs.getInt("id"));
                d.setNombre(rs.getString("nombre"));
                d.setUbicacion(rs.getString("ubicacion"));
                d.setBanos(rs.getString("banos"));
                d.setHabitaciones(rs.getString("habitaciones"));
                d.setValorarriendo(rs.getString("valorarriendo"));
                d.setDescripcion(rs.getString("descripcion"));
                d.setDireccion(rs.getString("direccion"));
                d.setFecha(rs.getString("fecha"));
                d.setHabilitado(rs.getString("habilitado"));
                datos.add(d);
            }
        } catch (Exception e) {
            System.err.println("ERROR AL LISTAR DEPARTAMENTOS POR COMUNA" + e.getMessage());
        }
        System.out.println("datos" + datos.toString());
        return datos;
    }

    public List listarreservadepartamento(int id) {
        System.out.println("id departamento" + id);
        List<Reservasdepto> datos = new ArrayList<>();
        String sql = "select d.id, r.id_reserva , r.rut,u.rut as cedula,u.nombre,d.nombre as departamento,d.ubicacion,r.fecha_reserva,r.fecha_salida\n"
                + " from departamento d inner join reserva r on r.id_departamento=d.id\n"
                + "                inner join usuario u on u.rut=r.rut\n"
                + "                where d.id =" + id;
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                re = new Reservasdepto();
                re.setId(rs.getInt("id"));
                System.out.println("id departamento " + rs.getInt("id"));
                re.setId_reserva(rs.getInt("id_reserva"));
                System.out.println("id reserva " + rs.getString("id_reserva"));
                re.setRut(rs.getString("rut"));
                System.out.println("rut cliente" + rs.getString("rut"));
                re.setCedula(rs.getString("cedula"));
                System.out.println("rut cliente1 " + rs.getString("cedula"));
                re.setNombre(rs.getString("nombre"));
                System.out.println("nombre cliente " + rs.getString("nombre"));
                re.setDepartamento(rs.getString("departamento"));
                System.out.println(" departamento " + rs.getString("departamento"));
                re.setUbicacion(rs.getString("ubicacion"));
                System.out.println("ubicación " + rs.getString("ubicacion"));
                re.setFecha_reserva(rs.getString("fecha_reserva"));
                System.out.println("fecha reserva " + rs.getString("fecha_reserva"));
                re.setFecha_salida(rs.getString("fecha_salida"));
                System.out.println("fecha salida " + rs.getString("fecha_salida"));
                datos.add(re);
            }
        } catch (Exception e) {
            System.err.println("ERROR AL LISTAR RESERVAS POR DEPARTAMENTO" + e.getMessage());
        }
        System.out.println("datos" + datos.toString());
        return datos;
    }

    public List listarlocalidades() {
        List<Localidad> datos = new ArrayList<>();
        String sql = "select * from localidad";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                l = new Localidad();
                l.setId_localidad(rs.getInt("id_localidad"));
                l.setNombre_localidad(rs.getString("nombre_localidad"));
                datos.add(l);
            }
        } catch (Exception e) {
        }
        return datos;
    }

}
