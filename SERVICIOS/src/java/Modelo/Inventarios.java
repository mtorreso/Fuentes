/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Manuel
 */
public class Inventarios {
    int id_inv;
    String id_depto;
    String producto;
    String cantidad;
    String estado;
    String categoria;
    String descripcion;
    int codigo;
    String nombre;
    String ubicacion;
    
    public Inventarios(){
        
    }

    public Inventarios(int id_inv, String id_depto, String producto, String cantidad, String estado, String categoria, String descripcion, int codigo, String nombre, String ubicacion) {
        this.id_inv = id_inv;
        this.id_depto = id_depto;
        this.producto = producto;
        this.cantidad = cantidad;
        this.estado = estado;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public int getId_inv() {
        return id_inv;
    }

    public void setId_inv(int id_inv) {
        this.id_inv = id_inv;
    }

    public String getId_depto() {
        return id_depto;
    }

    public void setId_depto(String id_depto) {
        this.id_depto = id_depto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    
    
}

    