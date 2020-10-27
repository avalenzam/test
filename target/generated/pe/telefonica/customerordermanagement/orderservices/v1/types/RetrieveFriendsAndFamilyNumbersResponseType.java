
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefresponseheader.v1.TefHeaderRes;


/**
 * <p>Java class for RetrieveFriendsAndFamilyNumbersResponse_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveFriendsAndFamilyNumbersResponse_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefResponseHeader/V1}TefHeaderRes"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RetrieveFriendsAndFamilyNumbersResponse_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}RetrieveFriendsAndFamilyNumbersResponse_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveFriendsAndFamilyNumbersResponse_type", propOrder = {
    "retrieveFriendsAndFamilyNumbersResponseData"
})
public class RetrieveFriendsAndFamilyNumbersResponseType
    extends TefHeaderRes
{

    @XmlElement(name = "RetrieveFriendsAndFamilyNumbersResponse_data", required = true)
    protected RetrieveFriendsAndFamilyNumbersResponseDataType retrieveFriendsAndFamilyNumbersResponseData;

    /**
     * Gets the value of the retrieveFriendsAndFamilyNumbersResponseData property.
     * 
     * @return
     *     possible object is
     *     {@link RetrieveFriendsAndFamilyNumbersResponseDataType }
     *     
     */
    public RetrieveFriendsAndFamilyNumbersResponseDataType getRetrieveFriendsAndFamilyNumbersResponseData() {
        return retrieveFriendsAndFamilyNumbersResponseData;
    }

    /**
     * Sets the value of the retrieveFriendsAndFamilyNumbersResponseData property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetrieveFriendsAndFamilyNumbersResponseDataType }
     *     
     */
    public void setRetrieveFriendsAndFamilyNumbersResponseData(RetrieveFriendsAndFamilyNumbersResponseDataType value) {
        this.retrieveFriendsAndFamilyNumbersResponseData = value;
    }

}
