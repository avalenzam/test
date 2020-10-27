
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReq;


/**
 * <p>Java class for UpdateSingleConfigurationOnProductRequest_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateSingleConfigurationOnProductRequest_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefRequestHeader/V1}TefHeaderReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UpdateSingleConfigurationOnProductRequest_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}UpdateSingleConfigurationOnProductRequest_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateSingleConfigurationOnProductRequest_type", propOrder = {
    "updateSingleConfigurationOnProductRequestData"
})
public class UpdateSingleConfigurationOnProductRequestType
    extends TefHeaderReq
{

    @XmlElement(name = "UpdateSingleConfigurationOnProductRequest_data", required = true)
    protected UpdateSingleConfigurationOnProductRequestDataType updateSingleConfigurationOnProductRequestData;

    /**
     * Gets the value of the updateSingleConfigurationOnProductRequestData property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateSingleConfigurationOnProductRequestDataType }
     *     
     */
    public UpdateSingleConfigurationOnProductRequestDataType getUpdateSingleConfigurationOnProductRequestData() {
        return updateSingleConfigurationOnProductRequestData;
    }

    /**
     * Sets the value of the updateSingleConfigurationOnProductRequestData property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateSingleConfigurationOnProductRequestDataType }
     *     
     */
    public void setUpdateSingleConfigurationOnProductRequestData(UpdateSingleConfigurationOnProductRequestDataType value) {
        this.updateSingleConfigurationOnProductRequestData = value;
    }

}
