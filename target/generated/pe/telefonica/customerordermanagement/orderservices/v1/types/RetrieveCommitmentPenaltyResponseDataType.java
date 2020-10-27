
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RetrieveCommitmentPenaltyResponse_data_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad devicePenaltyInfo.
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
     * Define el valor de la propiedad devicePenaltyInfo.
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
     * Obtiene el valor de la propiedad status.
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
     * Define el valor de la propiedad status.
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
