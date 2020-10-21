
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefresponseheader.v1.TefHeaderRes;


/**
 * <p>Clase Java para AddOrRemoveBillingOfferResponse_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AddOrRemoveBillingOfferResponse_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefResponseHeader/V1}TefHeaderRes"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AddOrRemoveBillingOfferResponse_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}AddOrRemoveBillingOfferResponse_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddOrRemoveBillingOfferResponse_type", propOrder = {
    "addOrRemoveBillingOfferResponseData"
})
public class AddOrRemoveBillingOfferResponseType
    extends TefHeaderRes
{

    @XmlElement(name = "AddOrRemoveBillingOfferResponse_data", required = true)
    protected AddOrRemoveBillingOfferResponseDataType addOrRemoveBillingOfferResponseData;

    /**
     * Obtiene el valor de la propiedad addOrRemoveBillingOfferResponseData.
     * 
     * @return
     *     possible object is
     *     {@link AddOrRemoveBillingOfferResponseDataType }
     *     
     */
    public AddOrRemoveBillingOfferResponseDataType getAddOrRemoveBillingOfferResponseData() {
        return addOrRemoveBillingOfferResponseData;
    }

    /**
     * Define el valor de la propiedad addOrRemoveBillingOfferResponseData.
     * 
     * @param value
     *     allowed object is
     *     {@link AddOrRemoveBillingOfferResponseDataType }
     *     
     */
    public void setAddOrRemoveBillingOfferResponseData(AddOrRemoveBillingOfferResponseDataType value) {
        this.addOrRemoveBillingOfferResponseData = value;
    }

}
