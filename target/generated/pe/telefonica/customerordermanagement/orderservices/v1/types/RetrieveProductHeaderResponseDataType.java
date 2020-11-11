
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RetrieveProductHeaderResponse_data_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RetrieveProductHeaderResponse_data_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="response" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}Response"/&gt;
 *         &lt;element name="productHeader" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ProductHeader" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveProductHeaderResponse_data_type", propOrder = {
    "response",
    "productHeader"
})
public class RetrieveProductHeaderResponseDataType {

    @XmlElement(required = true)
    protected Response response;
    protected ProductHeader productHeader;

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
     * Obtiene el valor de la propiedad productHeader.
     * 
     * @return
     *     possible object is
     *     {@link ProductHeader }
     *     
     */
    public ProductHeader getProductHeader() {
        return productHeader;
    }

    /**
     * Define el valor de la propiedad productHeader.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductHeader }
     *     
     */
    public void setProductHeader(ProductHeader value) {
        this.productHeader = value;
    }

}
