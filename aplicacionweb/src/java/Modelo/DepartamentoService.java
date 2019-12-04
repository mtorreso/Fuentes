/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import webservice.Departamento;

/**
 *
 * @author torre
 */
public class DepartamentoService {

    public DepartamentoService() {

    }

    public java.util.List<webservice.Departamento> listardepartamentos() {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.listardepartamentos();
    }

    public java.util.List<webservice.Departamento> listarDeptos(java.lang.String ubicacion) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.listarDeptos(ubicacion);
    }

    public java.util.List<webservice.Departamento> listarHabilitados() {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.listarHabilitados();
    }

    public String agregardepartamento(java.lang.String nombre, java.lang.String ubicacion, java.lang.String banos, java.lang.String habitaciones, java.lang.String valorarriendo, java.lang.String descripcion, java.lang.String fecha, java.lang.String direccion) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.agregardepartamento(nombre, ubicacion, banos, habitaciones, valorarriendo, descripcion, fecha, direccion);
    }

    public String actualizardepartamento(int id, java.lang.String nombre, java.lang.String ubicacion, java.lang.String banos, java.lang.String habitaciones, java.lang.String valorarriendo, java.lang.String descripcion, java.lang.String fecha, java.lang.String direccion) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.actualizardepartamento(id, nombre, ubicacion, banos, habitaciones, valorarriendo, descripcion, fecha, direccion);
    }

    public Departamento listarpordepartamento(int id) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.listarpordepartamento(id);
    }

    public String actualizarestadodepartamento(int id, java.lang.String habilitado) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.actualizarestadodepartamento(id, habilitado);
    }

    public String eliminardepartamento(int id) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.eliminardepartamento(id);
    }

    public java.util.List<webservice.Reservasdepto> listarreservadepartamento(int id) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.listarreservadepartamento(id);
    }

}
