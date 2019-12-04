/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import webservice.Usuario;

/**
 *
 * @author Manuel
 */
public class CuentasService {

    public CuentasService() {

    }



   public java.util.List<webservice.Usuario> listarclientes() {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.listarclientes();
    }

    public  java.util.List<webservice.Usuario> listarusuarios() {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.listarusuarios();
    }

    public String retornarNombre(java.lang.String correo) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.retornarNombre(correo);
    }

    public String retornarRut(java.lang.String correo) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.retornarRut(correo);
    }

    public String validaUsuario(java.lang.String correo, java.lang.String clave) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.validaUsuario(correo, clave);
    }

    public Usuario mostrarporrut(java.lang.String rut) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.mostrarporrut(rut);
    }



    public java.util.List<webservice.Usuario> listarcuentas() {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.listarcuentas();
    }

    public String modificarUsuario(int idUsuario, java.lang.String rut, java.lang.String nombre, java.lang.String correo, java.lang.String telefono) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.modificarUsuario(idUsuario, rut, nombre, correo, telefono);
    }

    public String eliminarUsuario(int id) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.eliminarUsuario(id);
    }

   public String crearCuenta(java.lang.String rut, java.lang.String nombre, java.lang.String correo, java.lang.String telefono, java.lang.String clave, int idRol) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.crearCuenta(rut, nombre, correo, telefono, clave, idRol);
    }

 

}
