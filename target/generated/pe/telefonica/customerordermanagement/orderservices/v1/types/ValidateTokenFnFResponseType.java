
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefresponseheader.v1.TefHeaderRes;


/**
 * <p>Java class for ValidateTokenFnFResponse_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValidateTokenFnFResponse_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefResponseHeader/V1}TefHeaderRes"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ValidateTokenFnFResponse_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ValidateTokenFnFResponse_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidateTokenFnFResponse_type", propOrder = {
    "validateTokenFnFResponseData"
})
public class ValidateTokenFnFResponseType
    extends TefHeaderRes
{

    @XmlElement(name = "ValidateTokenFnFResponse_data", required = true)
    protected ValidateTokenFnFResponseDataType validateTokenFnFResponseData;

    /**
     * Gets the value of the validateTokenFnFResponseData property.
     * 
     * @return
     *     possible object is
     *     {@link ValidateTokenFnFResponseDataType }
     *     
     */
    public ValidateTokenFnFResponseDataType getValidateTokenFnFResponseData() {
        return validateTokenFnFResponseData;
    }

    /**
     * Sets the value of the validateTokenFnFResponseData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidateTokenFnFResponseDataType }
     *     
     */
    public void setValidateTokenFnFResponseData(ValidateTokenFnFResponseDataType value) {
        this.validateTokenFnFResponseData = value;
    }

}
