
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefresponseheader.v1.TefHeaderRes;


/**
 * <p>Clase Java para LocateSubscriptionResponse_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LocateSubscriptionResponse_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefResponseHeader/V1}TefHeaderRes"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LocateSubscriptionResponse_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}LocateSubscriptionResponse_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocateSubscriptionResponse_type", propOrder = {
    "locateSubscriptionResponseData"
})
public class LocateSubscriptionResponseType
    extends TefHeaderRes
{

    @XmlElement(name = "LocateSubscriptionResponse_data", required = true)
    protected LocateSubscriptionResponseDataType locateSubscriptionResponseData;

    /**
     * Obtiene el valor de la propiedad locateSubscriptionResponseData.
     * 
     * @return
     *     possible object is
     *     {@link LocateSubscriptionResponseDataType }
     *     
     */
    public LocateSubscriptionResponseDataType getLocateSubscriptionResponseData() {
        return locateSubscriptionResponseData;
    }

    /**
     * Define el valor de la propiedad locateSubscriptionResponseData.
     * 
     * @param value
     *     allowed object is
     *     {@link LocateSubscriptionResponseDataType }
     *     
     */
    public void setLocateSubscriptionResponseData(LocateSubscriptionResponseDataType value) {
        this.locateSubscriptionResponseData = value;
    }

}
