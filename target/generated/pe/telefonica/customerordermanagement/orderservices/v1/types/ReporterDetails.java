
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ReporterDetails complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ReporterDetails"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="identificationType"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="40"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="identificationNumber"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="MSISDN" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ReporterTelephoneNumber"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReporterDetails", propOrder = {
    "identificationType",
    "identificationNumber",
    "msisdn"
})
public class ReporterDetails {

    @XmlElement(required = true)
    protected String identificationType;
    @XmlElement(required = true)
    protected String identificationNumber;
    @XmlElement(name = "MSISDN", required = true)
    protected ReporterTelephoneNumber msisdn;

    /**
     * Obtiene el valor de la propiedad identificationType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificationType() {
        return identificationType;
    }

    /**
     * Define el valor de la propiedad identificationType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificationType(String value) {
        this.identificationType = value;
    }

    /**
     * Obtiene el valor de la propiedad identificationNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Define el valor de la propiedad identificationNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificationNumber(String value) {
        this.identificationNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad msisdn.
     * 
     * @return
     *     possible object is
     *     {@link ReporterTelephoneNumber }
     *     
     */
    public ReporterTelephoneNumber getMSISDN() {
        return msisdn;
    }

    /**
     * Define el valor de la propiedad msisdn.
     * 
     * @param value
     *     allowed object is
     *     {@link ReporterTelephoneNumber }
     *     
     */
    public void setMSISDN(ReporterTelephoneNumber value) {
        this.msisdn = value;
    }

}
