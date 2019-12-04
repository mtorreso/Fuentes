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
public class Checkout {
    int id_checkout;
    String fecha_checkout,descripcion;
    String id_reserva;
    
     public Checkout() {

    }

    public Checkout(int id_checkout, String fecha_checkout, String descripcion, String id_reserva) {
        this.id_checkout = id_checkout;
        this.fecha_checkout = fecha_checkout;
        this.descripcion = descripcion;
        this.id_reserva = id_reserva;
    }

    public int getId_checkout() {
        return id_checkout;
    }

    public void setId_checkout(int id_checkout) {
        this.id_checkout = id_checkout;
    }

    public String getFecha_checkout() {
        return fecha_checkout;
    }

    public void setFecha_checkout(String fecha_checkout) {
        this.fecha_checkout = fecha_checkout;
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
