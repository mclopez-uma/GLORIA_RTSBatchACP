
package eu.gloria.rt.entity.db;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para fileType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="fileType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IMAGE"/>
 *     &lt;enumeration value="VIDEO"/>
 *     &lt;enumeration value="RADIO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "fileType")
@XmlEnum
public enum FileType {

    IMAGE,
    VIDEO,
    RADIO;

    public String value() {
        return name();
    }

    public static FileType fromValue(String v) {
        return valueOf(v);
    }

}
