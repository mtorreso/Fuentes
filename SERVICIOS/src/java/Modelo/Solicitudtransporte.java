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
public class Solicitudtransporte {
    
    int id_solicitud;
    String id_reserva;
    String fecha_solicitud;
    String hora_solicitud;
    String origen;
    String destino;
    String estado;
    
    
    public Solicitudtransporte(){
        
    }

    public Solicitudtransporte(int id_solicitud, String id_reserva, String fecha_solicitud, String hora_solicitud, String origen, String destino, String estado) {
        this.id_solicitud = id_solicitud;
        this.id_reserva = id_reserva;
        this.fecha_solicitud = fecha_solicitud;
        this.hora_solicitud = hora_solicitud;
        this.origen = origen;
        this.destino = destino;
        this.estado = estado;
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
    
    
    
}
