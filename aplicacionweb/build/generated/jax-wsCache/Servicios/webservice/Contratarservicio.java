
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para contratarservicio complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="contratarservicio"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="fecha_contratacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id_srv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "contratarservicio", propOrder = {
    "fechaContratacion",
    "idSrv",
    "idReserva"
})
public class Contratarservicio {

    @XmlElement(name = "fecha_contratacion")
    protected String fechaContratacion;
    @XmlElement(name = "id_srv")
    protected String idSrv;
    @XmlElement(name = "id_reserva")
    protected String idReserva;

    /**
     * Obtiene el valor de la propiedad fechaContratacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaContratacion() {
        return fechaContratacion;
    }

    /**
     * Define el valor de la propiedad fechaContratacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaContratacion(String value) {
        this.fechaContratacion = value;
    }

    /**
     * Obtiene el valor de la propiedad idSrv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdSrv() {
        return idSrv;
    }

    /**
     * Define el valor de la propiedad idSrv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdSrv(String value) {
        this.idSrv = value;
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
