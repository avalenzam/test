
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReq;


/**
 * <p>Clase Java para LocateSubscriptionRequest_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LocateSubscriptionRequest_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefRequestHeader/V1}TefHeaderReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LocateSubscriptionRequest_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}LocateSubscriptionRequest_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocateSubscriptionRequest_type", propOrder = {
    "locateSubscriptionRequestData"
})
public class LocateSubscriptionRequestType
    extends TefHeaderReq
{

    @XmlElement(name = "LocateSubscriptionRequest_data", required = true)
    protected LocateSubscriptionRequestDataType locateSubscriptionRequestData;

    /**
     * Obtiene el valor de la propiedad locateSubscriptionRequestData.
     * 
     * @return
     *     possible object is
     *     {@link LocateSubscriptionRequestDataType }
     *     
     */
    public LocateSubscriptionRequestDataType getLocateSubscriptionRequestData() {
        return locateSubscriptionRequestData;
    }

    /**
     * Define el valor de la propiedad locateSubscriptionRequestData.
     * 
     * @param value
     *     allowed object is
     *     {@link LocateSubscriptionRequestDataType }
     *     
     */
    public void setLocateSubscriptionRequestData(LocateSubscriptionRequestDataType value) {
        this.locateSubscriptionRequestData = value;
    }

}
