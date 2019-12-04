
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para listarreservasporfechas complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="listarreservasporfechas"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="fechainicial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechafinal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listarreservasporfechas", propOrder = {
    "fechainicial",
    "fechafinal"
})
public class Listarreservasporfechas {

    protected String fechainicial;
    protected String fechafinal;

    /**
     * Obtiene el valor de la propiedad fechainicial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechainicial() {
        return fechainicial;
    }

    /**
     * Define el valor de la propiedad fechainicial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechainicial(String value) {
        this.fechainicial = value;
    }

    /**
     * Obtiene el valor de la propiedad fechafinal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechafinal() {
        return fechafinal;
    }

    /**
     * Define el valor de la propiedad fechafinal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechafinal(String value) {
        this.fechafinal = value;
    }

}
