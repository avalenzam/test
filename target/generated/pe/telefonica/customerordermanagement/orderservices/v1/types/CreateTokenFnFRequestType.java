
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReq;


/**
 * <p>Java class for CreateTokenFnFRequest_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the createTokenFnFRequestData property.
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
     * Sets the value of the createTokenFnFRequestData property.
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
