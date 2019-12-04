
package WebService_client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para departamento complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="departamento"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="banos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="direccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="habilitado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="habitaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ubicacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="valorarriendo" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "departamento", propOrder = {
    "banos",
    "descripcion",
    "direccion",
    "fecha",
    "habilitado",
    "habitaciones",
    "id",
    "nombre",
    "ubicacion",
    "valorarriendo"
})
public class Departamento {

    protected String banos;
    protected String descripcion;
    protected String direccion;
    protected String fecha;
    protected String habilitado;
    protected String habitaciones;
    protected int id;
    protected String nombre;
    protected String ubicacion;
    protected float valorarriendo;

    /**
     * Obtiene el valor de la propiedad banos.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBanos() {
        return banos;
    }

    /**
     * Define el valor de la propiedad banos.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBanos(String value) {
        this.banos = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad direccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Define el valor de la propiedad direccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccion(String value) {
        this.direccion = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecha(String value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad habilitado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHabilitado() {
        return habilitado;
    }

    /**
     * Define el valor de la propiedad habilitado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHabilitado(String value) {
        this.habilitado = value;
    }

    /**
     * Obtiene el valor de la propiedad habitaciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHabitaciones() {
        return habitaciones;
    }

    /**
     * Define el valor de la propiedad habitaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHabitaciones(String value) {
        this.habitaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
        this.id = value;
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
     * Obtiene el valor de la propiedad ubicacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Define el valor de la propiedad ubicacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUbicacion(String value) {
        this.ubicacion = value;
    }

    /**
     * Obtiene el valor de la propiedad valorarriendo.
     * 
     */
    public float getValorarriendo() {
        return valorarriendo;
    }

    /**
     * Define el valor de la propiedad valorarriendo.
     * 
     */
    public void setValorarriendo(float value) {
        this.valorarriendo = value;
    }

}
