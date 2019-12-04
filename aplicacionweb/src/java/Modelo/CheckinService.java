/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import webservice.Checkin;

/**
 *
 * @author torre
 */
public class CheckinService {
    public CheckinService(){
        
    }

    public String nuevocheckin(java.lang.String fechaCheckin, java.lang.String descripcion, java.lang.String idReserva) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.nuevocheckin(fechaCheckin, descripcion, idReserva);
    }

   public Checkin listarCheckin(java.lang.String idReserva) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.listarCheckin(idReserva);
    }


   
    
}
