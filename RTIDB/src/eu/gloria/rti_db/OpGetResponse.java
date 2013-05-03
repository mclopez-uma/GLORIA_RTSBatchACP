
package eu.gloria.rti_db;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import eu.gloria.rt.entity.db.ObservingPlan;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="out" type="{http://gloria.eu/rt/entity/db}observingPlan" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "out"
})
@XmlRootElement(name = "opGetResponse")
public class OpGetResponse {

    protected ObservingPlan out;

    /**
     * Obtiene el valor de la propiedad out.
     * 
     * @return
     *     possible object is
     *     {@link ObservingPlan }
     *     
     */
    public ObservingPlan getOut() {
        return out;
    }

    /**
     * Define el valor de la propiedad out.
     * 
     * @param value
     *     allowed object is
     *     {@link ObservingPlan }
     *     
     */
    public void setOut(ObservingPlan value) {
        this.out = value;
    }

}
