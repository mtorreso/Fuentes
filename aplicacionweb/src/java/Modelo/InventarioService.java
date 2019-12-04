/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import webservice.Inventario;

/**
 *
 * @author Manuel
 */
public class InventarioService {

    public InventarioService() {

    }

    public java.util.List<webservice.Categoria> listarcategorias() {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.listarcategorias();
    }

    public String nuevoinventario(java.lang.String idDepto, java.lang.String producto, java.lang.String cantidad, java.lang.String estado, java.lang.String descripcion, java.lang.String categoria) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.nuevoinventario(idDepto, producto, cantidad, estado, descripcion, categoria);
    }

    public java.util.List<webservice.Inventarios> listarInventario(int id) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.listarInventario(id);
    }

    public String eliminarinventario(int id) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.eliminarinventario(id);
    }

    public Inventario detalleinventario(int idInv) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.detalleinventario(idInv);
    }

    public String modificarInventario(int idInv, java.lang.String producto, java.lang.String cantidad, java.lang.String estado, java.lang.String descripcion, java.lang.String categoria) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.modificarInventario(idInv, producto, cantidad, estado, descripcion, categoria);
    }

}
