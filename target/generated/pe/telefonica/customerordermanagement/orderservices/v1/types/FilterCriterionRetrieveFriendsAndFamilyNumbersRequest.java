
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FilterCriterion_RetrieveFriendsAndFamilyNumbersRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FilterCriterion_RetrieveFriendsAndFamilyNumbersRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="closeParenNumber" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="fieldName"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="255"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="isLogicalAnd" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="openParenNumber" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="operator"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="15"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="otherValue" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="255"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="value"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="255"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="valueDataType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="6"/&gt;
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
@XmlType(name = "FilterCriterion_RetrieveFriendsAndFamilyNumbersRequest", propOrder = {
    "closeParenNumber",
    "fieldName",
    "isLogicalAnd",
    "openParenNumber",
    "operator",
    "otherValue",
    "value",
    "valueDataType"
})
public class FilterCriterionRetrieveFriendsAndFamilyNumbersRequest {

    protected BigInteger closeParenNumber;
    @XmlElement(required = true)
    protected String fieldName;
    protected boolean isLogicalAnd;
    protected BigInteger openParenNumber;
    @XmlElement(required = true)
    protected String operator;
    protected String otherValue;
    @XmlElement(required = true)
    protected String value;
    protected String valueDataType;

    /**
     * Obtiene el valor de la propiedad closeParenNumber.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCloseParenNumber() {
        return closeParenNumber;
    }

    /**
     * Define el valor de la propiedad closeParenNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCloseParenNumber(BigInteger value) {
        this.closeParenNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad fieldName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Define el valor de la propiedad fieldName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldName(String value) {
        this.fieldName = value;
    }

    /**
     * Obtiene el valor de la propiedad isLogicalAnd.
     * 
     */
    public boolean isIsLogicalAnd() {
        return isLogicalAnd;
    }

    /**
     * Define el valor de la propiedad isLogicalAnd.
     * 
     */
    public void setIsLogicalAnd(boolean value) {
        this.isLogicalAnd = value;
    }

    /**
     * Obtiene el valor de la propiedad openParenNumber.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOpenParenNumber() {
        return openParenNumber;
    }

    /**
     * Define el valor de la propiedad openParenNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOpenParenNumber(BigInteger value) {
        this.openParenNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad operator.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Define el valor de la propiedad operator.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperator(String value) {
        this.operator = value;
    }

    /**
     * Obtiene el valor de la propiedad otherValue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherValue() {
        return otherValue;
    }

    /**
     * Define el valor de la propiedad otherValue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherValue(String value) {
        this.otherValue = value;
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
     * Obtiene el valor de la propiedad valueDataType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValueDataType() {
        return valueDataType;
    }

    /**
     * Define el valor de la propiedad valueDataType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValueDataType(String value) {
        this.valueDataType = value;
    }

}
