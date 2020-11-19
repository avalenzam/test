
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetrieveServiceByMaskRequest_data_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveServiceByMaskRequest_data_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="productComponent" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ProductComponent_RetrieveServiceByMaskRequest" minOccurs="0"/&gt;
 *         &lt;element name="availableServiceMask" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}AvailableServiceMaskEnum"/&gt;
 *         &lt;element name="implementedServiceMask" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ImplementedServiceMaskEnum"/&gt;
 *         &lt;element name="serviceFilterInfoList" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}FilterList" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveServiceByMaskRequest_data_type", propOrder = {
    "productComponent",
    "availableServiceMask",
    "implementedServiceMask",
    "serviceFilterInfoList"
})
public class RetrieveServiceByMaskRequestDataType {

    protected ProductComponentRetrieveServiceByMaskRequest productComponent;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected AvailableServiceMaskEnum availableServiceMask;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ImplementedServiceMaskEnum implementedServiceMask;
    protected FilterList serviceFilterInfoList;

    /**
     * Gets the value of the productComponent property.
     * 
     * @return
     *     possible object is
     *     {@link ProductComponentRetrieveServiceByMaskRequest }
     *     
     */
    public ProductComponentRetrieveServiceByMaskRequest getProductComponent() {
        return productComponent;
    }

    /**
     * Sets the value of the productComponent property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductComponentRetrieveServiceByMaskRequest }
     *     
     */
    public void setProductComponent(ProductComponentRetrieveServiceByMaskRequest value) {
        this.productComponent = value;
    }

    /**
     * Gets the value of the availableServiceMask property.
     * 
     * @return
     *     possible object is
     *     {@link AvailableServiceMaskEnum }
     *     
     */
    public AvailableServiceMaskEnum getAvailableServiceMask() {
        return availableServiceMask;
    }

    /**
     * Sets the value of the availableServiceMask property.
     * 
     * @param value
     *     allowed object is
     *     {@link AvailableServiceMaskEnum }
     *     
     */
    public void setAvailableServiceMask(AvailableServiceMaskEnum value) {
        this.availableServiceMask = value;
    }

    /**
     * Gets the value of the implementedServiceMask property.
     * 
     * @return
     *     possible object is
     *     {@link ImplementedServiceMaskEnum }
     *     
     */
    public ImplementedServiceMaskEnum getImplementedServiceMask() {
        return implementedServiceMask;
    }

    /**
     * Sets the value of the implementedServiceMask property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImplementedServiceMaskEnum }
     *     
     */
    public void setImplementedServiceMask(ImplementedServiceMaskEnum value) {
        this.implementedServiceMask = value;
    }

    /**
     * Gets the value of the serviceFilterInfoList property.
     * 
     * @return
     *     possible object is
     *     {@link FilterList }
     *     
     */
    public FilterList getServiceFilterInfoList() {
        return serviceFilterInfoList;
    }

    /**
     * Sets the value of the serviceFilterInfoList property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilterList }
     *     
     */
    public void setServiceFilterInfoList(FilterList value) {
        this.serviceFilterInfoList = value;
    }

}
