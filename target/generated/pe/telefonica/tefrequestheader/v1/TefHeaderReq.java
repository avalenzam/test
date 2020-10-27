
package pe.telefonica.tefrequestheader.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.AddOrRemoveBillingOfferRequestType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.ChangeFunPackRequestType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.ChangeProductStatusRequestType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.CreateTokenFnFRequestType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.LocateSubscriptionRequestType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.ModifyServiceRequestType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.QuerySubscriptionGroupValueRequestType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.RequestSVAActivationRequestType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.RequestSVADeactivationRequestType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.RequestType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveCommitmentPenaltyRequestType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveExternalStockUnitRequestType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveFriendsAndFamilyNumbersRequestType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveOrdersHistoryRequestType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveProductHeaderRequestType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveProductOrderStatusRequestType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveServiceByMaskRequestType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.UpdateFriendsAndFamilyNumbersRequestType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.UpdateSingleConfigurationOnProductRequestType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.ValidateTokenFnFRequestType;


/**
 * <p>Clase Java para TefHeaderReq complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TefHeaderReq"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TefHeaderReq" type="{http://telefonica.pe/TefRequestHeader/V1}TefHeaderReqType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TefHeaderReq", propOrder = {
    "tefHeaderReq"
})
@XmlSeeAlso({
    UpdateFriendsAndFamilyNumbersRequestType.class,
    RetrieveServiceByMaskRequestType.class,
    UpdateSingleConfigurationOnProductRequestType.class,
    RetrieveFriendsAndFamilyNumbersRequestType.class,
    RetrieveProductHeaderRequestType.class,
    RetrieveExternalStockUnitRequestType.class,
    RetrieveProductOrderStatusRequestType.class,
    QuerySubscriptionGroupValueRequestType.class,
    ChangeProductStatusRequestType.class,
    LocateSubscriptionRequestType.class,
    RequestSVAActivationRequestType.class,
    RequestSVADeactivationRequestType.class,
    RetrieveOrdersHistoryRequestType.class,
    ChangeFunPackRequestType.class,
    CreateTokenFnFRequestType.class,
    ValidateTokenFnFRequestType.class,
    RetrieveCommitmentPenaltyRequestType.class,
    AddOrRemoveBillingOfferRequestType.class,
    ModifyServiceRequestType.class,
    RequestType.class
})
public class TefHeaderReq {

    @XmlElement(name = "TefHeaderReq", required = true)
    protected TefHeaderReqType tefHeaderReq;

    /**
     * Obtiene el valor de la propiedad tefHeaderReq.
     * 
     * @return
     *     possible object is
     *     {@link TefHeaderReqType }
     *     
     */
    public TefHeaderReqType getTefHeaderReq() {
        return tefHeaderReq;
    }

    /**
     * Define el valor de la propiedad tefHeaderReq.
     * 
     * @param value
     *     allowed object is
     *     {@link TefHeaderReqType }
     *     
     */
    public void setTefHeaderReq(TefHeaderReqType value) {
        this.tefHeaderReq = value;
    }

}
