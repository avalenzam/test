
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para UpdateFriendsAndFamilyNumbersResponse_data_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="UpdateFriendsAndFamilyNumbersResponse_data_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="response" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}Response"/&gt;
 *         &lt;element name="productOrder" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ProductOrder_UpdateFriendsAndFamilyNumbersResponse" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateFriendsAndFamilyNumbersResponse_data_type", propOrder = {
    "response",
    "productOrder"
})
public class UpdateFriendsAndFamilyNumbersResponseDataType {

    @XmlElement(required = true)
    protected Response response;
    protected ProductOrderUpdateFriendsAndFamilyNumbersResponse productOrder;

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
     * Obtiene el valor de la propiedad productOrder.
     * 
     * @return
     *     possible object is
     *     {@link ProductOrderUpdateFriendsAndFamilyNumbersResponse }
     *     
     */
    public ProductOrderUpdateFriendsAndFamilyNumbersResponse getProductOrder() {
        return productOrder;
    }

    /**
     * Define el valor de la propiedad productOrder.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductOrderUpdateFriendsAndFamilyNumbersResponse }
     *     
     */
    public void setProductOrder(ProductOrderUpdateFriendsAndFamilyNumbersResponse value) {
        this.productOrder = value;
    }

}
