
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateSingleConfigurationOnProductResponse_data_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateSingleConfigurationOnProductResponse_data_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="response" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}Response"/&gt;
 *         &lt;element name="productOrder" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ProductOrder_UpdateSingleConfigurationOnProductResponse" minOccurs="0"/&gt;
 *         &lt;element name="confirmationData" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ProductConfigurationConfirmation" minOccurs="0"/&gt;
 *         &lt;element name="productComponent" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ProductComponentNumber"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateSingleConfigurationOnProductResponse_data_type", propOrder = {
    "response",
    "productOrder",
    "confirmationData",
    "productComponent"
})
public class UpdateSingleConfigurationOnProductResponseDataType {

    @XmlElement(required = true)
    protected Response response;
    protected ProductOrderUpdateSingleConfigurationOnProductResponse productOrder;
    protected ProductConfigurationConfirmation confirmationData;
    @XmlElement(required = true)
    protected ProductComponentNumber productComponent;

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link Response }
     *     
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link Response }
     *     
     */
    public void setResponse(Response value) {
        this.response = value;
    }

    /**
     * Gets the value of the productOrder property.
     * 
     * @return
     *     possible object is
     *     {@link ProductOrderUpdateSingleConfigurationOnProductResponse }
     *     
     */
    public ProductOrderUpdateSingleConfigurationOnProductResponse getProductOrder() {
        return productOrder;
    }

    /**
     * Sets the value of the productOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductOrderUpdateSingleConfigurationOnProductResponse }
     *     
     */
    public void setProductOrder(ProductOrderUpdateSingleConfigurationOnProductResponse value) {
        this.productOrder = value;
    }

    /**
     * Gets the value of the confirmationData property.
     * 
     * @return
     *     possible object is
     *     {@link ProductConfigurationConfirmation }
     *     
     */
    public ProductConfigurationConfirmation getConfirmationData() {
        return confirmationData;
    }

    /**
     * Sets the value of the confirmationData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductConfigurationConfirmation }
     *     
     */
    public void setConfirmationData(ProductConfigurationConfirmation value) {
        this.confirmationData = value;
    }

    /**
     * Gets the value of the productComponent property.
     * 
     * @return
     *     possible object is
     *     {@link ProductComponentNumber }
     *     
     */
    public ProductComponentNumber getProductComponent() {
        return productComponent;
    }

    /**
     * Sets the value of the productComponent property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductComponentNumber }
     *     
     */
    public void setProductComponent(ProductComponentNumber value) {
        this.productComponent = value;
    }

}
