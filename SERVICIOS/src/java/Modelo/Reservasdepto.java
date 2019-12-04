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
public class Reservasdepto {
    
    //Atributos
    
    int id;
    int id_reserva;
    String rut;
    String cedula;
    String nombre;
    String departamento;
    String ubicacion;
    String fecha_reserva;
    String fecha_salida;
    
    
    //Constructor vacio

    public Reservasdepto() {
    }

    public Reservasdepto(int id, int id_reserva, String rut, String cedula, String nombre, String departamento, String ubicacion, String fecha_reserva, String fecha_salida) {
        this.id = id;
        this.id_reserva = id_reserva;
        this.rut = rut;
        this.cedula = cedula;
        this.nombre = nombre;
        this.departamento = departamento;
        this.ubicacion = ubicacion;
        this.fecha_reserva = fecha_reserva;
        this.fecha_salida = fecha_salida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(String fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }
    
    
    

    
}