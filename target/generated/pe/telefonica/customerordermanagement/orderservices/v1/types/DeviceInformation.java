
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DeviceInformation complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DeviceInformation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="deviceSAPID" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="planGroup"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="15"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="simSAPID"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="customerType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="15"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceInformation", propOrder = {
    "deviceSAPID",
    "planGroup",
    "simSAPID",
    "customerType"
})
public class DeviceInformation {

    protected String deviceSAPID;
    @XmlElement(required = true)
    protected String planGroup;
    @XmlElement(required = true)
    protected String simSAPID;
    protected String customerType;

    /**
     * Obtiene el valor de la propiedad deviceSAPID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceSAPID() {
        return deviceSAPID;
    }

    /**
     * Define el valor de la propiedad deviceSAPID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceSAPID(String value) {
        this.deviceSAPID = value;
    }

    /**
     * Obtiene el valor de la propiedad planGroup.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanGroup() {
        return planGroup;
    }

    /**
     * Define el valor de la propiedad planGroup.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanGroup(String value) {
        this.planGroup = value;
    }

    /**
     * Obtiene el valor de la propiedad simSAPID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSimSAPID() {
        return simSAPID;
    }

    /**
     * Define el valor de la propiedad simSAPID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSimSAPID(String value) {
        this.simSAPID = value;
    }

    /**
     * Obtiene el valor de la propiedad customerType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerType() {
        return customerType;
    }

    /**
     * Define el valor de la propiedad customerType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerType(String value) {
        this.customerType = value;
    }

}
