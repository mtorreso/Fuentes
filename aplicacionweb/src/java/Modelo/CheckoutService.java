/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import webservice.Checkout;

/**
 *
 * @author torre
 */
public class CheckoutService {
    public CheckoutService(){
        
    }

    public String nuevocheckout(java.lang.String fechaCheckout, java.lang.String descripcion, java.lang.String idReserva) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.nuevocheckout(fechaCheckout, descripcion, idReserva);
    }

    public Checkout listarCheckout(java.lang.String idReserva) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.listarCheckout(idReserva);
    }
    
    
}
