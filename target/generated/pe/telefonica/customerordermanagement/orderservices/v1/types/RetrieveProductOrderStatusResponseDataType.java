
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RetrieveProductOrderStatusResponse_data_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad response.
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
     * Define el valor de la propiedad response.
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
     * Obtiene el valor de la propiedad orderStatus.
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
     * Define el valor de la propiedad orderStatus.
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
     * Obtiene el valor de la propiedad cancelStatus.
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
     * Define el valor de la propiedad cancelStatus.
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
