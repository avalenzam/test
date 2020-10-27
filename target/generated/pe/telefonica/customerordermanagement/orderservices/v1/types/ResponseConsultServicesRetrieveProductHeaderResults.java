
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Response_ConsultServicesRetrieveProductHeaderResults complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Response_ConsultServicesRetrieveProductHeaderResults"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="rejectStatus" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}rejectStatus" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Response_ConsultServicesRetrieveProductHeaderResults", propOrder = {
    "status",
    "rejectStatus"
})
public class ResponseConsultServicesRetrieveProductHeaderResults {

    protected boolean status;
    protected RejectStatus rejectStatus;

    /**
     * Obtiene el valor de la propiedad status.
     * 
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Define el valor de la propiedad status.
     * 
     */
    public void setStatus(boolean value) {
        this.status = value;
    }

    /**
     * Obtiene el valor de la propiedad rejectStatus.
     * 
     * @return
     *     possible object is
     *     {@link RejectStatus }
     *     
     */
    public RejectStatus getRejectStatus() {
        return rejectStatus;
    }

    /**
     * Define el valor de la propiedad rejectStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link RejectStatus }
     *     
     */
    public void setRejectStatus(RejectStatus value) {
        this.rejectStatus = value;
    }

}
