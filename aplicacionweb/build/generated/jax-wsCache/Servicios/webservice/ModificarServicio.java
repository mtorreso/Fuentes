
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para modificarServicio complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="modificarServicio"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id_srv" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nombre_srv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="precio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modificarServicio", propOrder = {
    "idSrv",
    "nombreSrv",
    "precio"
})
public class ModificarServicio {

    @XmlElement(name = "id_srv")
    protected int idSrv;
    @XmlElement(name = "nombre_srv")
    protected String nombreSrv;
    protected String precio;

    /**
     * Obtiene el valor de la propiedad idSrv.
     * 
     */
    public int getIdSrv() {
        return idSrv;
    }

    /**
     * Define el valor de la propiedad idSrv.
     * 
     */
    public void setIdSrv(int value) {
        this.idSrv = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreSrv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreSrv() {
        return nombreSrv;
    }

    /**
     * Define el valor de la propiedad nombreSrv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreSrv(String value) {
        this.nombreSrv = value;
    }

    /**
     * Obtiene el valor de la propiedad precio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * Define el valor de la propiedad precio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrecio(String value) {
        this.precio = value;
    }

}
