
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefresponseheader.v1.TefHeaderRes;


/**
 * <p>Java class for RetrieveCommitmentPenaltyResponse_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the retrieveCommitmentPenaltyResponseData property.
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
     * Sets the value of the retrieveCommitmentPenaltyResponseData property.
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
