
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReq;


/**
 * <p>Java class for UpdateFriendsAndFamilyNumbersRequest_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateFriendsAndFamilyNumbersRequest_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefRequestHeader/V1}TefHeaderReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UpdateFriendsAndFamilyNumbersRequest_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}UpdateFriendsAndFamilyNumbersRequest_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateFriendsAndFamilyNumbersRequest_type", propOrder = {
    "updateFriendsAndFamilyNumbersRequestData"
})
public class UpdateFriendsAndFamilyNumbersRequestType
    extends TefHeaderReq
{

    @XmlElement(name = "UpdateFriendsAndFamilyNumbersRequest_data", required = true)
    protected UpdateFriendsAndFamilyNumbersRequestDataType updateFriendsAndFamilyNumbersRequestData;

    /**
     * Gets the value of the updateFriendsAndFamilyNumbersRequestData property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateFriendsAndFamilyNumbersRequestDataType }
     *     
     */
    public UpdateFriendsAndFamilyNumbersRequestDataType getUpdateFriendsAndFamilyNumbersRequestData() {
        return updateFriendsAndFamilyNumbersRequestData;
    }

    /**
     * Sets the value of the updateFriendsAndFamilyNumbersRequestData property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateFriendsAndFamilyNumbersRequestDataType }
     *     
     */
    public void setUpdateFriendsAndFamilyNumbersRequestData(UpdateFriendsAndFamilyNumbersRequestDataType value) {
        this.updateFriendsAndFamilyNumbersRequestData = value;
    }

}
