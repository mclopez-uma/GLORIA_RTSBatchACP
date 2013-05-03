
package eu.gloria.rti_db;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="op" type="{http://gloria.eu/rt/entity/db}observingPlan"/>
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
    "op"
})
@XmlRootElement(name = "opCreate")
public class OpCreate {

    @XmlElement(required = true)
    protected ObservingPlan op;

    /**
     * Obtiene el valor de la propiedad op.
     * 
     * @return
     *     possible object is
     *     {@link ObservingPlan }
     *     
     */
    public ObservingPlan getOp() {
        return op;
    }

    /**
     * Define el valor de la propiedad op.
     * 
     * @param value
     *     allowed object is
     *     {@link ObservingPlan }
     *     
     */
    public void setOp(ObservingPlan value) {
        this.op = value;
    }

}
