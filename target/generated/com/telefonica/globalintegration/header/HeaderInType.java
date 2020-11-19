
package com.telefonica.globalintegration.header;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HeaderInType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the country property.
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
     * Sets the value of the country property.
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
     * Gets the value of the lang property.
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
     * Sets the value of the lang property.
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
     * Gets the value of the entity property.
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
     * Sets the value of the entity property.
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
     * Gets the value of the system property.
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
     * Sets the value of the system property.
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
     * Gets the value of the subsystem property.
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
     * Sets the value of the subsystem property.
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
     * Gets the value of the originator property.
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
     * Sets the value of the originator property.
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
     * Gets the value of the sender property.
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
     * Sets the value of the sender property.
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
     * Gets the value of the userId property.
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
     * Sets the value of the userId property.
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
     * Gets the value of the wsId property.
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
     * Sets the value of the wsId property.
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
     * Gets the value of the wsIp property.
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
     * Sets the value of the wsIp property.
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
     * Gets the value of the wsIpv6 property.
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
     * Sets the value of the wsIpv6 property.
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
     * Gets the value of the operation property.
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
     * Sets the value of the operation property.
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
     * Gets the value of the destination property.
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
     * Sets the value of the destination property.
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
     * Gets the value of the pid property.
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
     * Sets the value of the pid property.
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
     * Gets the value of the execId property.
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
     * Sets the value of the execId property.
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
     * Gets the value of the msgId property.
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
     * Sets the value of the msgId property.
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
     * Gets the value of the timestamp property.
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
     * Sets the value of the timestamp property.
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
     * Gets the value of the msgType property.
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
     * Sets the value of the msgType property.
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
     * Gets the value of the varArg property.
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
     * Sets the value of the varArg property.
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
