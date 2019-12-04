/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import webservice.Serviciosdepto;

/**
 *
 * @author torre
 */
public class ServicioService {

    public ServicioService() {

    }

    public java.util.List<webservice.Serviciosdepto> listarServicios(int id) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.listarServicios(id);
    }

    public String eliminarservicio(int id) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.eliminarservicio(id);
    }

    public String nuevoservicio(java.lang.String nombreSrv, java.lang.String precio, java.lang.String idDepartamento) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.nuevoservicio(nombreSrv, precio, idDepartamento);
    }

    public Serviciosdepto buscarServicio(int id) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.buscarServicio(id);
    }

    public String modificarServicio(int idSrv, java.lang.String nombreSrv, java.lang.String precio) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.modificarServicio(idSrv, nombreSrv, precio);
    }

   public String contratarservicio(java.lang.String fechaContratacion, java.lang.String idSrv, java.lang.String idReserva) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.contratarservicio(fechaContratacion, idSrv, idReserva);
    }

    public java.util.List<webservice.Servicioreserva> servicioscontratados(int idReserva) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.servicioscontratados(idReserva);
    }

    public java.util.List<webservice.Serviciosdepto> listarserv() {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.listarserv();
    }


    
    

}
