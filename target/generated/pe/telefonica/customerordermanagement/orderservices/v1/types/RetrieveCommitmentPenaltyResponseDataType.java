
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetrieveCommitmentPenaltyResponse_data_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveCommitmentPenaltyResponse_data_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="devicePenaltyInfo" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}DevicePenaltyInfo"/&gt;
 *         &lt;element name="status" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}Status"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveCommitmentPenaltyResponse_data_type", propOrder = {
    "devicePenaltyInfo",
    "status"
})
public class RetrieveCommitmentPenaltyResponseDataType {

    @XmlElement(required = true)
    protected DevicePenaltyInfo devicePenaltyInfo;
    @XmlElement(required = true)
    protected Status status;

    /**
     * Gets the value of the devicePenaltyInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DevicePenaltyInfo }
     *     
     */
    public DevicePenaltyInfo getDevicePenaltyInfo() {
        return devicePenaltyInfo;
    }

    /**
     * Sets the value of the devicePenaltyInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DevicePenaltyInfo }
     *     
     */
    public void setDevicePenaltyInfo(DevicePenaltyInfo value) {
        this.devicePenaltyInfo = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setStatus(Status value) {
        this.status = value;
    }

}
