
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ChangeFunPackRequest_data_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the subscriberID property.
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
     * Sets the value of the subscriberID property.
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
     * Gets the value of the msisdn property.
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
     * Sets the value of the msisdn property.
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
     * Gets the value of the action property.
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
     * Sets the value of the action property.
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
     * Gets the value of the expirationDate property.
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
     * Sets the value of the expirationDate property.
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
     * Gets the value of the expirationTime property.
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
     * Sets the value of the expirationTime property.
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
     * Gets the value of the applicationsOldList property.
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
     * Sets the value of the applicationsOldList property.
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
     * Gets the value of the applicationsNewList property.
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
     * Sets the value of the applicationsNewList property.
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
