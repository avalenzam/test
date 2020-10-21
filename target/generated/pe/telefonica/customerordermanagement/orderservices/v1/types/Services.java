
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Services complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad id.
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
     * Define el valor de la propiedad id.
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
     * Obtiene el valor de la propiedad serviceStatus.
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
     * Define el valor de la propiedad serviceStatus.
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
     * Obtiene el valor de la propiedad serviceSubStatus.
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
     * Define el valor de la propiedad serviceSubStatus.
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
     * Obtiene el valor de la propiedad serviceCatalog.
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
     * Define el valor de la propiedad serviceCatalog.
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
     * Obtiene el valor de la propiedad attributesList.
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
     * Define el valor de la propiedad attributesList.
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
     * Obtiene el valor de la propiedad allowedActionList.
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
     * Define el valor de la propiedad allowedActionList.
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
     * Obtiene el valor de la propiedad billingOffersList.
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
     * Define el valor de la propiedad billingOffersList.
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
