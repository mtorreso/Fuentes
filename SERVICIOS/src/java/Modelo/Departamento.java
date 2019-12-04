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
public class Departamento {

    int id;    
    String nombre, ubicacion, banos, habitaciones;
    String valorarriendo;
    String descripcion,fecha,direccion;
    String habilitado;
    
    public Departamento(){
        
    }

    public Departamento(int id, String nombre, String ubicacion, String banos, String habitaciones, String valorarriendo, String descripcion, String fecha, String direccion, String habilitado) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.banos = banos;
        this.habitaciones = habitaciones;
        this.valorarriendo = valorarriendo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.direccion = direccion;
        this.habilitado = habilitado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getBanos() {
        return banos;
    }

    public void setBanos(String banos) {
        this.banos = banos;
    }

    public String getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(String habitaciones) {
        this.habitaciones = habitaciones;
    }

    public String getValorarriendo() {
        return valorarriendo;
    }

    public void setValorarriendo(String valorarriendo) {
        this.valorarriendo = valorarriendo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(String habilitado) {
        this.habilitado = habilitado;
    }

   


   
   
    

}
