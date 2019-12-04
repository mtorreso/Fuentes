/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Manuel
 */
public class Reservas {
    int id_reserva;
    String fecha_reserva;
    String cantidad_personas;
    String fecha_salida;
    String rut;
    String id_departamento;
    int id_usuario;
    String cedula;
    String nombre;
    String correo;
    String clave;
    String id;
    String nombre_1;
    String ubicacion;
    String banos;
    String habitaciones;
    String valorarriendo;
    String descripcion;
    String fecha;

    public Reservas(){
        
    }

    public Reservas(int id_reserva, String fecha_reserva, String cantidad_personas, String fecha_salida, String rut, String id_departamento, int id_usuario, String cedula, String nombre, String correo, String clave, String id, String nombre_1, String ubicacion, String banos, String habitaciones, String valorarriendo, String descripcion, String fecha) {
        this.id_reserva = id_reserva;
        this.fecha_reserva = fecha_reserva;
        this.cantidad_personas = cantidad_personas;
        this.fecha_salida = fecha_salida;
        this.rut = rut;
        this.id_departamento = id_departamento;
        this.id_usuario = id_usuario;
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
        this.id = id;
        this.nombre_1 = nombre_1;
        this.ubicacion = ubicacion;
        this.banos = banos;
        this.habitaciones = habitaciones;
        this.valorarriendo = valorarriendo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(String fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public String getCantidad_personas() {
        return cantidad_personas;
    }

    public void setCantidad_personas(String cantidad_personas) {
        this.cantidad_personas = cantidad_personas;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(String id_departamento) {
        this.id_departamento = id_departamento;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre_1() {
        return nombre_1;
    }

    public void setNombre_1(String nombre_1) {
        this.nombre_1 = nombre_1;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getBanos() {
        return banos;
    }

    public void setBanos(String banos) {
        this.banos = banos;
    }

    public String getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(String habitaciones) {
        this.habitaciones = habitaciones;
    }

    public String getValorarriendo() {
        return valorarriendo;
    }

    public void setValorarriendo(String valorarriendo) {
        this.valorarriendo = valorarriendo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

  
}
