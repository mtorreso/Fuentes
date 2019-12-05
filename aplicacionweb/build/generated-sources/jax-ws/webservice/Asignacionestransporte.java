
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para asignacionestransporte complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="asignacionestransporte"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="auto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cantidad_personas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="conductor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="correo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="destino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fecha_reserva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fecha_salida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fecha_solicitud" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="hora_solicitud" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id_departamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id_reserva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id_solicitud" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="origen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="patente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="rut" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="telefono" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "asignacionestransporte", propOrder = {
    "auto",
    "cantidadPersonas",
    "conductor",
    "correo",
    "destino",
    "estado",
    "fechaReserva",
    "fechaSalida",
    "fechaSolicitud",
    "horaSolicitud",
    "idDepartamento",
    "idReserva",
    "idSolicitud",
    "nombre",
    "origen",
    "patente",
    "rut",
    "telefono"
})
public class Asignacionestransporte {

    protected String auto;
    @XmlElement(name = "cantidad_personas")
    protected String cantidadPersonas;
    protected String conductor;
    protected String correo;
    protected String destino;
    protected String estado;
    @XmlElement(name = "fecha_reserva")
    protected String fechaReserva;
    @XmlElement(name = "fecha_salida")
    protected String fechaSalida;
    @XmlElement(name = "fecha_solicitud")
    protected String fechaSolicitud;
    @XmlElement(name = "hora_solicitud")
    protected String horaSolicitud;
    @XmlElement(name = "id_departamento")
    protected String idDepartamento;
    @XmlElement(name = "id_reserva")
    protected String idReserva;
    @XmlElement(name = "id_solicitud")
    protected int idSolicitud;
    protected String nombre;
    protected String origen;
    protected String patente;
    protected String rut;
    protected String telefono;

    /**
     * Obtiene el valor de la propiedad auto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuto() {
        return auto;
    }

    /**
     * Define el valor de la propiedad auto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuto(String value) {
        this.auto = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidadPersonas.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCantidadPersonas() {
        return cantidadPersonas;
    }

    /**
     * Define el valor de la propiedad cantidadPersonas.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCantidadPersonas(String value) {
        this.cantidadPersonas = value;
    }

    /**
     * Obtiene el valor de la propiedad conductor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConductor() {
        return conductor;
    }

    /**
     * Define el valor de la propiedad conductor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConductor(String value) {
        this.conductor = value;
    }

    /**
     * Obtiene el valor de la propiedad correo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Define el valor de la propiedad correo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorreo(String value) {
        this.correo = value;
    }

    /**
     * Obtiene el valor de la propiedad destino.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Define el valor de la propiedad destino.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestino(String value) {
        this.destino = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaReserva.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaReserva() {
        return fechaReserva;
    }

    /**
     * Define el valor de la propiedad fechaReserva.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaReserva(String value) {
        this.fechaReserva = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaSalida.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Define el valor de la propiedad fechaSalida.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaSalida(String value) {
        this.fechaSalida = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaSolicitud.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    /**
     * Define el valor de la propiedad fechaSolicitud.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaSolicitud(String value) {
        this.fechaSolicitud = value;
    }

    /**
     * Obtiene el valor de la propiedad horaSolicitud.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHoraSolicitud() {
        return horaSolicitud;
    }

    /**
     * Define el valor de la propiedad horaSolicitud.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoraSolicitud(String value) {
        this.horaSolicitud = value;
    }

    /**
     * Obtiene el valor de la propiedad idDepartamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdDepartamento() {
        return idDepartamento;
    }

    /**
     * Define el valor de la propiedad idDepartamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdDepartamento(String value) {
        this.idDepartamento = value;
    }

    /**
     * Obtiene el valor de la propiedad idReserva.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdReserva() {
        return idReserva;
    }

    /**
     * Define el valor de la propiedad idReserva.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdReserva(String value) {
        this.idReserva = value;
    }

    /**
     * Obtiene el valor de la propiedad idSolicitud.
     * 
     */
    public int getIdSolicitud() {
        return idSolicitud;
    }

    /**
     * Define el valor de la propiedad idSolicitud.
     * 
     */
    public void setIdSolicitud(int value) {
        this.idSolicitud = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad origen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * Define el valor de la propiedad origen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigen(String value) {
        this.origen = value;
    }

    /**
     * Obtiene el valor de la propiedad patente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatente() {
        return patente;
    }

    /**
     * Define el valor de la propiedad patente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatente(String value) {
        this.patente = value;
    }

    /**
     * Obtiene el valor de la propiedad rut.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRut() {
        return rut;
    }

    /**
     * Define el valor de la propiedad rut.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRut(String value) {
        this.rut = value;
    }

    /**
     * Obtiene el valor de la propiedad telefono.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Define el valor de la propiedad telefono.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefono(String value) {
        this.telefono = value;
    }

}
