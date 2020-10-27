
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReq;


/**
 * <p>Clase Java para Request_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Request_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefRequestHeader/V1}TefHeaderReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Request_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}Request_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Request_type", propOrder = {
    "requestData"
})
public class RequestType
    extends TefHeaderReq
{

    @XmlElement(name = "Request_data", required = true)
    protected RequestDataType requestData;

    /**
     * Obtiene el valor de la propiedad requestData.
     * 
     * @return
     *     possible object is
     *     {@link RequestDataType }
     *     
     */
    public RequestDataType getRequestData() {
        return requestData;
    }

    /**
     * Define el valor de la propiedad requestData.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestDataType }
     *     
     */
    public void setRequestData(RequestDataType value) {
        this.requestData = value;
    }

}
