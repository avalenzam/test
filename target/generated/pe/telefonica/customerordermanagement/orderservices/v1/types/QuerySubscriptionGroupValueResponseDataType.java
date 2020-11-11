
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para QuerySubscriptionGroupValueResponse_data_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="QuerySubscriptionGroupValueResponse_data_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="error" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}Error"/&gt;
 *         &lt;element name="MSISDN" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}TelephoneNumber_QuerySubscriptionGroupValueResponse"/&gt;
 *         &lt;element name="GVS" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}GroupValue"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuerySubscriptionGroupValueResponse_data_type", propOrder = {
    "error",
    "msisdn",
    "gvs"
})
public class QuerySubscriptionGroupValueResponseDataType {

    @XmlElement(required = true)
    protected Error error;
    @XmlElement(name = "MSISDN", required = true)
    protected TelephoneNumberQuerySubscriptionGroupValueResponse msisdn;
    @XmlElement(name = "GVS", required = true)
    protected GroupValue gvs;

    /**
     * Obtiene el valor de la propiedad error.
     * 
     * @return
     *     possible object is
     *     {@link Error }
     *     
     */
    public Error getError() {
        return error;
    }

    /**
     * Define el valor de la propiedad error.
     * 
     * @param value
     *     allowed object is
     *     {@link Error }
     *     
     */
    public void setError(Error value) {
        this.error = value;
    }

    /**
     * Obtiene el valor de la propiedad msisdn.
     * 
     * @return
     *     possible object is
     *     {@link TelephoneNumberQuerySubscriptionGroupValueResponse }
     *     
     */
    public TelephoneNumberQuerySubscriptionGroupValueResponse getMSISDN() {
        return msisdn;
    }

    /**
     * Define el valor de la propiedad msisdn.
     * 
     * @param value
     *     allowed object is
     *     {@link TelephoneNumberQuerySubscriptionGroupValueResponse }
     *     
     */
    public void setMSISDN(TelephoneNumberQuerySubscriptionGroupValueResponse value) {
        this.msisdn = value;
    }

    /**
     * Obtiene el valor de la propiedad gvs.
     * 
     * @return
     *     possible object is
     *     {@link GroupValue }
     *     
     */
    public GroupValue getGVS() {
        return gvs;
    }

    /**
     * Define el valor de la propiedad gvs.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupValue }
     *     
     */
    public void setGVS(GroupValue value) {
        this.gvs = value;
    }

}
