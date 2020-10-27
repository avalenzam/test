
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ChangeProductStatusResponse_data_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChangeProductStatusResponse_data_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="response" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}Response"/&gt;
 *         &lt;element name="productOrder" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ProductOrder_ChangeProductStatusResponse" minOccurs="0"/&gt;
 *         &lt;element name="lostAndStolenCode" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}LostAndStolenCode" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangeProductStatusResponse_data_type", propOrder = {
    "response",
    "productOrder",
    "lostAndStolenCode"
})
public class ChangeProductStatusResponseDataType {

    @XmlElement(required = true)
    protected Response response;
    protected ProductOrderChangeProductStatusResponse productOrder;
    protected LostAndStolenCode lostAndStolenCode;

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
     *     {@link ProductOrderChangeProductStatusResponse }
     *     
     */
    public ProductOrderChangeProductStatusResponse getProductOrder() {
        return productOrder;
    }

    /**
     * Sets the value of the productOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductOrderChangeProductStatusResponse }
     *     
     */
    public void setProductOrder(ProductOrderChangeProductStatusResponse value) {
        this.productOrder = value;
    }

    /**
     * Gets the value of the lostAndStolenCode property.
     * 
     * @return
     *     possible object is
     *     {@link LostAndStolenCode }
     *     
     */
    public LostAndStolenCode getLostAndStolenCode() {
        return lostAndStolenCode;
    }

    /**
     * Sets the value of the lostAndStolenCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link LostAndStolenCode }
     *     
     */
    public void setLostAndStolenCode(LostAndStolenCode value) {
        this.lostAndStolenCode = value;
    }

}
