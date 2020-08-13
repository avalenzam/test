
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceSpecCharacteristic complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceSpecCharacteristic"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="255"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="valueType" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}valueTypeEnum"/&gt;
 *         &lt;element name="classification" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ClassificationTypeEnum"/&gt;
 *         &lt;element name="size" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="validValueList" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ValidValueList" minOccurs="0"/&gt;
 *         &lt;element name="rangeList" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}rangeList" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceSpecCharacteristic", propOrder = {
    "name",
    "valueType",
    "classification",
    "size",
    "validValueList",
    "rangeList"
})
public class ServiceSpecCharacteristic {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ValueTypeEnum valueType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ClassificationTypeEnum classification;
    protected int size;
    protected ValidValueList validValueList;
    protected RangeList rangeList;

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
     * Gets the value of the valueType property.
     * 
     * @return
     *     possible object is
     *     {@link ValueTypeEnum }
     *     
     */
    public ValueTypeEnum getValueType() {
        return valueType;
    }

    /**
     * Sets the value of the valueType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueTypeEnum }
     *     
     */
    public void setValueType(ValueTypeEnum value) {
        this.valueType = value;
    }

    /**
     * Gets the value of the classification property.
     * 
     * @return
     *     possible object is
     *     {@link ClassificationTypeEnum }
     *     
     */
    public ClassificationTypeEnum getClassification() {
        return classification;
    }

    /**
     * Sets the value of the classification property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassificationTypeEnum }
     *     
     */
    public void setClassification(ClassificationTypeEnum value) {
        this.classification = value;
    }

    /**
     * Gets the value of the size property.
     * 
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     */
    public void setSize(int value) {
        this.size = value;
    }

    /**
     * Gets the value of the validValueList property.
     * 
     * @return
     *     possible object is
     *     {@link ValidValueList }
     *     
     */
    public ValidValueList getValidValueList() {
        return validValueList;
    }

    /**
     * Sets the value of the validValueList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidValueList }
     *     
     */
    public void setValidValueList(ValidValueList value) {
        this.validValueList = value;
    }

    /**
     * Gets the value of the rangeList property.
     * 
     * @return
     *     possible object is
     *     {@link RangeList }
     *     
     */
    public RangeList getRangeList() {
        return rangeList;
    }

    /**
     * Sets the value of the rangeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link RangeList }
     *     
     */
    public void setRangeList(RangeList value) {
        this.rangeList = value;
    }

}
