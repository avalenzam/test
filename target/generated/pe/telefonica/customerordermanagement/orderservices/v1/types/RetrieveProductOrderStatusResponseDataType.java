
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetrieveProductOrderStatusResponse_data_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveProductOrderStatusResponse_data_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="response" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}Response"/&gt;
 *         &lt;element name="orderStatus" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}OrderStatus" minOccurs="0"/&gt;
 *         &lt;element name="cancelStatus" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}CancelStatus" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveProductOrderStatusResponse_data_type", propOrder = {
    "response",
    "orderStatus",
    "cancelStatus"
})
public class RetrieveProductOrderStatusResponseDataType {

    @XmlElement(required = true)
    protected Response response;
    protected OrderStatus orderStatus;
    protected CancelStatus cancelStatus;

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
     * Gets the value of the orderStatus property.
     * 
     * @return
     *     possible object is
     *     {@link OrderStatus }
     *     
     */
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    /**
     * Sets the value of the orderStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderStatus }
     *     
     */
    public void setOrderStatus(OrderStatus value) {
        this.orderStatus = value;
    }

    /**
     * Gets the value of the cancelStatus property.
     * 
     * @return
     *     possible object is
     *     {@link CancelStatus }
     *     
     */
    public CancelStatus getCancelStatus() {
        return cancelStatus;
    }

    /**
     * Sets the value of the cancelStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelStatus }
     *     
     */
    public void setCancelStatus(CancelStatus value) {
        this.cancelStatus = value;
    }

}
