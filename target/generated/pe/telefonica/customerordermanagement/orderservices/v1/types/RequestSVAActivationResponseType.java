
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefresponseheader.v1.TefHeaderRes;


/**
 * <p>Clase Java para RequestSVAActivationResponse_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RequestSVAActivationResponse_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefResponseHeader/V1}TefHeaderRes"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RequestSVAActivationResponse_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}RequestSVAActivationResponse_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestSVAActivationResponse_type", propOrder = {
    "requestSVAActivationResponseData"
})
public class RequestSVAActivationResponseType
    extends TefHeaderRes
{

    @XmlElement(name = "RequestSVAActivationResponse_data", required = true)
    protected RequestSVAActivationResponseDataType requestSVAActivationResponseData;

    /**
     * Obtiene el valor de la propiedad requestSVAActivationResponseData.
     * 
     * @return
     *     possible object is
     *     {@link RequestSVAActivationResponseDataType }
     *     
     */
    public RequestSVAActivationResponseDataType getRequestSVAActivationResponseData() {
        return requestSVAActivationResponseData;
    }

    /**
     * Define el valor de la propiedad requestSVAActivationResponseData.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestSVAActivationResponseDataType }
     *     
     */
    public void setRequestSVAActivationResponseData(RequestSVAActivationResponseDataType value) {
        this.requestSVAActivationResponseData = value;
    }

}
