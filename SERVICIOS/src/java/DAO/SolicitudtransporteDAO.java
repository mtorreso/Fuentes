/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Asignacionestransporte;
import Modelo.Conexion;
import Modelo.Solicitudes;
import Modelo.Solicitudtransporte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author torre
 */
public class SolicitudtransporteDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conex = new Conexion();
    int res;
    String msj;
    Solicitudtransporte st = new Solicitudtransporte();

    public List listarmissolicitudes(String id_reserva) {
        System.out.println("id reserva" + id_reserva);
        List<Solicitudtransporte> datos = new ArrayList<>();
        String sql = "select * from solicitudtransporte where id_reserva = '" + id_reserva + "'";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                st = new Solicitudtransporte();
                st.setId_solicitud(rs.getInt("id_solicitud"));
                st.setId_reserva(rs.getString("id_reserva"));
                st.setFecha_solicitud(rs.getString("fecha_solicitud"));
                st.setHora_solicitud(rs.getString("hora_solicitud"));
                st.setOrigen(rs.getString("origen"));
                st.setDestino(rs.getString("destino"));
                st.setEstado(rs.getString("estado"));
                datos.add(st);
            }
        } catch (Exception e) {
            System.err.println("ERROR AL LISTAR SOLICITUDES DE TRANSPORTE  POR RESERVA" + e.getMessage());
        }
        System.out.println("datos" + datos.toString());
        return datos;
    }

    public String nuevasolicitud(String id_reserva, String fecha_solicitud, String hora_solicitud, String origen, String destino) {
        String sql = "insert into solicitudtransporte(id_reserva,fecha_solicitud,hora_solicitud,origen,destino) values(?,?,?,?,?)";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id_reserva);
            ps.setString(2, fecha_solicitud);
            ps.setString(3, hora_solicitud);
            ps.setString(4, origen);
            ps.setString(5, destino);

            res = ps.executeUpdate();
            if (res == 1) {
                msj = "Solicitud  Ha Sido Generada Correctamente . En 48 horas se le Asignará un Transporte . Muchas Gracias";
            } else {
                msj = "Error en la solicitud";
            }

        } catch (Exception e) {
        }
        return msj;
    }

    public List Listarsolicitudes() {
        List<Solicitudes> datos = new ArrayList<>();
        String sql = "select * from solicitudtransporte a inner join reserva b on a.id_reserva=b.id_reserva \n"
                + "inner join usuario c  on b.rut=c.rut";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Solicitudes s = new Solicitudes();
                s.setId_solicitud(rs.getInt("id_solicitud"));
                s.setId_reserva(rs.getString("id_reserva"));
                s.setFecha_solicitud(rs.getString("fecha_solicitud"));
                s.setHora_solicitud(rs.getString("hora_solicitud"));
                s.setOrigen(rs.getString("origen"));
                s.setDestino(rs.getString("destino"));
                s.setEstado(rs.getString("estado"));
                s.setFecha_reserva(rs.getString("fecha_reserva"));
                s.setCantidad_personas(rs.getString("cantidad_personas"));
                s.setFecha_salida(rs.getString("fecha_salida"));
                s.setRut(rs.getString("rut"));
                s.setId_departamento(rs.getString("id_departamento"));
                s.setId_usuario(rs.getInt("id_usuario"));
                s.setNombre(rs.getString("nombre"));
                s.setCorreo(rs.getString("correo"));
                s.setTelefono(rs.getString("telefono"));
                s.setClave(rs.getString("clave"));
                s.setId_rol(rs.getInt("id_rol"));

                datos.add(s);
            }
        } catch (Exception e) {
        }
        return datos;
    }

    public List listarsolicitudesporfechas(String fechainicial, String fechafinal) {
        System.out.println("fechainiicial" + fechainicial);
        System.out.println("fechafinal" + fechafinal);
        List<Solicitudes> datos = new ArrayList<>();
        String sql = "select * from solicitudtransporte a inner join reserva b on a.id_reserva=b.id_reserva \n"
                + "                inner join usuario c  on b.rut=c.rut where a.fecha_solicitud between '" + fechainicial + "' and '" + fechafinal + "'";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Solicitudes s1 = new Solicitudes();
                s1.setId_solicitud(rs.getInt("id_solicitud"));
                s1.setId_reserva(rs.getString("id_reserva"));
                s1.setFecha_solicitud(rs.getString("fecha_solicitud"));
                s1.setHora_solicitud(rs.getString("hora_solicitud"));
                s1.setOrigen(rs.getString("origen"));
                s1.setDestino(rs.getString("destino"));
                s1.setEstado(rs.getString("estado"));
                s1.setFecha_reserva(rs.getString("fecha_reserva"));
                s1.setCantidad_personas(rs.getString("cantidad_personas"));
                s1.setFecha_salida(rs.getString("fecha_salida"));
                s1.setRut(rs.getString("rut"));
                s1.setId_departamento(rs.getString("id_departamento"));
                s1.setId_usuario(rs.getInt("id_usuario"));
                s1.setNombre(rs.getString("nombre"));
                s1.setCorreo(rs.getString("correo"));
                s1.setTelefono(rs.getString("telefono"));
                s1.setClave(rs.getString("clave"));
                s1.setId_rol(rs.getInt("id_rol"));
                datos.add(s1);
            }
        } catch (Exception e) {
            System.err.println("ERROR AL LISTAR SOLICITUDES POR FECHAS" + e.getMessage());
        }
        System.out.println("datos" + datos.toString());
        return datos;

    }

    public String nuevaplanificacion(String id_solicitud, String conductor, String auto, String patente) {
        String sql = "insert into planificartransporte(id_solicitud,conductor,auto,patente) values(?,?,?,?)";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id_solicitud);
            ps.setString(2, conductor);
            ps.setString(3, auto);
            ps.setString(4, patente);

            res = ps.executeUpdate();
            if (res == 1) {
                msj = "Transporte ha sido asignado correctamente";
            } else {
                msj = "Error en la asignación";
            }

        } catch (Exception e) {
        }
        return msj;
    }

    public String actualizarestado(int id_solicitud, String estado) {
        String sql = "update solicitudtransporte set estado=? where id_solicitud = " + id_solicitud;
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, estado);

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

    public Asignacionestransporte Detalleasignacion(int id_solicitud) {
        String sql = "select * from solicitudtransporte a inner join planificartransporte b  on a.id_solicitud=b.id_solicitud\n"
                + "inner join reserva c on a.id_reserva=c.id_reserva inner join usuario d on d.rut=c.rut\n"
                + "where a.id_solicitud= " + id_solicitud;
        Asignacionestransporte a = new Asignacionestransporte();
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                a.setId_solicitud(rs.getInt("id_solicitud"));
                a.setId_reserva(rs.getString("id_reserva"));
                a.setFecha_solicitud(rs.getString("fecha_solicitud"));
                a.setHora_solicitud(rs.getString("hora_solicitud"));
                a.setOrigen(rs.getString("origen"));
                a.setDestino(rs.getString("destino"));
                a.setEstado(rs.getString("estado"));
                a.setConductor(rs.getString("conductor"));
                a.setAuto(rs.getString("auto"));
                a.setPatente(rs.getString("patente"));
                a.setFecha_reserva(rs.getString("fecha_reserva"));
                a.setCantidad_personas(rs.getString("cantidad_personas"));
                a.setFecha_salida(rs.getString("fecha_salida"));
                a.setRut(rs.getString("rut"));
                a.setId_departamento(rs.getString("id_departamento"));
                a.setNombre(rs.getString("nombre"));
                a.setCorreo(rs.getString("correo"));
                a.setTelefono(rs.getString("telefono"));

            }
        } catch (Exception e) {
        }
        return a;
    }

}
