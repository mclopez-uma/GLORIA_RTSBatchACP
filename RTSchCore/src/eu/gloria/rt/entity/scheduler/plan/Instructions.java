//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.03.14 at 10:12:17 AM CET 
//


package eu.gloria.rt.entity.scheduler.plan;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for instructions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="instructions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="target" type="{http://gloria.eu/rt/entity/scheduler/plan}target"/>
 *           &lt;element name="cameraSettings" type="{http://gloria.eu/rt/entity/scheduler/plan}cameraSettings"/>
 *           &lt;element name="loop" type="{http://gloria.eu/rt/entity/scheduler/plan}loop"/>
 *           &lt;element name="expose" type="{http://gloria.eu/rt/entity/scheduler/plan}expose"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "instructions", propOrder = {
    "targetOrCameraSettingsOrLoop"
})
public class Instructions {

    @XmlElements({
        @XmlElement(name = "cameraSettings", type = CameraSettings.class),
        @XmlElement(name = "expose", type = Expose.class),
        @XmlElement(name = "loop", type = Loop.class),
        @XmlElement(name = "target", type = Target.class)
    })
    protected List<Object> targetOrCameraSettingsOrLoop;

    /**
     * Gets the value of the targetOrCameraSettingsOrLoop property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the targetOrCameraSettingsOrLoop property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTargetOrCameraSettingsOrLoop().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CameraSettings }
     * {@link Expose }
     * {@link Loop }
     * {@link Target }
     * 
     * 
     */
    public List<Object> getTargetOrCameraSettingsOrLoop() {
        if (targetOrCameraSettingsOrLoop == null) {
            targetOrCameraSettingsOrLoop = new ArrayList<Object>();
        }
        return this.targetOrCameraSettingsOrLoop;
    }

}
