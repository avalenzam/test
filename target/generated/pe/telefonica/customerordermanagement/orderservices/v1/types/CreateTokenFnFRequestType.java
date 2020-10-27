
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReq;


/**
 * <p>Clase Java para CreateTokenFnFRequest_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CreateTokenFnFRequest_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefRequestHeader/V1}TefHeaderReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CreateTokenFnFRequest_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}CreateTokenFnFRequest_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateTokenFnFRequest_type", propOrder = {
    "createTokenFnFRequestData"
})
public class CreateTokenFnFRequestType
    extends TefHeaderReq
{

    @XmlElement(name = "CreateTokenFnFRequest_data", required = true)
    protected CreateTokenFnFRequestDataType createTokenFnFRequestData;

    /**
     * Obtiene el valor de la propiedad createTokenFnFRequestData.
     * 
     * @return
     *     possible object is
     *     {@link CreateTokenFnFRequestDataType }
     *     
     */
    public CreateTokenFnFRequestDataType getCreateTokenFnFRequestData() {
        return createTokenFnFRequestData;
    }

    /**
     * Define el valor de la propiedad createTokenFnFRequestData.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateTokenFnFRequestDataType }
     *     
     */
    public void setCreateTokenFnFRequestData(CreateTokenFnFRequestDataType value) {
        this.createTokenFnFRequestData = value;
    }

}
