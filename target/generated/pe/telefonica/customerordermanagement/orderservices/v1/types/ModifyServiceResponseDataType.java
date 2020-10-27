
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ModifyServiceResponse_data_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ModifyServiceResponse_data_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="href" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="255"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="productOrder" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ProductOrderOut"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModifyServiceResponse_data_type", propOrder = {
    "href",
    "productOrder"
})
public class ModifyServiceResponseDataType {

    protected String href;
    @XmlElement(required = true)
    protected ProductOrderOut productOrder;

    /**
     * Obtiene el valor de la propiedad href.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHref() {
        return href;
    }

    /**
     * Define el valor de la propiedad href.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHref(String value) {
        this.href = value;
    }

    /**
     * Obtiene el valor de la propiedad productOrder.
     * 
     * @return
     *     possible object is
     *     {@link ProductOrderOut }
     *     
     */
    public ProductOrderOut getProductOrder() {
        return productOrder;
    }

    /**
     * Define el valor de la propiedad productOrder.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductOrderOut }
     *     
     */
    public void setProductOrder(ProductOrderOut value) {
        this.productOrder = value;
    }

}
