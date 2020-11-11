
package pe.telefonica.tefrequestheader.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para TefHeaderReqType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TefHeaderReqType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="userLogin" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="serviceChannel" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="sessionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="application" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ipAddress" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="functionalityCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="transactionTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="serviceName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TefHeaderReqType", propOrder = {
    "userLogin",
    "serviceChannel",
    "sessionCode",
    "application",
    "idMessage",
    "ipAddress",
    "functionalityCode",
    "transactionTimestamp",
    "serviceName",
    "version"
})
public class TefHeaderReqType {

    @XmlElement(required = true)
    protected String userLogin;
    @XmlElement(required = true)
    protected String serviceChannel;
    protected String sessionCode;
    @XmlElement(required = true)
    protected String application;
    protected String idMessage;
    @XmlElement(required = true)
    protected String ipAddress;
    protected String functionalityCode;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar transactionTimestamp;
    @XmlElement(required = true)
    protected String serviceName;
    @XmlElement(required = true)
    protected String version;

    /**
     * Obtiene el valor de la propiedad userLogin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserLogin() {
        return userLogin;
    }

    /**
     * Define el valor de la propiedad userLogin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserLogin(String value) {
        this.userLogin = value;
    }

    /**
     * Obtiene el valor de la propiedad serviceChannel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceChannel() {
        return serviceChannel;
    }

    /**
     * Define el valor de la propiedad serviceChannel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceChannel(String value) {
        this.serviceChannel = value;
    }

    /**
     * Obtiene el valor de la propiedad sessionCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionCode() {
        return sessionCode;
    }

    /**
     * Define el valor de la propiedad sessionCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionCode(String value) {
        this.sessionCode = value;
    }

    /**
     * Obtiene el valor de la propiedad application.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplication() {
        return application;
    }

    /**
     * Define el valor de la propiedad application.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplication(String value) {
        this.application = value;
    }

    /**
     * Obtiene el valor de la propiedad idMessage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdMessage() {
        return idMessage;
    }

    /**
     * Define el valor de la propiedad idMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdMessage(String value) {
        this.idMessage = value;
    }

    /**
     * Obtiene el valor de la propiedad ipAddress.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * Define el valor de la propiedad ipAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpAddress(String value) {
        this.ipAddress = value;
    }

    /**
     * Obtiene el valor de la propiedad functionalityCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunctionalityCode() {
        return functionalityCode;
    }

    /**
     * Define el valor de la propiedad functionalityCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunctionalityCode(String value) {
        this.functionalityCode = value;
    }

    /**
     * Obtiene el valor de la propiedad transactionTimestamp.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTransactionTimestamp() {
        return transactionTimestamp;
    }

    /**
     * Define el valor de la propiedad transactionTimestamp.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTransactionTimestamp(XMLGregorianCalendar value) {
        this.transactionTimestamp = value;
    }

    /**
     * Obtiene el valor de la propiedad serviceName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Define el valor de la propiedad serviceName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceName(String value) {
        this.serviceName = value;
    }

    /**
     * Obtiene el valor de la propiedad version.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Define el valor de la propiedad version.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
