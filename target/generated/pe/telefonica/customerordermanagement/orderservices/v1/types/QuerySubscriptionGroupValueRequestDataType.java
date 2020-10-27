
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para QuerySubscriptionGroupValueRequest_data_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="QuerySubscriptionGroupValueRequest_data_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MSISDN" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}TelephoneNumber_QuerySubscriptionGroupValueRequest"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuerySubscriptionGroupValueRequest_data_type", propOrder = {
    "msisdn"
})
public class QuerySubscriptionGroupValueRequestDataType {

    @XmlElement(name = "MSISDN", required = true)
    protected TelephoneNumberQuerySubscriptionGroupValueRequest msisdn;

    /**
     * Obtiene el valor de la propiedad msisdn.
     * 
     * @return
     *     possible object is
     *     {@link TelephoneNumberQuerySubscriptionGroupValueRequest }
     *     
     */
    public TelephoneNumberQuerySubscriptionGroupValueRequest getMSISDN() {
        return msisdn;
    }

    /**
     * Define el valor de la propiedad msisdn.
     * 
     * @param value
     *     allowed object is
     *     {@link TelephoneNumberQuerySubscriptionGroupValueRequest }
     *     
     */
    public void setMSISDN(TelephoneNumberQuerySubscriptionGroupValueRequest value) {
        this.msisdn = value;
    }

}
