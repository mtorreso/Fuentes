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
public class Serviciosdepto {
    
    //Atributos
    int id_srv;
    String nombre_srv;
    String precio;
    int id_departamento;
    
    public Serviciosdepto(){
        
    }

    public Serviciosdepto(int id_srv, String nombre_srv, String precio, int id_departamento) {
        this.id_srv = id_srv;
        this.nombre_srv = nombre_srv;
        this.precio = precio;
        this.id_departamento = id_departamento;
    }

    public int getId_srv() {
        return id_srv;
    }

    public void setId_srv(int id_srv) {
        this.id_srv = id_srv;
    }

    public String getNombre_srv() {
        return nombre_srv;
    }

    public void setNombre_srv(String nombre_srv) {
        this.nombre_srv = nombre_srv;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

   
    
}
