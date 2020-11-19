
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefresponseheader.v1.TefHeaderRes;


/**
 * <p>Java class for LocateSubscriptionResponse_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the locateSubscriptionResponseData property.
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
     * Sets the value of the locateSubscriptionResponseData property.
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
