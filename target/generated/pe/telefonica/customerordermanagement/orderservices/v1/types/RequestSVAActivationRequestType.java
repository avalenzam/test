
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReq;


/**
 * <p>Clase Java para RequestSVAActivationRequest_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RequestSVAActivationRequest_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefRequestHeader/V1}TefHeaderReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RequestSVAActivationRequest_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}RequestSVAActivationRequest_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestSVAActivationRequest_type", propOrder = {
    "requestSVAActivationRequestData"
})
public class RequestSVAActivationRequestType
    extends TefHeaderReq
{

    @XmlElement(name = "RequestSVAActivationRequest_data", required = true)
    protected RequestSVAActivationRequestDataType requestSVAActivationRequestData;

    /**
     * Obtiene el valor de la propiedad requestSVAActivationRequestData.
     * 
     * @return
     *     possible object is
     *     {@link RequestSVAActivationRequestDataType }
     *     
     */
    public RequestSVAActivationRequestDataType getRequestSVAActivationRequestData() {
        return requestSVAActivationRequestData;
    }

    /**
     * Define el valor de la propiedad requestSVAActivationRequestData.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestSVAActivationRequestDataType }
     *     
     */
    public void setRequestSVAActivationRequestData(RequestSVAActivationRequestDataType value) {
        this.requestSVAActivationRequestData = value;
    }

}
