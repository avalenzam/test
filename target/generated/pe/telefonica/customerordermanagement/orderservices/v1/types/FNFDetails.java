
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FNFDetails complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad instanceID.
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
     * Define el valor de la propiedad instanceID.
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
     * Obtiene el valor de la propiedad productSerialNumber.
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
     * Define el valor de la propiedad productSerialNumber.
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
     * Obtiene el valor de la propiedad subType.
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
     * Define el valor de la propiedad subType.
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
     * Obtiene el valor de la propiedad destinationList.
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
     * Define el valor de la propiedad destinationList.
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
     * Obtiene el valor de la propiedad billingOffersList.
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
     * Define el valor de la propiedad billingOffersList.
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
