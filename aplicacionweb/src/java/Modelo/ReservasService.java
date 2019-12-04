/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import webservice.Reserva;

/**
 *
 * @author Manuel
 */
public class ReservasService {

    public ReservasService() {

    }

    public String agregarReserva(java.lang.String fechaReserva, java.lang.String cantidadPersonas, java.lang.String fechaSalida, java.lang.String rut, java.lang.String idDepartamento) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.agregarReserva(fechaReserva, cantidadPersonas, fechaSalida, rut, idDepartamento);
    }

    public java.util.List<webservice.Reservas> listarReservas(java.lang.String rut) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.listarReservas(rut);
    }

    public Reserva idReserva(int idReserva) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.idReserva(idReserva);
    }

    public String eliminarReserva(int idReserva) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.eliminarReserva(idReserva);
    }

    public java.util.List<webservice.Reservas> listar3Omaspersonas() {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.listar3Omaspersonas();
    }

    public java.util.List<webservice.Reservas> listarreservasporfechas(java.lang.String fechainicial, java.lang.String fechafinal) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.listarreservasporfechas(fechainicial, fechafinal);
    }

    public java.util.List<webservice.Reservas> listarreservaspornumeropersonas(java.lang.String cantidadPersonas) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.listarreservaspornumeropersonas(cantidadPersonas);
    }

   public java.util.List<webservice.Reservas> listarreservasporcomuna(java.lang.String comuna) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.listarreservasporcomuna(comuna);
    }

    

    
    

}
