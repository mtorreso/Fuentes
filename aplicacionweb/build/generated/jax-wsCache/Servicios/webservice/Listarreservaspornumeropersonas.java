
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para listarreservaspornumeropersonas complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="listarreservaspornumeropersonas"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cantidad_personas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listarreservaspornumeropersonas", propOrder = {
    "cantidadPersonas"
})
public class Listarreservaspornumeropersonas {

    @XmlElement(name = "cantidad_personas")
    protected String cantidadPersonas;

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

}
