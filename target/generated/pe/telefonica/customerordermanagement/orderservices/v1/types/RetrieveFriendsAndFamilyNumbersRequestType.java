
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReq;


/**
 * <p>Clase Java para RetrieveFriendsAndFamilyNumbersRequest_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad retrieveFriendsAndFamilyNumbersRequestData.
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
     * Define el valor de la propiedad retrieveFriendsAndFamilyNumbersRequestData.
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
