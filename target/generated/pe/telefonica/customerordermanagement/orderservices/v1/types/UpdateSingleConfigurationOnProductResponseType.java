
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefresponseheader.v1.TefHeaderRes;


/**
 * <p>Java class for UpdateSingleConfigurationOnProductResponse_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateSingleConfigurationOnProductResponse_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefResponseHeader/V1}TefHeaderRes"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UpdateSingleConfigurationOnProductResponse_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}UpdateSingleConfigurationOnProductResponse_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateSingleConfigurationOnProductResponse_type", propOrder = {
    "updateSingleConfigurationOnProductResponseData"
})
public class UpdateSingleConfigurationOnProductResponseType
    extends TefHeaderRes
{

    @XmlElement(name = "UpdateSingleConfigurationOnProductResponse_data", required = true)
    protected UpdateSingleConfigurationOnProductResponseDataType updateSingleConfigurationOnProductResponseData;

    /**
     * Gets the value of the updateSingleConfigurationOnProductResponseData property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateSingleConfigurationOnProductResponseDataType }
     *     
     */
    public UpdateSingleConfigurationOnProductResponseDataType getUpdateSingleConfigurationOnProductResponseData() {
        return updateSingleConfigurationOnProductResponseData;
    }

    /**
     * Sets the value of the updateSingleConfigurationOnProductResponseData property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateSingleConfigurationOnProductResponseDataType }
     *     
     */
    public void setUpdateSingleConfigurationOnProductResponseData(UpdateSingleConfigurationOnProductResponseDataType value) {
        this.updateSingleConfigurationOnProductResponseData = value;
    }

}
