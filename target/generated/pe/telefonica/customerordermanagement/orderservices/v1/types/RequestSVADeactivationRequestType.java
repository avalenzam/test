
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReq;


/**
 * <p>Clase Java para RequestSVADeactivationRequest_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad requestSVADeactivationRequestData.
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
     * Define el valor de la propiedad requestSVADeactivationRequestData.
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
