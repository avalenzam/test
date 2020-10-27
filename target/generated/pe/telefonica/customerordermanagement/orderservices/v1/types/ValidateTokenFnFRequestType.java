
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReq;


/**
 * <p>Clase Java para ValidateTokenFnFRequest_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ValidateTokenFnFRequest_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefRequestHeader/V1}TefHeaderReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ValidateTokenFnFRequest_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ValidateTokenFnFRequest_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidateTokenFnFRequest_type", propOrder = {
    "validateTokenFnFRequestData"
})
public class ValidateTokenFnFRequestType
    extends TefHeaderReq
{

    @XmlElement(name = "ValidateTokenFnFRequest_data", required = true)
    protected ValidateTokenFnFRequestDataType validateTokenFnFRequestData;

    /**
     * Obtiene el valor de la propiedad validateTokenFnFRequestData.
     * 
     * @return
     *     possible object is
     *     {@link ValidateTokenFnFRequestDataType }
     *     
     */
    public ValidateTokenFnFRequestDataType getValidateTokenFnFRequestData() {
        return validateTokenFnFRequestData;
    }

    /**
     * Define el valor de la propiedad validateTokenFnFRequestData.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidateTokenFnFRequestDataType }
     *     
     */
    public void setValidateTokenFnFRequestData(ValidateTokenFnFRequestDataType value) {
        this.validateTokenFnFRequestData = value;
    }

}
