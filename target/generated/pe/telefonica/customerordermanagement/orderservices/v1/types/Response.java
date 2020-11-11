
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Response complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Response"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="isSuccess" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="errorStatus" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}Status" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Response", propOrder = {
    "isSuccess",
    "errorStatus"
})
public class Response {

    protected boolean isSuccess;
    protected Status errorStatus;

    /**
     * Obtiene el valor de la propiedad isSuccess.
     * 
     */
    public boolean isIsSuccess() {
        return isSuccess;
    }

    /**
     * Define el valor de la propiedad isSuccess.
     * 
     */
    public void setIsSuccess(boolean value) {
        this.isSuccess = value;
    }

    /**
     * Obtiene el valor de la propiedad errorStatus.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getErrorStatus() {
        return errorStatus;
    }

    /**
     * Define el valor de la propiedad errorStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setErrorStatus(Status value) {
        this.errorStatus = value;
    }

}
