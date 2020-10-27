
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefresponseheader.v1.TefHeaderRes;


/**
 * <p>Clase Java para Response_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Response_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefResponseHeader/V1}TefHeaderRes"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Response_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}Response_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Response_type", propOrder = {
    "responseData"
})
public class ResponseType
    extends TefHeaderRes
{

    @XmlElement(name = "Response_data", required = true)
    protected ResponseDataType responseData;

    /**
     * Obtiene el valor de la propiedad responseData.
     * 
     * @return
     *     possible object is
     *     {@link ResponseDataType }
     *     
     */
    public ResponseDataType getResponseData() {
        return responseData;
    }

    /**
     * Define el valor de la propiedad responseData.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseDataType }
     *     
     */
    public void setResponseData(ResponseDataType value) {
        this.responseData = value;
    }

}
