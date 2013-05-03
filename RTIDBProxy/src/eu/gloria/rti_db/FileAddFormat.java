
package eu.gloria.rti_db;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import eu.gloria.rt.entity.db.FileFormat;


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
 *         &lt;element name="uuidFile" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="format" type="{http://gloria.eu/rt/entity/db}fileFormat"/>
 *         &lt;element name="sourceURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "uuidFile",
    "format",
    "sourceURL"
})
@XmlRootElement(name = "fileAddFormat")
public class FileAddFormat {

    @XmlElement(required = true)
    protected String uuidFile;
    @XmlElement(required = true)
    protected FileFormat format;
    @XmlElement(required = true)
    protected String sourceURL;

    /**
     * Obtiene el valor de la propiedad uuidFile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUuidFile() {
        return uuidFile;
    }

    /**
     * Define el valor de la propiedad uuidFile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUuidFile(String value) {
        this.uuidFile = value;
    }

    /**
     * Obtiene el valor de la propiedad format.
     * 
     * @return
     *     possible object is
     *     {@link FileFormat }
     *     
     */
    public FileFormat getFormat() {
        return format;
    }

    /**
     * Define el valor de la propiedad format.
     * 
     * @param value
     *     allowed object is
     *     {@link FileFormat }
     *     
     */
    public void setFormat(FileFormat value) {
        this.format = value;
    }

    /**
     * Obtiene el valor de la propiedad sourceURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceURL() {
        return sourceURL;
    }

    /**
     * Define el valor de la propiedad sourceURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceURL(String value) {
        this.sourceURL = value;
    }

}
