
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConsultServicesRetrieveProductHeaderResults complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsultServicesRetrieveProductHeaderResults"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="response" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}Response_ConsultServicesRetrieveProductHeaderResults"/&gt;
 *         &lt;element name="ProductHeader" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ProductHeader"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultServicesRetrieveProductHeaderResults", propOrder = {
    "response",
    "productHeader"
})
public class ConsultServicesRetrieveProductHeaderResults {

    @XmlElement(required = true)
    protected ResponseConsultServicesRetrieveProductHeaderResults response;
    @XmlElement(name = "ProductHeader", required = true)
    protected ProductHeader productHeader;

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseConsultServicesRetrieveProductHeaderResults }
     *     
     */
    public ResponseConsultServicesRetrieveProductHeaderResults getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseConsultServicesRetrieveProductHeaderResults }
     *     
     */
    public void setResponse(ResponseConsultServicesRetrieveProductHeaderResults value) {
        this.response = value;
    }

    /**
     * Gets the value of the productHeader property.
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
     * Sets the value of the productHeader property.
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
