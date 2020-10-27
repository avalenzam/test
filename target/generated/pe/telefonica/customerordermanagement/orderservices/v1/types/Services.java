
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Services complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Services"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="15"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="serviceStatus" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ServiceStatus_RetrieveServiceByMaskResponse"/&gt;
 *         &lt;element name="serviceSubStatus" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ServiceSubStatus" minOccurs="0"/&gt;
 *         &lt;element name="serviceCatalog" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}AvailableService"/&gt;
 *         &lt;element name="attributesList" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ServiceCharacteristicValueList" minOccurs="0"/&gt;
 *         &lt;element name="allowedActionList" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}AllowedActionList" minOccurs="0"/&gt;
 *         &lt;element name="billingOffersList" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ProductOfferingList" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Services", propOrder = {
    "id",
    "serviceStatus",
    "serviceSubStatus",
    "serviceCatalog",
    "attributesList",
    "allowedActionList",
    "billingOffersList"
})
public class Services {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(required = true)
    protected ServiceStatusRetrieveServiceByMaskResponse serviceStatus;
    protected ServiceSubStatus serviceSubStatus;
    @XmlElement(required = true)
    protected AvailableService serviceCatalog;
    protected ServiceCharacteristicValueList attributesList;
    protected AllowedActionList allowedActionList;
    protected ProductOfferingList billingOffersList;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
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
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the serviceStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceStatusRetrieveServiceByMaskResponse }
     *     
     */
    public ServiceStatusRetrieveServiceByMaskResponse getServiceStatus() {
        return serviceStatus;
    }

    /**
     * Sets the value of the serviceStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceStatusRetrieveServiceByMaskResponse }
     *     
     */
    public void setServiceStatus(ServiceStatusRetrieveServiceByMaskResponse value) {
        this.serviceStatus = value;
    }

    /**
     * Gets the value of the serviceSubStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceSubStatus }
     *     
     */
    public ServiceSubStatus getServiceSubStatus() {
        return serviceSubStatus;
    }

    /**
     * Sets the value of the serviceSubStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceSubStatus }
     *     
     */
    public void setServiceSubStatus(ServiceSubStatus value) {
        this.serviceSubStatus = value;
    }

    /**
     * Gets the value of the serviceCatalog property.
     * 
     * @return
     *     possible object is
     *     {@link AvailableService }
     *     
     */
    public AvailableService getServiceCatalog() {
        return serviceCatalog;
    }

    /**
     * Sets the value of the serviceCatalog property.
     * 
     * @param value
     *     allowed object is
     *     {@link AvailableService }
     *     
     */
    public void setServiceCatalog(AvailableService value) {
        this.serviceCatalog = value;
    }

    /**
     * Gets the value of the attributesList property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceCharacteristicValueList }
     *     
     */
    public ServiceCharacteristicValueList getAttributesList() {
        return attributesList;
    }

    /**
     * Sets the value of the attributesList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceCharacteristicValueList }
     *     
     */
    public void setAttributesList(ServiceCharacteristicValueList value) {
        this.attributesList = value;
    }

    /**
     * Gets the value of the allowedActionList property.
     * 
     * @return
     *     possible object is
     *     {@link AllowedActionList }
     *     
     */
    public AllowedActionList getAllowedActionList() {
        return allowedActionList;
    }

    /**
     * Sets the value of the allowedActionList property.
     * 
     * @param value
     *     allowed object is
     *     {@link AllowedActionList }
     *     
     */
    public void setAllowedActionList(AllowedActionList value) {
        this.allowedActionList = value;
    }

    /**
     * Gets the value of the billingOffersList property.
     * 
     * @return
     *     possible object is
     *     {@link ProductOfferingList }
     *     
     */
    public ProductOfferingList getBillingOffersList() {
        return billingOffersList;
    }

    /**
     * Sets the value of the billingOffersList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductOfferingList }
     *     
     */
    public void setBillingOffersList(ProductOfferingList value) {
        this.billingOffersList = value;
    }

}
