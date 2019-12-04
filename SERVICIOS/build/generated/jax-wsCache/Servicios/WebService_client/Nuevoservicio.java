
package WebService_client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para nuevoservicio complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="nuevoservicio"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nombre_srv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="precio" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="id_departamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nuevoservicio", propOrder = {
    "nombreSrv",
    "precio",
    "idDepartamento"
})
public class Nuevoservicio {

    @XmlElement(name = "nombre_srv")
    protected String nombreSrv;
    protected float precio;
    @XmlElement(name = "id_departamento")
    protected String idDepartamento;

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
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Define el valor de la propiedad precio.
     * 
     */
    public void setPrecio(float value) {
        this.precio = value;
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

}
