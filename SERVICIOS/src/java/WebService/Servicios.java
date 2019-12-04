/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import DAO.CheckinDAO;
import DAO.CheckoutDAO;
import DAO.CuentasDAO;
import DAO.DepartamentoDAO;
import DAO.InventarioDAO;
import DAO.ReservaDAO;
import DAO.ServicioDAO;
import DAO.SolicitudtransporteDAO;
import Modelo.Categoria;
import Modelo.Checkin;
import Modelo.Checkout;
import Modelo.Departamento;
import Modelo.Inventario;
import Modelo.Inventarios;
import Modelo.Localidad;
import Modelo.Reserva;
import Modelo.Reservas;
import Modelo.Reservasdepto;
import Modelo.Servicioreserva;
import Modelo.Serviciosdepto;
import Modelo.Solicitudes;
import Modelo.Solicitudtransporte;
import Modelo.Usuario;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author torre
 */
@WebService(serviceName = "Servicios")
public class Servicios {

    DepartamentoDAO ddao = new DepartamentoDAO();
    ReservaDAO rdao = new ReservaDAO();
    InventarioDAO indao = new InventarioDAO();
    CuentasDAO cuentas = new CuentasDAO();
    ServicioDAO srv = new ServicioDAO();
    CheckinDAO ch = new CheckinDAO();
    CheckoutDAO chout = new CheckoutDAO();
    SolicitudtransporteDAO st = new SolicitudtransporteDAO();

    @WebMethod(operationName = "listardepartamentos")
    public List<Departamento> listardepartamentos() {
        List datos = ddao.Listar();
        return datos;
    }

    @WebMethod(operationName = "ListarHabilitados")
    public List<Departamento> ListarHabilitados() {
        List datos = ddao.ListarHabilitados();
        return datos;
    }

