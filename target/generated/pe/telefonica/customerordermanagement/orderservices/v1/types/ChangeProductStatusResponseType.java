
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefresponseheader.v1.TefHeaderRes;


/**
 * <p>Java class for ChangeProductStatusResponse_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChangeProductStatusResponse_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefResponseHeader/V1}TefHeaderRes"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ChangeProductStatusResponse_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ChangeProductStatusResponse_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangeProductStatusResponse_type", propOrder = {
    "changeProductStatusResponseData"
})
public class ChangeProductStatusResponseType
    extends TefHeaderRes
{

    @XmlElement(name = "ChangeProductStatusResponse_data", required = true)
    protected ChangeProductStatusResponseDataType changeProductStatusResponseData;

    /**
     * Gets the value of the changeProductStatusResponseData property.
     * 
     * @return
     *     possible object is
     *     {@link ChangeProductStatusResponseDataType }
     *     
     */
    public ChangeProductStatusResponseDataType getChangeProductStatusResponseData() {
        return changeProductStatusResponseData;
    }

    /**
     * Sets the value of the changeProductStatusResponseData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChangeProductStatusResponseDataType }
     *     
     */
    public void setChangeProductStatusResponseData(ChangeProductStatusResponseDataType value) {
        this.changeProductStatusResponseData = value;
    }

}
