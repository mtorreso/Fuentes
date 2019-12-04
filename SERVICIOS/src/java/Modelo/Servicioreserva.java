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
public class Servicioreserva {

    int id_srv;
    String nombre_srv;
    String precio;
    String fecha_contratacion;
    String id_reserva;

    public Servicioreserva() {

    }

    public Servicioreserva(int id_srv, String nombre_srv, String precio, String fecha_contratacion, String id_reserva) {
        this.id_srv = id_srv;
        this.nombre_srv = nombre_srv;
        this.precio = precio;
        this.fecha_contratacion = fecha_contratacion;
        this.id_reserva = id_reserva;
    }

    public int getId_srv() {
        return id_srv;
    }

    public void setId_srv(int id_srv) {
        this.id_srv = id_srv;
    }

    public String getNombre_srv() {
        return nombre_srv;
    }

    public void setNombre_srv(String nombre_srv) {
        this.nombre_srv = nombre_srv;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(String fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    public String getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(String id_reserva) {
        this.id_reserva = id_reserva;
    }

}
