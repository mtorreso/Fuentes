/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import webservice.Asignacionestransporte;

/**
 *
 * @author torre
 */
public class TransporteService {

    public TransporteService() {

    }

    public java.util.List<webservice.Solicitudtransporte> listarmissolicitudes(java.lang.String idReserva) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.listarmissolicitudes(idReserva);
    }

    public String nuevasolicitud(java.lang.String idReserva, java.lang.String fechaSolicitud, java.lang.String horaSolicitud, java.lang.String origen, java.lang.String destino) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.nuevasolicitud(idReserva, fechaSolicitud, horaSolicitud, origen, destino);
    }

    public java.util.List<webservice.Solicitudes> listarsolicitudes() {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.listarsolicitudes();
    }

    public String actualizarestadosolicitud(int idSolicitud, java.lang.String estado) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.actualizarestadosolicitud(idSolicitud, estado);
    }

    public String nuevaplanificacion(java.lang.String idSolicitud, java.lang.String conductor, java.lang.String auto, java.lang.String patente) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.nuevaplanificacion(idSolicitud, conductor, auto, patente);
    }

    public java.util.List<webservice.Solicitudes> listarsolicitudesporfechas(java.lang.String fechainicial, java.lang.String fechafinal) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.listarsolicitudesporfechas(fechainicial, fechafinal);
    }

    public Asignacionestransporte detalleasignacion(int idSolicitud) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.detalleasignacion(idSolicitud);
    }

}
