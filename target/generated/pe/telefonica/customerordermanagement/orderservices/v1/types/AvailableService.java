
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AvailableService complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AvailableService"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ID"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="50"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="code"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="80"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="name" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="255"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="type" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ServiceType" minOccurs="0"/&gt;
 *         &lt;element name="subtype" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ServiceSubType" minOccurs="0"/&gt;
 *         &lt;element name="availableQuantity" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="characteristicsList" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ServiceCharacteristicValueList" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AvailableService", propOrder = {
    "id",
    "code",
    "name",
    "type",
    "subtype",
    "availableQuantity",
    "characteristicsList"
})
public class AvailableService {

    @XmlElement(name = "ID", required = true)
    protected String id;
    @XmlElement(required = true)
    protected String code;
    protected String name;
    protected ServiceType type;
    protected ServiceSubType subtype;
    protected BigInteger availableQuantity;
    protected ServiceCharacteristicValueList characteristicsList;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceType }
     *     
     */
    public ServiceType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceType }
     *     
     */
    public void setType(ServiceType value) {
        this.type = value;
    }

    /**
     * Gets the value of the subtype property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceSubType }
     *     
     */
    public ServiceSubType getSubtype() {
        return subtype;
    }

    /**
     * Sets the value of the subtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceSubType }
     *     
     */
    public void setSubtype(ServiceSubType value) {
        this.subtype = value;
    }

    /**
     * Gets the value of the availableQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAvailableQuantity() {
        return availableQuantity;
    }

    /**
     * Sets the value of the availableQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAvailableQuantity(BigInteger value) {
        this.availableQuantity = value;
    }

    /**
     * Gets the value of the characteristicsList property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceCharacteristicValueList }
     *     
     */
    public ServiceCharacteristicValueList getCharacteristicsList() {
        return characteristicsList;
    }

    /**
     * Sets the value of the characteristicsList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceCharacteristicValueList }
     *     
     */
    public void setCharacteristicsList(ServiceCharacteristicValueList value) {
        this.characteristicsList = value;
    }

}
