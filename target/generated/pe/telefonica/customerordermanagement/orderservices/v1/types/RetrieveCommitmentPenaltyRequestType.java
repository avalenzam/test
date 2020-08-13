
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReq;


/**
 * <p>Java class for RetrieveCommitmentPenaltyRequest_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveCommitmentPenaltyRequest_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefRequestHeader/V1}TefHeaderReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RetrieveCommitmentPenaltyRequest_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}RetrieveCommitmentPenaltyRequest_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveCommitmentPenaltyRequest_type", propOrder = {
    "retrieveCommitmentPenaltyRequestData"
})
public class RetrieveCommitmentPenaltyRequestType
    extends TefHeaderReq
{

    @XmlElement(name = "RetrieveCommitmentPenaltyRequest_data", required = true)
    protected RetrieveCommitmentPenaltyRequestDataType retrieveCommitmentPenaltyRequestData;

    /**
     * Gets the value of the retrieveCommitmentPenaltyRequestData property.
     * 
     * @return
     *     possible object is
     *     {@link RetrieveCommitmentPenaltyRequestDataType }
     *     
     */
    public RetrieveCommitmentPenaltyRequestDataType getRetrieveCommitmentPenaltyRequestData() {
        return retrieveCommitmentPenaltyRequestData;
    }

    /**
     * Sets the value of the retrieveCommitmentPenaltyRequestData property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetrieveCommitmentPenaltyRequestDataType }
     *     
     */
    public void setRetrieveCommitmentPenaltyRequestData(RetrieveCommitmentPenaltyRequestDataType value) {
        this.retrieveCommitmentPenaltyRequestData = value;
    }

}
