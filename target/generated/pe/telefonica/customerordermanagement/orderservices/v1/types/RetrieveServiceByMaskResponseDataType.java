
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RetrieveServiceByMaskResponse_data_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RetrieveServiceByMaskResponse_data_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="response" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}Response"/&gt;
 *         &lt;element name="implementedServicesList" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ServicesList" minOccurs="0"/&gt;
 *         &lt;element name="availableServicesList" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}AvailableServiceList" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveServiceByMaskResponse_data_type", propOrder = {
    "response",
    "implementedServicesList",
    "availableServicesList"
})
public class RetrieveServiceByMaskResponseDataType {

    @XmlElement(required = true)
    protected Response response;
    protected ServicesList implementedServicesList;
    protected AvailableServiceList availableServicesList;

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
     * Obtiene el valor de la propiedad implementedServicesList.
     * 
     * @return
     *     possible object is
     *     {@link ServicesList }
     *     
     */
    public ServicesList getImplementedServicesList() {
        return implementedServicesList;
    }

    /**
     * Define el valor de la propiedad implementedServicesList.
     * 
     * @param value
     *     allowed object is
     *     {@link ServicesList }
     *     
     */
    public void setImplementedServicesList(ServicesList value) {
        this.implementedServicesList = value;
    }

    /**
     * Obtiene el valor de la propiedad availableServicesList.
     * 
     * @return
     *     possible object is
     *     {@link AvailableServiceList }
     *     
     */
    public AvailableServiceList getAvailableServicesList() {
        return availableServicesList;
    }

    /**
     * Define el valor de la propiedad availableServicesList.
     * 
     * @param value
     *     allowed object is
     *     {@link AvailableServiceList }
     *     
     */
    public void setAvailableServicesList(AvailableServiceList value) {
        this.availableServicesList = value;
    }

}
