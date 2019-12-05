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
public class Asignacionestransporte {
    int id_solicitud;
    String id_reserva;
    String fecha_solicitud;
    String hora_solicitud;
    String origen;
    String destino;
    String estado;
    String conductor;
    String auto;
    String patente;
    String fecha_reserva;
    String cantidad_personas;
    String fecha_salida;
    String rut;
    String id_departamento;
    String nombre;
    String correo;
    String telefono;
    
    public Asignacionestransporte(){
        
    }

    public Asignacionestransporte(int id_solicitud, String id_reserva, String fecha_solicitud, String hora_solicitud, String origen, String destino, String estado, String conductor, String auto, String patente, String fecha_reserva, String cantidad_personas, String fecha_salida, String rut, String id_departamento, String nombre, String correo, String telefono) {
        this.id_solicitud = id_solicitud;
        this.id_reserva = id_reserva;
        this.fecha_solicitud = fecha_solicitud;
        this.hora_solicitud = hora_solicitud;
        this.origen = origen;
        this.destino = destino;
        this.estado = estado;
        this.conductor = conductor;
        this.auto = auto;
        this.patente = patente;
        this.fecha_reserva = fecha_reserva;
        this.cantidad_personas = cantidad_personas;
        this.fecha_salida = fecha_salida;
        this.rut = rut;
        this.id_departamento = id_departamento;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
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

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
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
    
    
    
}
