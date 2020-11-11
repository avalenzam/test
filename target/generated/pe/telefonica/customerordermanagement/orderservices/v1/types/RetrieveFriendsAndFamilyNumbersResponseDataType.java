
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RetrieveFriendsAndFamilyNumbersResponse_data_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RetrieveFriendsAndFamilyNumbersResponse_data_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="response" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}Response"/&gt;
 *         &lt;element name="friendsAndFamilyDetailsList" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}FNFDetailsList"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveFriendsAndFamilyNumbersResponse_data_type", propOrder = {
    "response",
    "friendsAndFamilyDetailsList"
})
public class RetrieveFriendsAndFamilyNumbersResponseDataType {

    @XmlElement(required = true)
    protected Response response;
    @XmlElement(required = true)
    protected FNFDetailsList friendsAndFamilyDetailsList;

    /**
     * Obtiene el valor de la propiedad response.
     * 
     * @return
     *     possible object is
     *     {@link Response }
     *     
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Define el valor de la propiedad response.
     * 
     * @param value
     *     allowed object is
     *     {@link Response }
     *     
     */
    public void setResponse(Response value) {
        this.response = value;
    }

    /**
     * Obtiene el valor de la propiedad friendsAndFamilyDetailsList.
     * 
     * @return
     *     possible object is
     *     {@link FNFDetailsList }
     *     
     */
    public FNFDetailsList getFriendsAndFamilyDetailsList() {
        return friendsAndFamilyDetailsList;
    }

    /**
     * Define el valor de la propiedad friendsAndFamilyDetailsList.
     * 
     * @param value
     *     allowed object is
     *     {@link FNFDetailsList }
     *     
     */
    public void setFriendsAndFamilyDetailsList(FNFDetailsList value) {
        this.friendsAndFamilyDetailsList = value;
    }

}
