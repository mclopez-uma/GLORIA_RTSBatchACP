
package eu.gloria.rt.entity.db;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para observingPlanOwner.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="observingPlanOwner">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SYSTEM"/>
 *     &lt;enumeration value="USER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "observingPlanOwner")
@XmlEnum
public enum ObservingPlanOwner {

    SYSTEM,
    USER;

    public String value() {
        return name();
    }

    public static ObservingPlanOwner fromValue(String v) {
        return valueOf(v);
    }

}
