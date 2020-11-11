
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefresponseheader.v1.TefHeaderRes;


/**
 * <p>Clase Java para UpdateFriendsAndFamilyNumbersResponse_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="UpdateFriendsAndFamilyNumbersResponse_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefResponseHeader/V1}TefHeaderRes"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UpdateFriendsAndFamilyNumbersResponse_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}UpdateFriendsAndFamilyNumbersResponse_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateFriendsAndFamilyNumbersResponse_type", propOrder = {
    "updateFriendsAndFamilyNumbersResponseData"
})
public class UpdateFriendsAndFamilyNumbersResponseType
    extends TefHeaderRes
{

    @XmlElement(name = "UpdateFriendsAndFamilyNumbersResponse_data", required = true)
    protected UpdateFriendsAndFamilyNumbersResponseDataType updateFriendsAndFamilyNumbersResponseData;

    /**
     * Obtiene el valor de la propiedad updateFriendsAndFamilyNumbersResponseData.
     * 
     * @return
     *     possible object is
     *     {@link UpdateFriendsAndFamilyNumbersResponseDataType }
     *     
     */
    public UpdateFriendsAndFamilyNumbersResponseDataType getUpdateFriendsAndFamilyNumbersResponseData() {
        return updateFriendsAndFamilyNumbersResponseData;
    }

    /**
     * Define el valor de la propiedad updateFriendsAndFamilyNumbersResponseData.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateFriendsAndFamilyNumbersResponseDataType }
     *     
     */
    public void setUpdateFriendsAndFamilyNumbersResponseData(UpdateFriendsAndFamilyNumbersResponseDataType value) {
        this.updateFriendsAndFamilyNumbersResponseData = value;
    }

}
