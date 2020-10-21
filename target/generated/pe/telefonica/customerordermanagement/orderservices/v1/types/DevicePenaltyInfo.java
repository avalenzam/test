
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para DevicePenaltyInfo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DevicePenaltyInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="deviceSapId" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="commitmentEndDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="penaltyAmountWithTax" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="25"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="penaltyAmountWithoutTax" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="25"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="penaltyCurrency" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="10"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DevicePenaltyInfo", propOrder = {
    "deviceSapId",
    "commitmentEndDate",
    "penaltyAmountWithTax",
    "penaltyAmountWithoutTax",
    "penaltyCurrency"
})
public class DevicePenaltyInfo {

    protected String deviceSapId;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar commitmentEndDate;
    protected String penaltyAmountWithTax;
    protected String penaltyAmountWithoutTax;
    protected String penaltyCurrency;

    /**
     * Obtiene el valor de la propiedad deviceSapId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceSapId() {
        return deviceSapId;
    }

    /**
     * Define el valor de la propiedad deviceSapId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceSapId(String value) {
        this.deviceSapId = value;
    }

    /**
     * Obtiene el valor de la propiedad commitmentEndDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCommitmentEndDate() {
        return commitmentEndDate;
    }

    /**
     * Define el valor de la propiedad commitmentEndDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCommitmentEndDate(XMLGregorianCalendar value) {
        this.commitmentEndDate = value;
    }

    /**
     * Obtiene el valor de la propiedad penaltyAmountWithTax.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPenaltyAmountWithTax() {
        return penaltyAmountWithTax;
    }

    /**
     * Define el valor de la propiedad penaltyAmountWithTax.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPenaltyAmountWithTax(String value) {
        this.penaltyAmountWithTax = value;
    }

    /**
     * Obtiene el valor de la propiedad penaltyAmountWithoutTax.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPenaltyAmountWithoutTax() {
        return penaltyAmountWithoutTax;
    }

    /**
     * Define el valor de la propiedad penaltyAmountWithoutTax.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPenaltyAmountWithoutTax(String value) {
        this.penaltyAmountWithoutTax = value;
    }

    /**
     * Obtiene el valor de la propiedad penaltyCurrency.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPenaltyCurrency() {
        return penaltyCurrency;
    }

    /**
     * Define el valor de la propiedad penaltyCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPenaltyCurrency(String value) {
        this.penaltyCurrency = value;
    }

}
