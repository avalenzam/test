
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FNFDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FNFDetails"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="instanceID"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="15"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="productSerialNumber" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="50"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="code" minOccurs="0"&gt;
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
 *         &lt;element name="subType" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}SubType" minOccurs="0"/&gt;
 *         &lt;element name="destinationList" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}TelephoneNumberFNFList"/&gt;
 *         &lt;element name="billingOffersList" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}FNFBODetailsList" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FNFDetails", propOrder = {
    "instanceID",
    "productSerialNumber",
    "code",
    "name",
    "subType",
    "destinationList",
    "billingOffersList"
})
public class FNFDetails {

    @XmlElement(required = true)
    protected String instanceID;
    protected String productSerialNumber;
    protected String code;
    protected String name;
    protected SubType subType;
    @XmlElement(required = true)
    protected TelephoneNumberFNFList destinationList;
    protected FNFBODetailsList billingOffersList;

    /**
     * Gets the value of the instanceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstanceID() {
        return instanceID;
    }

    /**
     * Sets the value of the instanceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstanceID(String value) {
        this.instanceID = value;
    }

    /**
     * Gets the value of the productSerialNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductSerialNumber() {
        return productSerialNumber;
    }

    /**
     * Sets the value of the productSerialNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductSerialNumber(String value) {
        this.productSerialNumber = value;
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
     * Gets the value of the subType property.
     * 
     * @return
     *     possible object is
     *     {@link SubType }
     *     
     */
    public SubType getSubType() {
        return subType;
    }

    /**
     * Sets the value of the subType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubType }
     *     
     */
    public void setSubType(SubType value) {
        this.subType = value;
    }

    /**
     * Gets the value of the destinationList property.
     * 
     * @return
     *     possible object is
     *     {@link TelephoneNumberFNFList }
     *     
     */
    public TelephoneNumberFNFList getDestinationList() {
        return destinationList;
    }

    /**
     * Sets the value of the destinationList property.
     * 
     * @param value
     *     allowed object is
     *     {@link TelephoneNumberFNFList }
     *     
     */
    public void setDestinationList(TelephoneNumberFNFList value) {
        this.destinationList = value;
    }

    /**
     * Gets the value of the billingOffersList property.
     * 
     * @return
     *     possible object is
     *     {@link FNFBODetailsList }
     *     
     */
    public FNFBODetailsList getBillingOffersList() {
        return billingOffersList;
    }

    /**
     * Sets the value of the billingOffersList property.
     * 
     * @param value
     *     allowed object is
     *     {@link FNFBODetailsList }
     *     
     */
    public void setBillingOffersList(FNFBODetailsList value) {
        this.billingOffersList = value;
    }

}
