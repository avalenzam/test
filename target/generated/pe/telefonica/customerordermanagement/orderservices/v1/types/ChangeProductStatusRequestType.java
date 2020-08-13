
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReq;


/**
 * <p>Java class for ChangeProductStatusRequest_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChangeProductStatusRequest_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefRequestHeader/V1}TefHeaderReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ChangeProductStatusRequest_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ChangeProductStatusRequest_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangeProductStatusRequest_type", propOrder = {
    "changeProductStatusRequestData"
})
public class ChangeProductStatusRequestType
    extends TefHeaderReq
{

    @XmlElement(name = "ChangeProductStatusRequest_data", required = true)
    protected ChangeProductStatusRequestDataType changeProductStatusRequestData;

    /**
     * Gets the value of the changeProductStatusRequestData property.
     * 
     * @return
     *     possible object is
     *     {@link ChangeProductStatusRequestDataType }
     *     
     */
    public ChangeProductStatusRequestDataType getChangeProductStatusRequestData() {
        return changeProductStatusRequestData;
    }

    /**
     * Sets the value of the changeProductStatusRequestData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChangeProductStatusRequestDataType }
     *     
     */
    public void setChangeProductStatusRequestData(ChangeProductStatusRequestDataType value) {
        this.changeProductStatusRequestData = value;
    }

}
