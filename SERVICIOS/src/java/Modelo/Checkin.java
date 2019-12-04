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
public class Checkin {
    int id_checkin;
    String fecha_checkin,descripcion;
    String id_reserva;
    
     public Checkin() {

    }

    public Checkin(int id_checkin, String fecha_checkin, String descripcion, String id_reserva) {
        this.id_checkin = id_checkin;
        this.fecha_checkin = fecha_checkin;
        this.descripcion = descripcion;
        this.id_reserva = id_reserva;
    }

    public int getId_checkin() {
        return id_checkin;
    }

    public void setId_checkin(int id_checkin) {
        this.id_checkin = id_checkin;
    }

    public String getFecha_checkin() {
        return fecha_checkin;
    }

    public void setFecha_checkin(String fecha_checkin) {
        this.fecha_checkin = fecha_checkin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(String id_reserva) {
        this.id_reserva = id_reserva;
    }

   
    
    
}
