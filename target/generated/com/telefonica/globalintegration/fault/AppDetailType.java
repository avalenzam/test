
package com.telefonica.globalintegration.fault;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for appDetailType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="appDetailType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="exceptionAppCode" type="{http://telefonica.com/globalIntegration/fault}exceptionAppCodeType"/&gt;
 *         &lt;element name="exceptionAppMessage" type="{http://telefonica.com/globalIntegration/fault}exceptionAppMessageType"/&gt;
 *         &lt;element name="exceptionAppLocation" type="{http://telefonica.com/globalIntegration/fault}exceptionAppLocationType" minOccurs="0"/&gt;
 *         &lt;element name="exceptionAppCause" type="{http://telefonica.com/globalIntegration/fault}exceptionAppCauseType" minOccurs="0"/&gt;
 *         &lt;element name="varArg" type="{http://telefonica.com/globalIntegration/fault}varArgType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "appDetailType", propOrder = {
    "exceptionAppCode",
    "exceptionAppMessage",
    "exceptionAppLocation",
    "exceptionAppCause",
    "varArg"
})
public class AppDetailType {

    @XmlElement(required = true)
    protected String exceptionAppCode;
    @XmlElement(required = true)
    protected String exceptionAppMessage;
    protected String exceptionAppLocation;
    protected String exceptionAppCause;
    protected VarArgType varArg;

    /**
     * Gets the value of the exceptionAppCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExceptionAppCode() {
        return exceptionAppCode;
    }

    /**
     * Sets the value of the exceptionAppCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExceptionAppCode(String value) {
        this.exceptionAppCode = value;
    }

    /**
     * Gets the value of the exceptionAppMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExceptionAppMessage() {
        return exceptionAppMessage;
    }

    /**
     * Sets the value of the exceptionAppMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExceptionAppMessage(String value) {
        this.exceptionAppMessage = value;
    }

    /**
     * Gets the value of the exceptionAppLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExceptionAppLocation() {
        return exceptionAppLocation;
    }

    /**
     * Sets the value of the exceptionAppLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExceptionAppLocation(String value) {
        this.exceptionAppLocation = value;
    }

    /**
     * Gets the value of the exceptionAppCause property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExceptionAppCause() {
        return exceptionAppCause;
    }

    /**
     * Sets the value of the exceptionAppCause property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExceptionAppCause(String value) {
        this.exceptionAppCause = value;
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
