
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReq;


/**
 * <p>Java class for RequestSVADeactivationRequest_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestSVADeactivationRequest_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefRequestHeader/V1}TefHeaderReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RequestSVADeactivationRequest_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}RequestSVADeactivationRequest_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestSVADeactivationRequest_type", propOrder = {
    "requestSVADeactivationRequestData"
})
public class RequestSVADeactivationRequestType
    extends TefHeaderReq
{

    @XmlElement(name = "RequestSVADeactivationRequest_data", required = true)
    protected RequestSVADeactivationRequestDataType requestSVADeactivationRequestData;

    /**
     * Gets the value of the requestSVADeactivationRequestData property.
     * 
     * @return
     *     possible object is
     *     {@link RequestSVADeactivationRequestDataType }
     *     
     */
    public RequestSVADeactivationRequestDataType getRequestSVADeactivationRequestData() {
        return requestSVADeactivationRequestData;
    }

    /**
     * Sets the value of the requestSVADeactivationRequestData property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestSVADeactivationRequestDataType }
     *     
     */
    public void setRequestSVADeactivationRequestData(RequestSVADeactivationRequestDataType value) {
        this.requestSVADeactivationRequestData = value;
    }

}