    /**
     * Web service operation
     *
     * @param nombre
     * @param ubicacion
     * @param banos
     * @param habitaciones
     * @param valorarriendo
     * @param descripcion
     * @param fecha
     * @param direccion
     * @return
     */
    @WebMethod(operationName = "agregardepartamento")
    public String agregardepartamento(@WebParam(name = "nombre") String nombre, @WebParam(name = "ubicacion") String ubicacion, @WebParam(name = "banos") String banos, @WebParam(name = "habitaciones") String habitaciones, @WebParam(name = "valorarriendo") String valorarriendo, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "fecha") String fecha, @WebParam(name = "direccion") String direccion) {
        String datos = ddao.add(nombre, ubicacion, banos, habitaciones, valorarriendo, descripcion, fecha, direccion);
        return datos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listarpordepartamento")
    public Departamento listarpordepartamento(@WebParam(name = "id") int id) {
        Departamento departamento = ddao.listarID(id);
        return departamento;
    }

    /**
     * Web service operation
     *
     * @param id
     * @param nombre
     * @param ubicacion
     * @param banos
     * @param habitaciones
     * @param valorarriendo
     * @param descripcion
     * @param fecha
     * @param direccion
     * @return
     */
    @WebMethod(operationName = "Actualizardepartamento")
    public String Actualizardepartamento(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "ubicacion") String ubicacion, @WebParam(name = "banos") String banos, @WebParam(name = "habitaciones") String habitaciones, @WebParam(name = "valorarriendo") String valorarriendo, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "fecha") String fecha, @WebParam(name = "direccion") String direccion) {
        String datos = ddao.edit(id, nombre, ubicacion, banos, habitaciones, valorarriendo, descripcion, fecha, direccion);
        return datos;
    }

    @WebMethod(operationName = "actualizarestadodepartamento")
    public String actualizarestadodepartamento(@WebParam(name = "id") int id, @WebParam(name = "habilitado") String habilitado) {
        String datos = ddao.actualizarestado(id, habilitado);
        return datos;
    }

    /**
     * Web service operation
     *
     * @param id
     * @return
     */
    @WebMethod(operationName = "Eliminardepartamento")
    public String Eliminardepartamento(@WebParam(name = "id") int id) {
        String datos = ddao.delete(id);
        return datos;
    }

    /**
     * Web service operation
     *
     * @return
     */
    @WebMethod(operationName = "listarLocalidades")
    public List<Localidad> listarLocalidades() {
        List datos = ddao.listarlocalidades();
        return datos;
    }

    /**
     * Web service operation
     *
     * @param rut
     * @return
     */
    @WebMethod(operationName = "listarReservas")
    public List<Reservas> listarReservas(@WebParam(name = "rut") String rut) {
        List datos = rdao.listarreserva(rut);
        return datos;
    }

    @WebMethod(operationName = "agregarReserva")
    public String agregarReserva(@WebParam(name = "fecha_reserva") String fecha_reserva, @WebParam(name = "cantidad_personas") String cantidad_personas, @WebParam(name = "fecha_salida") String fecha_salida, @WebParam(name = "rut") String rut, @WebParam(name = "id_departamento") String id_departamento) {
        String datos = rdao.addReserva(fecha_reserva, cantidad_personas, fecha_salida, rut, id_departamento);
        return datos;
    }

    @WebMethod(operationName = "eliminarReserva")
    public String eliminarReserva(@WebParam(name = "id_reserva") int id_reserva) {
        String datos = rdao.eliminar(id_reserva);
        return datos;
    }

    @WebMethod(operationName = "IDReserva")
    public Reserva IDReserva(@WebParam(name = "id_reserva") int id_reserva) {
        Reserva reserva = rdao.listarIDaddReserva(id_reserva);
        return reserva;
    }

    @WebMethod(operationName = "listarInventario")
    public List<Inventarios> listarInventario(@WebParam(name = "id") int id) {
        List datos = indao.listarInventario(id);
        return datos;
    }

    @WebMethod(operationName = "nuevoinventario")
    public String nuevoinventario(@WebParam(name = "id_depto") String id_depto, @WebParam(name = "producto") String producto, @WebParam(name = "cantidad") String cantidad, @WebParam(name = "estado") String estado, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "categoria") String categoria) {
        String datos = indao.addInventario(id_depto, producto, cantidad, estado, descripcion, categoria);
        return datos;
    }

    @WebMethod(operationName = "eliminarinventario")
    public String eliminarinventario(@WebParam(name = "id") int id) {
        String datos = indao.deleteInventario(id);
        return datos;
    }

    @WebMethod(operationName = "modificarInventario")
    public String modificarInventario(@WebParam(name = "id_inv") int id_inv, @WebParam(name = "producto") String producto, @WebParam(name = "cantidad") String cantidad, @WebParam(name = "estado") String estado, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "categoria") String categoria) {
        String datos = indao.editInventario(id_inv, producto, cantidad, estado, descripcion, categoria);
        return datos;
    }

    @WebMethod(operationName = "detalleinventario")
    public Inventario detalleinventario(@WebParam(name = "id_inv") int id_inv) {
        Inventario inventario = indao.BuscarInventario(id_inv);
        return inventario;
    }

    @WebMethod(operationName = "listarDeptos")
    public List<Departamento> listarDeptos(@WebParam(name = "ubicacion") String ubicacion) {
        List datos = ddao.listarporubicacion(ubicacion);
        return datos;
    }

    @WebMethod(operationName = "listarreservadepartamento")
    public List<Reservasdepto> listarreservadepartamento(@WebParam(name = "id") int id) {
        List datos = ddao.listarreservadepartamento(id);
        return datos;
    }

    @WebMethod(operationName = "CrearCuenta")
    public String CrearCuenta(@WebParam(name = "rut") String rut, @WebParam(name = "nombre") String nombre, @WebParam(name = "correo") String correo, @WebParam(name = "telefono") String telefono, @WebParam(name = "clave") String clave, @WebParam(name = "id_rol") int id_rol) {
        String datos = cuentas.CrearCuenta(rut, nombre, correo, telefono, clave, id_rol);
        return datos;
    }

    @WebMethod(operationName = "modificarUsuario")
    public String modificarUsuario(@WebParam(name = "id_usuario") int id_usuario, @WebParam(name = "rut") String rut, @WebParam(name = "nombre") String nombre, @WebParam(name = "correo") String correo, @WebParam(name = "telefono") String telefono) {
        String datos = cuentas.modificarUsuario(id_usuario, rut, nombre, correo, telefono);
        return datos;
    }

    @WebMethod(operationName = "validaUsuario")
    public String validaUsuario(@WebParam(name = "correo") String correo, @WebParam(name = "clave") String clave) {
        String datos = cuentas.validaUsuario(correo, clave);
        return datos;
    }

    @WebMethod(operationName = "retornarRut")
    public String retornarRut(@WebParam(name = "correo") String correo) {
        String datos = cuentas.retornarRut(correo);
        return datos;
    }

    @WebMethod(operationName = "retornarNombre")
    public String retornarNombre(@WebParam(name = "correo") String correo) {
        String datos = cuentas.retornarNombre(correo);
        return datos;
    }

    @WebMethod(operationName = "eliminarUsuario")
    public String eliminarUsuario(@WebParam(name = "id") int id) {
        String datos = cuentas.eliminarUsuario(id);
        return datos;
    }

    @WebMethod(operationName = "listarusuarios")
    public List<Usuario> listarusuarios() {
        List datos = cuentas.listarUsuarios();
        return datos;
    }

    @WebMethod(operationName = "listarclientes")
    public List<Usuario> listarclientes() {
        List datos = cuentas.listarClientes();
        return datos;
    }

    @WebMethod(operationName = "listarcuentas")
    public List<Usuario> listarcuentas() {
        List datos = cuentas.listarCuentas();
        return datos;
    }

    @WebMethod(operationName = "Mostrarporrut")
    public Usuario Mostrarporrut(@WebParam(name = "rut") String rut) {
        Usuario usuario = cuentas.Mostrarporrut(rut);
        return usuario;
    }

    @WebMethod(operationName = "listarcategorias")
    public List<Categoria> listarcategorias() {
        List datos = indao.listarcategorias();
        return datos;
    }

    @WebMethod(operationName = "listarServicios")
    public List<Serviciosdepto> listarServicios(@WebParam(name = "id") int id) {
        List datos = srv.listarServicios(id);
        return datos;
    }

    @WebMethod(operationName = "nuevoservicio")
    public String nuevoservicio(@WebParam(name = "nombre_srv") String nombre_srv, @WebParam(name = "precio") String precio, @WebParam(name = "id_departamento") String id_departamento) {
        String datos = srv.addServicio(nombre_srv, precio, id_departamento);
        return datos;
    }

    @WebMethod(operationName = "contratarservicio")
    public String contratarservicio(@WebParam(name = "fecha_contratacion") String fecha_contratacion, @WebParam(name = "id_srv") String id_srv, @WebParam(name = "id_reserva") String id_reserva) {
        String datos = srv.contratarservicio(fecha_contratacion, id_srv, id_reserva);
        return datos;
    }

    @WebMethod(operationName = "servicioscontratados")
    public List<Servicioreserva> servicioscontratados(@WebParam(name = "id_reserva") String id_reserva) {
        List datos = srv.servicioscontratados(id_reserva);
        return datos;
    }

    @WebMethod(operationName = "listarserv")
    public List<Serviciosdepto> listarserv() {
        List datos = srv.listarserv();
        return datos;
    }

    @WebMethod(operationName = "eliminarservicio")
    public String eliminarservicio(@WebParam(name = "id") int id) {
        String datos = srv.deleteServicio(id);
        return datos;
    }

    @WebMethod(operationName = "BuscarServicio")
    public Serviciosdepto BuscarServicio(@WebParam(name = "id") int id) {
        Serviciosdepto servicio = srv.BuscarServicio(id);
        return servicio;
    }

    @WebMethod(operationName = "modificarServicio")
    public String modificarServicio(@WebParam(name = "id_srv") int id_srv, @WebParam(name = "nombre_srv") String nombre_srv, @WebParam(name = "precio") String precio) {
        String datos = srv.editServicio(id_srv, nombre_srv, precio);
        return datos;
    }

    @WebMethod(operationName = "nuevocheckin")
    public String nuevocheckin(@WebParam(name = "fecha_checkin") String fecha_checkin, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "id_reserva") String id_reserva) {
        String datos = ch.nuevocheckin(fecha_checkin, descripcion, id_reserva);
        return datos;
    }

    @WebMethod(operationName = "ListarCheckin")
    public Checkin ListarCheckin(@WebParam(name = "id_reserva") String id_reserva) {
        Checkin checkin = ch.ListarCheckin(id_reserva);
        return checkin;
    }

    @WebMethod(operationName = "nuevocheckout")
    public String nuevocheckout(@WebParam(name = "fecha_checkout") String fecha_checkout, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "id_reserva") String id_reserva) {
        String datos = chout.nuevocheckout(fecha_checkout, descripcion, id_reserva);
        return datos;
    }

    @WebMethod(operationName = "ListarCheckout")
    public Checkout ListarCheckout(@WebParam(name = "id_reserva") String id_reserva) {
        Checkout checkout = chout.ListarCheckout(id_reserva);
        return checkout;
    }

    @WebMethod(operationName = "listarmissolicitudes")
    public List<Solicitudtransporte> listarmissolicitudes(@WebParam(name = "id_reserva") String id_reserva) {
        List datos = st.listarmissolicitudes(id_reserva);
        return datos;
    }

    @WebMethod(operationName = "nuevasolicitud")
    public String nuevasolicitud(@WebParam(name = "id_reserva") String id_reserva, @WebParam(name = "fecha_solicitud") String fecha_solicitud, @WebParam(name = "hora_solicitud") String hora_solicitud, @WebParam(name = "origen") String origen, @WebParam(name = "destino") String destino) {
        String datos = st.nuevasolicitud(id_reserva, fecha_solicitud, hora_solicitud, origen, destino);
        return datos;
    }

    @WebMethod(operationName = "listarsolicitudes")
    public List<Solicitudes> listarsolicitudes() {
        List datos = st.Listarsolicitudes();
        return datos;
    }

    @WebMethod(operationName = "nuevaplanificacion")
    public String nuevaplanificacion(@WebParam(name = "id_solicitud") String id_solicitud, @WebParam(name = "conductor") String conductor, @WebParam(name = "auto") String auto, @WebParam(name = "patente") String patente) {
        String datos = st.nuevaplanificacion(id_solicitud, conductor, auto, patente);
        return datos;
    }

    @WebMethod(operationName = "actualizarestadosolicitud")
    public String actualizarestadosolicitud(@WebParam(name = "id_solicitud") int id_solicitud, @WebParam(name = "estado") String estado) {
        String datos = st.actualizarestado(id_solicitud, estado);
        return datos;
    }

    @WebMethod(operationName = "Listar3omaspersonas")
    public List<Reservas> Listar3omaspersonas() {
        List datos = rdao.Listar3omaspersonas();
        return datos;
    }

    @WebMethod(operationName = "listarreservasporfechas")
    public List<Reservas> listarreservasporfechas(@WebParam(name = "fechainicial") String fechainicial, @WebParam(name = "fechafinal") String fechafinal) {
        List datos = rdao.listarreservasporfechas(fechainicial, fechafinal);
        return datos;
    }

    @WebMethod(operationName = "listarreservaspornumeropersonas")
    public List<Reservas> listarreservaspornumeropersonas(@WebParam(name = "cantidad_personas") String cantidad_personas) {
        List datos = rdao.listarreservaspornumeropersonas(cantidad_personas);
        return datos;
    }
    
        @WebMethod(operationName = "listarreservasporcomuna")
    public List<Reservas> listarreservasporcomuna(@WebParam(name = "comuna") String comuna) {
        List datos = rdao.listarreservasporcomuna(comuna);
        return datos;
    }

    @WebMethod(operationName = "listarsolicitudesporfechas")
    public List<Solicitudes> listarsolicitudesporfechas(@WebParam(name = "fechainicial") String fechainicial, @WebParam(name = "fechafinal") String fechafinal) {
        List datos = st.listarsolicitudesporfechas(fechainicial, fechafinal);
        return datos;
    }
}
