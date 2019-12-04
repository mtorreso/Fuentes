/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author torre
 */
public class Solicitudes {
    int id_solicitud;
    String id_reserva;
    String fecha_solicitud;
    String hora_solicitud;
    String origen;
    String destino;
    String estado;
    int id_reserva1;
    String fecha_reserva;
    String cantidad_personas;
    String fecha_salida;
    String rut;
    String id_departamento;
    int id_usuario;
    String rut1;
    String nombre;
    String correo;
    String telefono;
    String clave;
    int id_rol;
    
    
    public Solicitudes(){
        
    }

    public Solicitudes(int id_solicitud, String id_reserva, String fecha_solicitud, String hora_solicitud, String origen, String destino, String estado, int id_reserva1, String fecha_reserva, String cantidad_personas, String fecha_salida, String rut, String id_departamento, int id_usuario, String rut1, String nombre, String correo, String telefono, String clave, int id_rol) {
        this.id_solicitud = id_solicitud;
        this.id_reserva = id_reserva;
        this.fecha_solicitud = fecha_solicitud;
        this.hora_solicitud = hora_solicitud;
        this.origen = origen;
        this.destino = destino;
        this.estado = estado;
        this.id_reserva1 = id_reserva1;
        this.fecha_reserva = fecha_reserva;
        this.cantidad_personas = cantidad_personas;
        this.fecha_salida = fecha_salida;
        this.rut = rut;
        this.id_departamento = id_departamento;
        this.id_usuario = id_usuario;
        this.rut1 = rut1;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.clave = clave;
        this.id_rol = id_rol;
    }

    public int getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(int id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public String getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(String id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(String fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public String getHora_solicitud() {
        return hora_solicitud;
    }

    public void setHora_solicitud(String hora_solicitud) {
        this.hora_solicitud = hora_solicitud;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_reserva1() {
        return id_reserva1;
    }

    public void setId_reserva1(int id_reserva1) {
        this.id_reserva1 = id_reserva1;
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

    public String getRut1() {
        return rut1;
    }

    public void setRut1(String rut1) {
        this.rut1 = rut1;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }
    
    
}
