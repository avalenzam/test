
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefresponseheader.v1.TefHeaderRes;


/**
 * <p>Clase Java para RequestSVADeactivationResponse_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RequestSVADeactivationResponse_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefResponseHeader/V1}TefHeaderRes"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RequestSVADeactivationResponse_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}RequestSVADeactivationResponse_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestSVADeactivationResponse_type", propOrder = {
    "requestSVADeactivationResponseData"
})
public class RequestSVADeactivationResponseType
    extends TefHeaderRes
{

    @XmlElement(name = "RequestSVADeactivationResponse_data", required = true)
    protected RequestSVADeactivationResponseDataType requestSVADeactivationResponseData;

    /**
     * Obtiene el valor de la propiedad requestSVADeactivationResponseData.
     * 
     * @return
     *     possible object is
     *     {@link RequestSVADeactivationResponseDataType }
     *     
     */
    public RequestSVADeactivationResponseDataType getRequestSVADeactivationResponseData() {
        return requestSVADeactivationResponseData;
    }

    /**
     * Define el valor de la propiedad requestSVADeactivationResponseData.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestSVADeactivationResponseDataType }
     *     
     */
    public void setRequestSVADeactivationResponseData(RequestSVADeactivationResponseDataType value) {
        this.requestSVADeactivationResponseData = value;
    }

}
