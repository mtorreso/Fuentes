
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para checkout complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="checkout"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fecha_checkout" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id_checkout" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="id_reserva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkout", propOrder = {
    "descripcion",
    "fechaCheckout",
    "idCheckout",
    "idReserva"
})
public class Checkout {

    protected String descripcion;
    @XmlElement(name = "fecha_checkout")
    protected String fechaCheckout;
    @XmlElement(name = "id_checkout")
    protected int idCheckout;
    @XmlElement(name = "id_reserva")
    protected String idReserva;

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
     * Obtiene el valor de la propiedad fechaCheckout.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaCheckout() {
        return fechaCheckout;
    }

    /**
     * Define el valor de la propiedad fechaCheckout.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaCheckout(String value) {
        this.fechaCheckout = value;
    }

    /**
     * Obtiene el valor de la propiedad idCheckout.
     * 
     */
    public int getIdCheckout() {
        return idCheckout;
    }

    /**
     * Define el valor de la propiedad idCheckout.
     * 
     */
    public void setIdCheckout(int value) {
        this.idCheckout = value;
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

}
