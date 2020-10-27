
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para ChangeFunPackRequest_data_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ChangeFunPackRequest_data_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="subscriberID"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="msisdn"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="10"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="action"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="10"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="expirationDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="expirationTime"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="8"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="applicationsOldList" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ApplicationsList" minOccurs="0"/&gt;
 *         &lt;element name="applicationsNewList" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ApplicationsList"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangeFunPackRequest_data_type", propOrder = {
    "subscriberID",
    "msisdn",
    "action",
    "expirationDate",
    "expirationTime",
    "applicationsOldList",
    "applicationsNewList"
})
public class ChangeFunPackRequestDataType {

    @XmlElement(required = true)
    protected String subscriberID;
    @XmlElement(required = true)
    protected String msisdn;
    @XmlElement(required = true)
    protected String action;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar expirationDate;
    @XmlElement(required = true)
    protected String expirationTime;
    protected ApplicationsList applicationsOldList;
    @XmlElement(required = true)
    protected ApplicationsList applicationsNewList;

    /**
     * Obtiene el valor de la propiedad subscriberID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriberID() {
        return subscriberID;
    }

    /**
     * Define el valor de la propiedad subscriberID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriberID(String value) {
        this.subscriberID = value;
    }

    /**
     * Obtiene el valor de la propiedad msisdn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsisdn() {
        return msisdn;
    }

    /**
     * Define el valor de la propiedad msisdn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsisdn(String value) {
        this.msisdn = value;
    }

    /**
     * Obtiene el valor de la propiedad action.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAction() {
        return action;
    }

    /**
     * Define el valor de la propiedad action.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAction(String value) {
        this.action = value;
    }

    /**
     * Obtiene el valor de la propiedad expirationDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpirationDate() {
        return expirationDate;
    }

    /**
     * Define el valor de la propiedad expirationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpirationDate(XMLGregorianCalendar value) {
        this.expirationDate = value;
    }

    /**
     * Obtiene el valor de la propiedad expirationTime.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpirationTime() {
        return expirationTime;
    }

    /**
     * Define el valor de la propiedad expirationTime.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpirationTime(String value) {
        this.expirationTime = value;
    }

    /**
     * Obtiene el valor de la propiedad applicationsOldList.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationsList }
     *     
     */
    public ApplicationsList getApplicationsOldList() {
        return applicationsOldList;
    }

    /**
     * Define el valor de la propiedad applicationsOldList.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationsList }
     *     
     */
    public void setApplicationsOldList(ApplicationsList value) {
        this.applicationsOldList = value;
    }

    /**
     * Obtiene el valor de la propiedad applicationsNewList.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationsList }
     *     
     */
    public ApplicationsList getApplicationsNewList() {
        return applicationsNewList;
    }

    /**
     * Define el valor de la propiedad applicationsNewList.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationsList }
     *     
     */
    public void setApplicationsNewList(ApplicationsList value) {
        this.applicationsNewList = value;
    }

}
