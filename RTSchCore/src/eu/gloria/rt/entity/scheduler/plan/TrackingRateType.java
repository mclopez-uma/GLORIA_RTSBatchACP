//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.03.14 at 10:12:17 AM CET 
//


package eu.gloria.rt.entity.scheduler.plan;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for trackingRateType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="trackingRateType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DriveSidereal"/>
 *     &lt;enumeration value="DriveLunar"/>
 *     &lt;enumeration value="DriveSolar"/>
 *     &lt;enumeration value="DriveKing"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "trackingRateType")
@XmlEnum
public enum TrackingRateType {

    @XmlEnumValue("DriveSidereal")
    DRIVE_SIDEREAL("DriveSidereal"),
    @XmlEnumValue("DriveLunar")
    DRIVE_LUNAR("DriveLunar"),
    @XmlEnumValue("DriveSolar")
    DRIVE_SOLAR("DriveSolar"),
    @XmlEnumValue("DriveKing")
    DRIVE_KING("DriveKing");
    private final String value;

    TrackingRateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TrackingRateType fromValue(String v) {
        for (TrackingRateType c: TrackingRateType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
