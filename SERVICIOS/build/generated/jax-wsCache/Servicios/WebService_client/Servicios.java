
package WebService_client;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Servicios", targetNamespace = "http://WebService/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Servicios {


    /**
     * 
     * @param rut
     * @return
     *     returns java.util.List<WebService_client.Reservas>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarReservas", targetNamespace = "http://WebService/", className = "WebService_client.ListarReservas")
    @ResponseWrapper(localName = "listarReservasResponse", targetNamespace = "http://WebService/", className = "WebService_client.ListarReservasResponse")
    @Action(input = "http://WebService/Servicios/listarReservasRequest", output = "http://WebService/Servicios/listarReservasResponse")
    public List<Reservas> listarReservas(
        @WebParam(name = "rut", targetNamespace = "")
        String rut);

    /**
     * 
     * @param descripcion
     * @param estado
     * @param categoria
     * @param producto
     * @param cantidad
     * @param idDepto
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "nuevoinventario", targetNamespace = "http://WebService/", className = "WebService_client.Nuevoinventario")
    @ResponseWrapper(localName = "nuevoinventarioResponse", targetNamespace = "http://WebService/", className = "WebService_client.NuevoinventarioResponse")
    @Action(input = "http://WebService/Servicios/nuevoinventarioRequest", output = "http://WebService/Servicios/nuevoinventarioResponse")
    public String nuevoinventario(
        @WebParam(name = "id_depto", targetNamespace = "")
        String idDepto,
        @WebParam(name = "producto", targetNamespace = "")
        String producto,
        @WebParam(name = "cantidad", targetNamespace = "")
        String cantidad,
        @WebParam(name = "estado", targetNamespace = "")
        String estado,
        @WebParam(name = "descripcion", targetNamespace = "")
        String descripcion,
        @WebParam(name = "categoria", targetNamespace = "")
        String categoria);

    /**
     * 
     * @param ubicacion
     * @return
     *     returns java.util.List<WebService_client.Departamento>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarDeptos", targetNamespace = "http://WebService/", className = "WebService_client.ListarDeptos")
    @ResponseWrapper(localName = "listarDeptosResponse", targetNamespace = "http://WebService/", className = "WebService_client.ListarDeptosResponse")
    @Action(input = "http://WebService/Servicios/listarDeptosRequest", output = "http://WebService/Servicios/listarDeptosResponse")
    public List<Departamento> listarDeptos(
        @WebParam(name = "ubicacion", targetNamespace = "")
        String ubicacion);

    /**
     * 
     * @param clave
     * @param correo
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "validaUsuario", targetNamespace = "http://WebService/", className = "WebService_client.ValidaUsuario")
    @ResponseWrapper(localName = "validaUsuarioResponse", targetNamespace = "http://WebService/", className = "WebService_client.ValidaUsuarioResponse")
    @Action(input = "http://WebService/Servicios/validaUsuarioRequest", output = "http://WebService/Servicios/validaUsuarioResponse")
    public String validaUsuario(
        @WebParam(name = "correo", targetNamespace = "")
        String correo,
        @WebParam(name = "clave", targetNamespace = "")
        String clave);

    /**
     * 
     * @param correo
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "retornarRut", targetNamespace = "http://WebService/", className = "WebService_client.RetornarRut")
    @ResponseWrapper(localName = "retornarRutResponse", targetNamespace = "http://WebService/", className = "WebService_client.RetornarRutResponse")
    @Action(input = "http://WebService/Servicios/retornarRutRequest", output = "http://WebService/Servicios/retornarRutResponse")
    public String retornarRut(
        @WebParam(name = "correo", targetNamespace = "")
        String correo);

    /**
     * 
     * @param correo
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "retornarNombre", targetNamespace = "http://WebService/", className = "WebService_client.RetornarNombre")
    @ResponseWrapper(localName = "retornarNombreResponse", targetNamespace = "http://WebService/", className = "WebService_client.RetornarNombreResponse")
    @Action(input = "http://WebService/Servicios/retornarNombreRequest", output = "http://WebService/Servicios/retornarNombreResponse")
    public String retornarNombre(
        @WebParam(name = "correo", targetNamespace = "")
        String correo);

    /**
     * 
     * @param id
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "eliminarUsuario", targetNamespace = "http://WebService/", className = "WebService_client.EliminarUsuario")
    @ResponseWrapper(localName = "eliminarUsuarioResponse", targetNamespace = "http://WebService/", className = "WebService_client.EliminarUsuarioResponse")
    @Action(input = "http://WebService/Servicios/eliminarUsuarioRequest", output = "http://WebService/Servicios/eliminarUsuarioResponse")
    public String eliminarUsuario(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param rut
     * @param idDepartamento
     * @param cantidadPersonas
     * @param fechaSalida
     * @param fechaReserva
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "agregarReserva", targetNamespace = "http://WebService/", className = "WebService_client.AgregarReserva")
    @ResponseWrapper(localName = "agregarReservaResponse", targetNamespace = "http://WebService/", className = "WebService_client.AgregarReservaResponse")
    @Action(input = "http://WebService/Servicios/agregarReservaRequest", output = "http://WebService/Servicios/agregarReservaResponse")
    public String agregarReserva(
        @WebParam(name = "fecha_reserva", targetNamespace = "")
        String fechaReserva,
        @WebParam(name = "cantidad_personas", targetNamespace = "")
        String cantidadPersonas,
        @WebParam(name = "fecha_salida", targetNamespace = "")
        String fechaSalida,
        @WebParam(name = "rut", targetNamespace = "")
        String rut,
        @WebParam(name = "id_departamento", targetNamespace = "")
        String idDepartamento);

    /**
     * 
     * @param rut
     * @param clave
     * @param correo
     * @param telefono
     * @param nombre
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "modificarUsuario", targetNamespace = "http://WebService/", className = "WebService_client.ModificarUsuario")
    @ResponseWrapper(localName = "modificarUsuarioResponse", targetNamespace = "http://WebService/", className = "WebService_client.ModificarUsuarioResponse")
    @Action(input = "http://WebService/Servicios/modificarUsuarioRequest", output = "http://WebService/Servicios/modificarUsuarioResponse")
    public String modificarUsuario(
        @WebParam(name = "rut", targetNamespace = "")
        String rut,
        @WebParam(name = "nombre", targetNamespace = "")
        String nombre,
        @WebParam(name = "correo", targetNamespace = "")
        String correo,
        @WebParam(name = "telefono", targetNamespace = "")
        String telefono,
        @WebParam(name = "clave", targetNamespace = "")
        String clave);

    /**
     * 
     * @param id
     * @return
     *     returns java.util.List<WebService_client.Inventarios>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarInventario", targetNamespace = "http://WebService/", className = "WebService_client.ListarInventario")
    @ResponseWrapper(localName = "listarInventarioResponse", targetNamespace = "http://WebService/", className = "WebService_client.ListarInventarioResponse")
    @Action(input = "http://WebService/Servicios/listarInventarioRequest", output = "http://WebService/Servicios/listarInventarioResponse")
    public List<Inventarios> listarInventario(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param idDepartamento
     * @param precio
     * @param nombreSrv
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "nuevoservicio", targetNamespace = "http://WebService/", className = "WebService_client.Nuevoservicio")
    @ResponseWrapper(localName = "nuevoservicioResponse", targetNamespace = "http://WebService/", className = "WebService_client.NuevoservicioResponse")
    @Action(input = "http://WebService/Servicios/nuevoservicioRequest", output = "http://WebService/Servicios/nuevoservicioResponse")
    public String nuevoservicio(
        @WebParam(name = "nombre_srv", targetNamespace = "")
        String nombreSrv,
        @WebParam(name = "precio", targetNamespace = "")
        float precio,
        @WebParam(name = "id_departamento", targetNamespace = "")
        String idDepartamento);

    /**
     * 
     * @return
     *     returns java.util.List<WebService_client.Usuario>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarcuentas", targetNamespace = "http://WebService/", className = "WebService_client.Listarcuentas")
    @ResponseWrapper(localName = "listarcuentasResponse", targetNamespace = "http://WebService/", className = "WebService_client.ListarcuentasResponse")
    @Action(input = "http://WebService/Servicios/listarcuentasRequest", output = "http://WebService/Servicios/listarcuentasResponse")
    public List<Usuario> listarcuentas();

    /**
     * 
     * @param id
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "eliminarservicio", targetNamespace = "http://WebService/", className = "WebService_client.Eliminarservicio")
    @ResponseWrapper(localName = "eliminarservicioResponse", targetNamespace = "http://WebService/", className = "WebService_client.EliminarservicioResponse")
    @Action(input = "http://WebService/Servicios/eliminarservicioRequest", output = "http://WebService/Servicios/eliminarservicioResponse")
    public String eliminarservicio(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param id
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "eliminarinventario", targetNamespace = "http://WebService/", className = "WebService_client.Eliminarinventario")
    @ResponseWrapper(localName = "eliminarinventarioResponse", targetNamespace = "http://WebService/", className = "WebService_client.EliminarinventarioResponse")
    @Action(input = "http://WebService/Servicios/eliminarinventarioRequest", output = "http://WebService/Servicios/eliminarinventarioResponse")
    public String eliminarinventario(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @return
     *     returns java.util.List<WebService_client.Categoria>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarcategorias", targetNamespace = "http://WebService/", className = "WebService_client.Listarcategorias")
    @ResponseWrapper(localName = "listarcategoriasResponse", targetNamespace = "http://WebService/", className = "WebService_client.ListarcategoriasResponse")
    @Action(input = "http://WebService/Servicios/listarcategoriasRequest", output = "http://WebService/Servicios/listarcategoriasResponse")
    public List<Categoria> listarcategorias();

    /**
     * 
     * @param id
     * @return
     *     returns java.util.List<WebService_client.Serviciosdepto>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarServicios", targetNamespace = "http://WebService/", className = "WebService_client.ListarServicios")
    @ResponseWrapper(localName = "listarServiciosResponse", targetNamespace = "http://WebService/", className = "WebService_client.ListarServiciosResponse")
    @Action(input = "http://WebService/Servicios/listarServiciosRequest", output = "http://WebService/Servicios/listarServiciosResponse")
    public List<Serviciosdepto> listarServicios(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param id
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "Eliminardepartamento")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Eliminardepartamento", targetNamespace = "http://WebService/", className = "WebService_client.Eliminardepartamento")
    @ResponseWrapper(localName = "EliminardepartamentoResponse", targetNamespace = "http://WebService/", className = "WebService_client.EliminardepartamentoResponse")
    @Action(input = "http://WebService/Servicios/EliminardepartamentoRequest", output = "http://WebService/Servicios/EliminardepartamentoResponse")
    public String eliminardepartamento(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param id
     * @return
     *     returns WebService_client.Departamento
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarpordepartamento", targetNamespace = "http://WebService/", className = "WebService_client.Listarpordepartamento")
    @ResponseWrapper(localName = "listarpordepartamentoResponse", targetNamespace = "http://WebService/", className = "WebService_client.ListarpordepartamentoResponse")
    @Action(input = "http://WebService/Servicios/listarpordepartamentoRequest", output = "http://WebService/Servicios/listarpordepartamentoResponse")
    public Departamento listarpordepartamento(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @return
     *     returns java.util.List<WebService_client.Departamento>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listardepartamentos", targetNamespace = "http://WebService/", className = "WebService_client.Listardepartamentos")
    @ResponseWrapper(localName = "listardepartamentosResponse", targetNamespace = "http://WebService/", className = "WebService_client.ListardepartamentosResponse")
    @Action(input = "http://WebService/Servicios/listardepartamentosRequest", output = "http://WebService/Servicios/listardepartamentosResponse")
    public List<Departamento> listardepartamentos();

    /**
     * 
     * @param descripcion
     * @param banos
     * @param fecha
     * @param ubicacion
     * @param habitaciones
     * @param direccion
     * @param valorarriendo
     * @param id
     * @param nombre
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "Actualizardepartamento")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Actualizardepartamento", targetNamespace = "http://WebService/", className = "WebService_client.Actualizardepartamento")
    @ResponseWrapper(localName = "ActualizardepartamentoResponse", targetNamespace = "http://WebService/", className = "WebService_client.ActualizardepartamentoResponse")
    @Action(input = "http://WebService/Servicios/ActualizardepartamentoRequest", output = "http://WebService/Servicios/ActualizardepartamentoResponse")
    public String actualizardepartamento(
        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "nombre", targetNamespace = "")
        String nombre,
        @WebParam(name = "ubicacion", targetNamespace = "")
        String ubicacion,
        @WebParam(name = "banos", targetNamespace = "")
        String banos,
        @WebParam(name = "habitaciones", targetNamespace = "")
        String habitaciones,
        @WebParam(name = "valorarriendo", targetNamespace = "")
        float valorarriendo,
        @WebParam(name = "descripcion", targetNamespace = "")
        String descripcion,
        @WebParam(name = "fecha", targetNamespace = "")
        String fecha,
        @WebParam(name = "direccion", targetNamespace = "")
        String direccion);

    /**
     * 
     * @param descripcion
     * @param banos
     * @param fecha
     * @param ubicacion
     * @param habitaciones
     * @param direccion
     * @param valorarriendo
     * @param nombre
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "agregardepartamento", targetNamespace = "http://WebService/", className = "WebService_client.Agregardepartamento")
    @ResponseWrapper(localName = "agregardepartamentoResponse", targetNamespace = "http://WebService/", className = "WebService_client.AgregardepartamentoResponse")
    @Action(input = "http://WebService/Servicios/agregardepartamentoRequest", output = "http://WebService/Servicios/agregardepartamentoResponse")
    public String agregardepartamento(
        @WebParam(name = "nombre", targetNamespace = "")
        String nombre,
        @WebParam(name = "ubicacion", targetNamespace = "")
        String ubicacion,
        @WebParam(name = "banos", targetNamespace = "")
        String banos,
        @WebParam(name = "habitaciones", targetNamespace = "")
        String habitaciones,
        @WebParam(name = "valorarriendo", targetNamespace = "")
        float valorarriendo,
        @WebParam(name = "descripcion", targetNamespace = "")
        String descripcion,
        @WebParam(name = "fecha", targetNamespace = "")
        String fecha,
        @WebParam(name = "direccion", targetNamespace = "")
        String direccion);

    /**
     * 
     * @return
     *     returns java.util.List<WebService_client.Localidad>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarLocalidades", targetNamespace = "http://WebService/", className = "WebService_client.ListarLocalidades")
    @ResponseWrapper(localName = "listarLocalidadesResponse", targetNamespace = "http://WebService/", className = "WebService_client.ListarLocalidadesResponse")
    @Action(input = "http://WebService/Servicios/listarLocalidadesRequest", output = "http://WebService/Servicios/listarLocalidadesResponse")
    public List<Localidad> listarLocalidades();

    /**
     * 
     * @param id
     * @return
     *     returns java.util.List<WebService_client.Reservasdepto>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarreservadepartamento", targetNamespace = "http://WebService/", className = "WebService_client.Listarreservadepartamento")
    @ResponseWrapper(localName = "listarreservadepartamentoResponse", targetNamespace = "http://WebService/", className = "WebService_client.ListarreservadepartamentoResponse")
    @Action(input = "http://WebService/Servicios/listarreservadepartamentoRequest", output = "http://WebService/Servicios/listarreservadepartamentoResponse")
    public List<Reservasdepto> listarreservadepartamento(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param id
     * @param habilitado
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "actualizarestadodepartamento", targetNamespace = "http://WebService/", className = "WebService_client.Actualizarestadodepartamento")
    @ResponseWrapper(localName = "actualizarestadodepartamentoResponse", targetNamespace = "http://WebService/", className = "WebService_client.ActualizarestadodepartamentoResponse")
    @Action(input = "http://WebService/Servicios/actualizarestadodepartamentoRequest", output = "http://WebService/Servicios/actualizarestadodepartamentoResponse")
    public String actualizarestadodepartamento(
        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "habilitado", targetNamespace = "")
        String habilitado);

    /**
     * 
     * @return
     *     returns java.util.List<WebService_client.Departamento>
     */
    @WebMethod(operationName = "ListarHabilitados")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ListarHabilitados", targetNamespace = "http://WebService/", className = "WebService_client.ListarHabilitados")
    @ResponseWrapper(localName = "ListarHabilitadosResponse", targetNamespace = "http://WebService/", className = "WebService_client.ListarHabilitadosResponse")
    @Action(input = "http://WebService/Servicios/ListarHabilitadosRequest", output = "http://WebService/Servicios/ListarHabilitadosResponse")
    public List<Departamento> listarHabilitados();

    /**
     * 
     * @param idReserva
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "eliminarReserva", targetNamespace = "http://WebService/", className = "WebService_client.EliminarReserva")
    @ResponseWrapper(localName = "eliminarReservaResponse", targetNamespace = "http://WebService/", className = "WebService_client.EliminarReservaResponse")
    @Action(input = "http://WebService/Servicios/eliminarReservaRequest", output = "http://WebService/Servicios/eliminarReservaResponse")
    public String eliminarReserva(
        @WebParam(name = "id_reserva", targetNamespace = "")
        int idReserva);

    /**
     * 
     * @return
     *     returns java.util.List<WebService_client.Usuario>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarclientes", targetNamespace = "http://WebService/", className = "WebService_client.Listarclientes")
    @ResponseWrapper(localName = "listarclientesResponse", targetNamespace = "http://WebService/", className = "WebService_client.ListarclientesResponse")
    @Action(input = "http://WebService/Servicios/listarclientesRequest", output = "http://WebService/Servicios/listarclientesResponse")
    public List<Usuario> listarclientes();

    /**
     * 
     * @param rut
     * @param clave
     * @param idRol
     * @param correo
     * @param telefono
     * @param nombre
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "CrearCuenta")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "CrearCuenta", targetNamespace = "http://WebService/", className = "WebService_client.CrearCuenta")
    @ResponseWrapper(localName = "CrearCuentaResponse", targetNamespace = "http://WebService/", className = "WebService_client.CrearCuentaResponse")
    @Action(input = "http://WebService/Servicios/CrearCuentaRequest", output = "http://WebService/Servicios/CrearCuentaResponse")
    public String crearCuenta(
        @WebParam(name = "rut", targetNamespace = "")
        String rut,
        @WebParam(name = "nombre", targetNamespace = "")
        String nombre,
        @WebParam(name = "correo", targetNamespace = "")
        String correo,
        @WebParam(name = "telefono", targetNamespace = "")
        String telefono,
        @WebParam(name = "clave", targetNamespace = "")
        String clave,
        @WebParam(name = "id_rol", targetNamespace = "")
        int idRol);

    /**
     * 
     * @param rut
     * @return
     *     returns WebService_client.Usuario
     */
    @WebMethod(operationName = "Mostrarporrut")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Mostrarporrut", targetNamespace = "http://WebService/", className = "WebService_client.Mostrarporrut")
    @ResponseWrapper(localName = "MostrarporrutResponse", targetNamespace = "http://WebService/", className = "WebService_client.MostrarporrutResponse")
    @Action(input = "http://WebService/Servicios/MostrarporrutRequest", output = "http://WebService/Servicios/MostrarporrutResponse")
    public Usuario mostrarporrut(
        @WebParam(name = "rut", targetNamespace = "")
        String rut);

    /**
     * 
     * @return
     *     returns java.util.List<WebService_client.Usuario>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarusuarios", targetNamespace = "http://WebService/", className = "WebService_client.Listarusuarios")
    @ResponseWrapper(localName = "listarusuariosResponse", targetNamespace = "http://WebService/", className = "WebService_client.ListarusuariosResponse")
    @Action(input = "http://WebService/Servicios/listarusuariosRequest", output = "http://WebService/Servicios/listarusuariosResponse")
    public List<Usuario> listarusuarios();

}
