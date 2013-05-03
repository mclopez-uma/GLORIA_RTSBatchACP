
package eu.gloria.rti_db;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import eu.gloria.rt.entity.db.File;


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
 *         &lt;element name="uuidOp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="file" type="{http://gloria.eu/rt/entity/db}file"/>
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
    "uuidOp",
    "file"
})
@XmlRootElement(name = "fileCreate")
public class FileCreate {

    @XmlElement(required = true)
    protected String uuidOp;
    @XmlElement(required = true)
    protected File file;

    /**
     * Obtiene el valor de la propiedad uuidOp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUuidOp() {
        return uuidOp;
    }

    /**
     * Define el valor de la propiedad uuidOp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUuidOp(String value) {
        this.uuidOp = value;
    }

    /**
     * Obtiene el valor de la propiedad file.
     * 
     * @return
     *     possible object is
     *     {@link File }
     *     
     */
    public File getFile() {
        return file;
    }

    /**
     * Define el valor de la propiedad file.
     * 
     * @param value
     *     allowed object is
     *     {@link File }
     *     
     */
    public void setFile(File value) {
        this.file = value;
    }

}
