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
public class Reserva {
    int id_reserva;
    String fecha_reserva;
    String cantidad_personas;
    String fecha_salida;
    String rut;
    String id_departamento;
    
    public Reserva(){
        
    }

    public Reserva(int id_reserva, String fecha_reserva, String cantidad_personas, String fecha_salida, String rut, String id_departamento) {
        this.id_reserva = id_reserva;
        this.fecha_reserva = fecha_reserva;
        this.cantidad_personas = cantidad_personas;
        this.fecha_salida = fecha_salida;
        this.rut = rut;
        this.id_departamento = id_departamento;
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

   
}