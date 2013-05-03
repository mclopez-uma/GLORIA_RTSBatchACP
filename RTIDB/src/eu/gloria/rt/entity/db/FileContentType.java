
package eu.gloria.rt.entity.db;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para fileContentType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="fileContentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DARK"/>
 *     &lt;enumeration value="FLAT"/>
 *     &lt;enumeration value="OBSERVATION"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "fileContentType")
@XmlEnum
public enum FileContentType {

    DARK,
    FLAT,
    OBSERVATION;

    public String value() {
        return name();
    }

    public static FileContentType fromValue(String v) {
        return valueOf(v);
    }

}
