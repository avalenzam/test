
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReq;


/**
 * <p>Clase Java para AddOrRemoveBillingOfferRequest_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AddOrRemoveBillingOfferRequest_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefRequestHeader/V1}TefHeaderReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AddOrRemoveBillingOfferRequest_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}AddOrRemoveBillingOfferRequest_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddOrRemoveBillingOfferRequest_type", propOrder = {
    "addOrRemoveBillingOfferRequestData"
})
public class AddOrRemoveBillingOfferRequestType
    extends TefHeaderReq
{

    @XmlElement(name = "AddOrRemoveBillingOfferRequest_data", required = true)
    protected AddOrRemoveBillingOfferRequestDataType addOrRemoveBillingOfferRequestData;

    /**
     * Obtiene el valor de la propiedad addOrRemoveBillingOfferRequestData.
     * 
     * @return
     *     possible object is
     *     {@link AddOrRemoveBillingOfferRequestDataType }
     *     
     */
    public AddOrRemoveBillingOfferRequestDataType getAddOrRemoveBillingOfferRequestData() {
        return addOrRemoveBillingOfferRequestData;
    }

    /**
     * Define el valor de la propiedad addOrRemoveBillingOfferRequestData.
     * 
     * @param value
     *     allowed object is
     *     {@link AddOrRemoveBillingOfferRequestDataType }
     *     
     */
    public void setAddOrRemoveBillingOfferRequestData(AddOrRemoveBillingOfferRequestDataType value) {
        this.addOrRemoveBillingOfferRequestData = value;
    }

}
