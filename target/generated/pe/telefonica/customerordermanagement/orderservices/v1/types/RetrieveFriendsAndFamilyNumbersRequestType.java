
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReq;


/**
 * <p>Java class for RetrieveFriendsAndFamilyNumbersRequest_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveFriendsAndFamilyNumbersRequest_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefRequestHeader/V1}TefHeaderReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RetrieveFriendsAndFamilyNumbersRequest_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}RetrieveFriendsAndFamilyNumbersRequest_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveFriendsAndFamilyNumbersRequest_type", propOrder = {
    "retrieveFriendsAndFamilyNumbersRequestData"
})
public class RetrieveFriendsAndFamilyNumbersRequestType
    extends TefHeaderReq
{

    @XmlElement(name = "RetrieveFriendsAndFamilyNumbersRequest_data", required = true)
    protected RetrieveFriendsAndFamilyNumbersRequestDataType retrieveFriendsAndFamilyNumbersRequestData;

    /**
     * Gets the value of the retrieveFriendsAndFamilyNumbersRequestData property.
     * 
     * @return
     *     possible object is
     *     {@link RetrieveFriendsAndFamilyNumbersRequestDataType }
     *     
     */
    public RetrieveFriendsAndFamilyNumbersRequestDataType getRetrieveFriendsAndFamilyNumbersRequestData() {
        return retrieveFriendsAndFamilyNumbersRequestData;
    }

    /**
     * Sets the value of the retrieveFriendsAndFamilyNumbersRequestData property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetrieveFriendsAndFamilyNumbersRequestDataType }
     *     
     */
    public void setRetrieveFriendsAndFamilyNumbersRequestData(RetrieveFriendsAndFamilyNumbersRequestDataType value) {
        this.retrieveFriendsAndFamilyNumbersRequestData = value;
    }

}
