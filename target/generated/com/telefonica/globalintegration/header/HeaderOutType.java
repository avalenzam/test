
package com.telefonica.globalintegration.header;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para HeaderOutType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="HeaderOutType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="originator" type="{http://telefonica.com/globalIntegration/header}originatorType"/&gt;
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
@XmlType(name = "HeaderOutType", propOrder = {
    "originator",
    "destination",
    "pid",
    "execId",
    "msgId",
    "timestamp",
    "msgType",
    "varArg"
})
public class HeaderOutType {

    @XmlElement(required = true)
    protected String originator;
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
