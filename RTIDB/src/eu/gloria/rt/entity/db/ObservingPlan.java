
package eu.gloria.rt.entity.db;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para observingPlan complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="observingPlan">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="uuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="owner" type="{http://gloria.eu/rt/entity/db}observingPlanOwner"/>
 *         &lt;element name="type" type="{http://gloria.eu/rt/entity/db}observingPlanType"/>
 *         &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="files" type="{http://gloria.eu/rt/entity/db}file" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "observingPlan", propOrder = {
    "id",
    "uuid",
    "owner",
    "type",
    "user",
    "files"
})
public class ObservingPlan {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String uuid;
    @XmlElement(required = true)
    protected ObservingPlanOwner owner;
    @XmlElement(required = true)
    protected ObservingPlanType type;
    @XmlElement(required = true)
    protected String user;
    protected List<File> files;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad uuid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Define el valor de la propiedad uuid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUuid(String value) {
        this.uuid = value;
    }

    /**
     * Obtiene el valor de la propiedad owner.
     * 
     * @return
     *     possible object is
     *     {@link ObservingPlanOwner }
     *     
     */
    public ObservingPlanOwner getOwner() {
        return owner;
    }

    /**
     * Define el valor de la propiedad owner.
     * 
     * @param value
     *     allowed object is
     *     {@link ObservingPlanOwner }
     *     
     */
    public void setOwner(ObservingPlanOwner value) {
        this.owner = value;
    }

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link ObservingPlanType }
     *     
     */
    public ObservingPlanType getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link ObservingPlanType }
     *     
     */
    public void setType(ObservingPlanType value) {
        this.type = value;
    }

    /**
     * Obtiene el valor de la propiedad user.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUser() {
        return user;
    }

    /**
     * Define el valor de la propiedad user.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUser(String value) {
        this.user = value;
    }

    /**
     * Gets the value of the files property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the files property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFiles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link File }
     * 
     * 
     */
    public List<File> getFiles() {
        if (files == null) {
            files = new ArrayList<File>();
        }
        return this.files;
    }

}
