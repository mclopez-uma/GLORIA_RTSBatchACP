
package eu.gloria.rt.entity.db;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para fileFormat.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="fileFormat">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FITS"/>
 *     &lt;enumeration value="JPG"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "fileFormat")
@XmlEnum
public enum FileFormat {

    FITS,
    JPG;

    public String value() {
        return name();
    }

    public static FileFormat fromValue(String v) {
        return valueOf(v);
    }

}
