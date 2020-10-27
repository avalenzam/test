
package pe.telefonica.teferror.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for detailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="detailsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="timeStamp" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cause" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detailsType", propOrder = {
    "timeStamp",
    "cause"
})
public class DetailsType {

    @XmlElement(required = true)
    protected String timeStamp;
    @XmlElement(required = true)
    protected String cause;

    /**
     * Gets the value of the timeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the value of the timeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeStamp(String value) {
        this.timeStamp = value;
    }

    /**
     * Gets the value of the cause property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCause() {
        return cause;
    }

    /**
     * Sets the value of the cause property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCause(String value) {
        this.cause = value;
    }

}
