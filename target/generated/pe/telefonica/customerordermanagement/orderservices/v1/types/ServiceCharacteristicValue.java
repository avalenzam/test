
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ServiceCharacteristicValue complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ServiceCharacteristicValue"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ID"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="15"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="code"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="50"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="name"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="255"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="value" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="255"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="isMandatory" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="isDate" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="_serviceSpecCharacteristic" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ServiceSpecCharacteristic" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceCharacteristicValue", propOrder = {
    "id",
    "code",
    "name",
    "value",
    "isMandatory",
    "isDate",
    "serviceSpecCharacteristic"
})
public class ServiceCharacteristicValue {

    @XmlElement(name = "ID", required = true)
    protected String id;
    @XmlElement(required = true)
    protected String code;
    @XmlElement(required = true)
    protected String name;
    protected String value;
    protected boolean isMandatory;
    protected boolean isDate;
    @XmlElement(name = "_serviceSpecCharacteristic")
    protected ServiceSpecCharacteristic serviceSpecCharacteristic;

    /**
     * Obtiene el valor de la propiedad id.
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
     * Define el valor de la propiedad id.
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
     * Obtiene el valor de la propiedad code.
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
     * Define el valor de la propiedad code.
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
     * Obtiene el valor de la propiedad name.
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
     * Define el valor de la propiedad name.
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
     * Obtiene el valor de la propiedad value.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Define el valor de la propiedad value.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Obtiene el valor de la propiedad isMandatory.
     * 
     */
    public boolean isIsMandatory() {
        return isMandatory;
    }

    /**
     * Define el valor de la propiedad isMandatory.
     * 
     */
    public void setIsMandatory(boolean value) {
        this.isMandatory = value;
    }

    /**
     * Obtiene el valor de la propiedad isDate.
     * 
     */
    public boolean isIsDate() {
        return isDate;
    }

    /**
     * Define el valor de la propiedad isDate.
     * 
     */
    public void setIsDate(boolean value) {
        this.isDate = value;
    }

    /**
     * Obtiene el valor de la propiedad serviceSpecCharacteristic.
     * 
     * @return
     *     possible object is
     *     {@link ServiceSpecCharacteristic }
     *     
     */
    public ServiceSpecCharacteristic getServiceSpecCharacteristic() {
        return serviceSpecCharacteristic;
    }

    /**
     * Define el valor de la propiedad serviceSpecCharacteristic.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceSpecCharacteristic }
     *     
     */
    public void setServiceSpecCharacteristic(ServiceSpecCharacteristic value) {
        this.serviceSpecCharacteristic = value;
    }

}
