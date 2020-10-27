
package pe.telefonica.tefresponseheader.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.AddOrRemoveBillingOfferResponseType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.ChangeFunPackResponseType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.ChangeProductStatusResponseType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.CreateTokenFnFResponseType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.LocateSubscriptionResponseType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.ModifyServiceResponseType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.QuerySubscriptionGroupValueResponseType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.RequestSVAActivationResponseType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.RequestSVADeactivationResponseType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.ResponseType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveCommitmentPenaltyResponseType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveExternalStockUnitResponseType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveFriendsAndFamilyNumbersResponseType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveOrdersHistoryResponseType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveProductHeaderResponseType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveProductOrderStatusResponseType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveServiceByMaskResponseType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.UpdateFriendsAndFamilyNumbersResponseType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.UpdateSingleConfigurationOnProductResponseType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.ValidateTokenFnFResponseType;


/**
 * <p>Clase Java para TefHeaderRes complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TefHeaderRes"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TefHeaderRes" type="{http://telefonica.pe/TefResponseHeader/V1}TefHeaderResType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TefHeaderRes", propOrder = {
    "tefHeaderRes"
})
@XmlSeeAlso({
    UpdateFriendsAndFamilyNumbersResponseType.class,
    RetrieveServiceByMaskResponseType.class,
    UpdateSingleConfigurationOnProductResponseType.class,
    RetrieveFriendsAndFamilyNumbersResponseType.class,
    RetrieveProductHeaderResponseType.class,
    RetrieveExternalStockUnitResponseType.class,
    RetrieveProductOrderStatusResponseType.class,
    QuerySubscriptionGroupValueResponseType.class,
    ChangeProductStatusResponseType.class,
    LocateSubscriptionResponseType.class,
    RequestSVAActivationResponseType.class,
    RequestSVADeactivationResponseType.class,
    RetrieveOrdersHistoryResponseType.class,
    ChangeFunPackResponseType.class,
    CreateTokenFnFResponseType.class,
    ValidateTokenFnFResponseType.class,
    RetrieveCommitmentPenaltyResponseType.class,
    AddOrRemoveBillingOfferResponseType.class,
    ModifyServiceResponseType.class,
    ResponseType.class
})
public class TefHeaderRes {

    @XmlElement(name = "TefHeaderRes", required = true)
    protected TefHeaderResType tefHeaderRes;

    /**
     * Obtiene el valor de la propiedad tefHeaderRes.
     * 
     * @return
     *     possible object is
     *     {@link TefHeaderResType }
     *     
     */
    public TefHeaderResType getTefHeaderRes() {
        return tefHeaderRes;
    }

    /**
     * Define el valor de la propiedad tefHeaderRes.
     * 
     * @param value
     *     allowed object is
     *     {@link TefHeaderResType }
     *     
     */
    public void setTefHeaderRes(TefHeaderResType value) {
        this.tefHeaderRes = value;
    }

}
