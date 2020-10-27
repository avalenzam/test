
package com.telefonica.globalintegration.header;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para HeaderInType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="HeaderInType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="country" type="{http://telefonica.com/globalIntegration/header}countryType"/&gt;
 *         &lt;element name="lang" type="{http://telefonica.com/globalIntegration/header}langType"/&gt;
 *         &lt;element name="entity" type="{http://telefonica.com/globalIntegration/header}entityType"/&gt;
 *         &lt;element name="system" type="{http://telefonica.com/globalIntegration/header}systemType"/&gt;
 *         &lt;element name="subsystem" type="{http://telefonica.com/globalIntegration/header}subsystemType"/&gt;
 *         &lt;element name="originator" type="{http://telefonica.com/globalIntegration/header}originatorType"/&gt;
 *         &lt;element name="sender" type="{http://telefonica.com/globalIntegration/header}senderType" minOccurs="0"/&gt;
 *         &lt;element name="userId" type="{http://telefonica.com/globalIntegration/header}userIdType"/&gt;
 *         &lt;element name="wsId" type="{http://telefonica.com/globalIntegration/header}wsIdType" minOccurs="0"/&gt;
 *         &lt;element name="wsIp" type="{http://telefonica.com/globalIntegration/header}wsIpType" minOccurs="0"/&gt;
 *         &lt;element name="wsIpv6" type="{http://telefonica.com/globalIntegration/header}wsIpv6Type" minOccurs="0"/&gt;
 *         &lt;element name="operation" type="{http://telefonica.com/globalIntegration/header}operationType"/&gt;
 *         &lt;element name="destination" type="{http://telefonica.com/globalIntegration/header}destinationType"/&gt;
 *         &lt;element name="pid" type="{http://telefonica.com/globalIntegration/header}pidType" minOccurs="0"/&gt;
 *         &lt;element name="execId" type="{http://telefonica.com/globalIntegration/header}execIdType"/&gt;
 *         &lt;element name="msgId" type="{http://telefonica.com/globalIntegration/header}msgIdType" minOccurs="0"/&gt;
 *         &lt;element name="timestamp" type="{http://telefonica.com/globalIntegration/header}timestampType"/&gt;
 *         &lt;element name="msgType" type="{http://telefonica.com/globalIntegration/header}msgTypeType" minOccurs="0"/&gt;
 *         &lt;element name="varArg" type="{http://telefonica.com/globalIntegration/header}varArgType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeaderInType", propOrder = {
    "country",
    "lang",
    "entity",
    "system",
    "subsystem",
    "originator",
    "sender",
    "userId",
    "wsId",
    "wsIp",
    "wsIpv6",
    "operation",
    "destination",
    "pid",
    "execId",
    "msgId",
    "timestamp",
    "msgType",
    "varArg"
})
public class HeaderInType {

    @XmlElement(required = true)
    protected String country;
    @XmlElement(required = true)
    protected String lang;
    @XmlElement(required = true)
    protected String entity;
    @XmlElement(required = true)
    protected String system;
    @XmlElement(required = true)
    protected String subsystem;
    @XmlElement(required = true)
    protected String originator;
    protected String sender;
    @XmlElement(required = true)
    protected String userId;
    protected String wsId;
    protected String wsIp;
    protected String wsIpv6;
    @XmlElement(required = true)
    protected String operation;
    @XmlElement(required = true)
    protected String destination;
    protected String pid;
    @XmlElement(required = true)
    protected String execId;
    protected String msgId;
    @XmlElement(required = true)
    protected String timestamp;
    protected String msgType;
    protected VarArgType varArg;

    /**
     * Obtiene el valor de la propiedad country.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Define el valor de la propiedad country.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Obtiene el valor de la propiedad lang.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLang() {
        return lang;
    }

    /**
     * Define el valor de la propiedad lang.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLang(String value) {
        this.lang = value;
    }

    /**
     * Obtiene el valor de la propiedad entity.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntity() {
        return entity;
    }

    /**
     * Define el valor de la propiedad entity.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntity(String value) {
        this.entity = value;
    }

    /**
     * Obtiene el valor de la propiedad system.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystem() {
        return system;
    }

    /**
     * Define el valor de la propiedad system.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystem(String value) {
        this.system = value;
    }

    /**
     * Obtiene el valor de la propiedad subsystem.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubsystem() {
        return subsystem;
    }

    /**
     * Define el valor de la propiedad subsystem.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubsystem(String value) {
        this.subsystem = value;
    }

    /**
     * Obtiene el valor de la propiedad originator.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginator() {
        return originator;
    }

    /**
     * Define el valor de la propiedad originator.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginator(String value) {
        this.originator = value;
    }

    /**
     * Obtiene el valor de la propiedad sender.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSender() {
        return sender;
    }

    /**
     * Define el valor de la propiedad sender.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSender(String value) {
        this.sender = value;
    }

    /**
     * Obtiene el valor de la propiedad userId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Define el valor de la propiedad userId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Obtiene el valor de la propiedad wsId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWsId() {
        return wsId;
    }

    /**
     * Define el valor de la propiedad wsId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWsId(String value) {
        this.wsId = value;
    }

    /**
     * Obtiene el valor de la propiedad wsIp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWsIp() {
        return wsIp;
    }

    /**
     * Define el valor de la propiedad wsIp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWsIp(String value) {
        this.wsIp = value;
    }

    /**
     * Obtiene el valor de la propiedad wsIpv6.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWsIpv6() {
        return wsIpv6;
    }

    /**
     * Define el valor de la propiedad wsIpv6.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWsIpv6(String value) {
        this.wsIpv6 = value;
    }

    /**
     * Obtiene el valor de la propiedad operation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Define el valor de la propiedad operation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperation(String value) {
        this.operation = value;
    }

    /**
     * Obtiene el valor de la propiedad destination.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Define el valor de la propiedad destination.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestination(String value) {
        this.destination = value;
    }

    /**
     * Obtiene el valor de la propiedad pid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPid() {
        return pid;
    }

    /**
     * Define el valor de la propiedad pid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPid(String value) {
        this.pid = value;
    }

    /**
     * Obtiene el valor de la propiedad execId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExecId() {
        return execId;
    }

    /**
     * Define el valor de la propiedad execId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExecId(String value) {
        this.execId = value;
    }

    /**
     * Obtiene el valor de la propiedad msgId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgId() {
        return msgId;
    }

    /**
     * Define el valor de la propiedad msgId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgId(String value) {
        this.msgId = value;
    }

    /**
     * Obtiene el valor de la propiedad timestamp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Define el valor de la propiedad timestamp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimestamp(String value) {
        this.timestamp = value;
    }

    /**
     * Obtiene el valor de la propiedad msgType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     * Define el valor de la propiedad msgType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgType(String value) {
        this.msgType = value;
    }

    /**
     * Obtiene el valor de la propiedad varArg.
     * 
     * @return
     *     possible object is
     *     {@link VarArgType }
     *     
     */
    public VarArgType getVarArg() {
        return varArg;
    }

    /**
     * Define el valor de la propiedad varArg.
     * 
     * @param value
     *     allowed object is
     *     {@link VarArgType }
     *     
     */
    public void setVarArg(VarArgType value) {
        this.varArg = value;
    }

}
