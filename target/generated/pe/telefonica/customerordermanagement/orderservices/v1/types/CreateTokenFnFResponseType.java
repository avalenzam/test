
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefresponseheader.v1.TefHeaderRes;


/**
 * <p>Java class for CreateTokenFnFResponse_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateTokenFnFResponse_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefResponseHeader/V1}TefHeaderRes"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CreateTokenFnFResponse_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}CreateTokenFnFesponse_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateTokenFnFResponse_type", propOrder = {
    "createTokenFnFResponseData"
})
public class CreateTokenFnFResponseType
    extends TefHeaderRes
{

    @XmlElement(name = "CreateTokenFnFResponse_data", required = true)
    protected CreateTokenFnFesponseDataType createTokenFnFResponseData;

    /**
     * Gets the value of the createTokenFnFResponseData property.
     * 
     * @return
     *     possible object is
     *     {@link CreateTokenFnFesponseDataType }
     *     
     */
    public CreateTokenFnFesponseDataType getCreateTokenFnFResponseData() {
        return createTokenFnFResponseData;
    }

    /**
     * Sets the value of the createTokenFnFResponseData property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateTokenFnFesponseDataType }
     *     
     */
    public void setCreateTokenFnFResponseData(CreateTokenFnFesponseDataType value) {
        this.createTokenFnFResponseData = value;
    }

}
