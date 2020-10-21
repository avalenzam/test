
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefresponseheader.v1.TefHeaderRes;


/**
 * <p>Clase Java para RetrieveCommitmentPenaltyResponse_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RetrieveCommitmentPenaltyResponse_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefResponseHeader/V1}TefHeaderRes"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RetrieveCommitmentPenaltyResponse_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}RetrieveCommitmentPenaltyResponse_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveCommitmentPenaltyResponse_type", propOrder = {
    "retrieveCommitmentPenaltyResponseData"
})
public class RetrieveCommitmentPenaltyResponseType
    extends TefHeaderRes
{

    @XmlElement(name = "RetrieveCommitmentPenaltyResponse_data", required = true)
    protected RetrieveCommitmentPenaltyResponseDataType retrieveCommitmentPenaltyResponseData;

    /**
     * Obtiene el valor de la propiedad retrieveCommitmentPenaltyResponseData.
     * 
     * @return
     *     possible object is
     *     {@link RetrieveCommitmentPenaltyResponseDataType }
     *     
     */
    public RetrieveCommitmentPenaltyResponseDataType getRetrieveCommitmentPenaltyResponseData() {
        return retrieveCommitmentPenaltyResponseData;
    }

    /**
     * Define el valor de la propiedad retrieveCommitmentPenaltyResponseData.
     * 
     * @param value
     *     allowed object is
     *     {@link RetrieveCommitmentPenaltyResponseDataType }
     *     
     */
    public void setRetrieveCommitmentPenaltyResponseData(RetrieveCommitmentPenaltyResponseDataType value) {
        this.retrieveCommitmentPenaltyResponseData = value;
    }

}
