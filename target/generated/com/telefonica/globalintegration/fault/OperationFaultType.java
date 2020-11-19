
package com.telefonica.globalintegration.fault;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for operationFaultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="operationFaultType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="exceptionCategory" type="{http://telefonica.com/globalIntegration/fault}exceptionCategoryType"/&gt;
 *         &lt;element name="exceptionCode" type="{http://telefonica.com/globalIntegration/fault}exceptionCodeType"/&gt;
 *         &lt;element name="exceptionMessage" type="{http://telefonica.com/globalIntegration/fault}exceptionMessageType"/&gt;
 *         &lt;element name="exceptionDetail" type="{http://telefonica.com/globalIntegration/fault}exceptionDetailType"/&gt;
 *         &lt;element name="exceptionSeverity" type="{http://telefonica.com/globalIntegration/fault}exceptionSeverityType"/&gt;
 *         &lt;element name="exceptionType" type="{http://telefonica.com/globalIntegration/fault}exceptionType" minOccurs="0"/&gt;
 *         &lt;element name="exceptionProtocol" type="{http://telefonica.com/globalIntegration/fault}exceptionProtocolType" minOccurs="0"/&gt;
 *         &lt;element name="appDetail" type="{http://telefonica.com/globalIntegration/fault}appDetailType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "operationFaultType", propOrder = {
    "exceptionCategory",
    "exceptionCode",
    "exceptionMessage",
    "exceptionDetail",
    "exceptionSeverity",
    "exceptionType",
    "exceptionProtocol",
    "appDetail"
})
public class OperationFaultType {

    @XmlElement(required = true)
    protected String exceptionCategory;
    @XmlElement(required = true)
    protected String exceptionCode;
    @XmlElement(required = true)
    protected String exceptionMessage;
    @XmlElement(required = true)
    protected String exceptionDetail;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String exceptionSeverity;
    protected String exceptionType;
    protected ExceptionProtocolType exceptionProtocol;
    protected AppDetailType appDetail;

    /**
     * Gets the value of the exceptionCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExceptionCategory() {
        return exceptionCategory;
    }

    /**
     * Sets the value of the exceptionCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExceptionCategory(String value) {
        this.exceptionCategory = value;
    }

    /**
     * Gets the value of the exceptionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExceptionCode() {
        return exceptionCode;
    }

    /**
     * Sets the value of the exceptionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExceptionCode(String value) {
        this.exceptionCode = value;
    }

    /**
     * Gets the value of the exceptionMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExceptionMessage() {
        return exceptionMessage;
    }

    /**
     * Sets the value of the exceptionMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExceptionMessage(String value) {
        this.exceptionMessage = value;
    }

    /**
     * Gets the value of the exceptionDetail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExceptionDetail() {
        return exceptionDetail;
    }

    /**
     * Sets the value of the exceptionDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExceptionDetail(String value) {
        this.exceptionDetail = value;
    }

    /**
     * Gets the value of the exceptionSeverity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExceptionSeverity() {
        return exceptionSeverity;
    }

    /**
     * Sets the value of the exceptionSeverity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExceptionSeverity(String value) {
        this.exceptionSeverity = value;
    }

    /**
     * Gets the value of the exceptionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExceptionType() {
        return exceptionType;
    }

    /**
     * Sets the value of the exceptionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExceptionType(String value) {
        this.exceptionType = value;
    }

    /**
     * Gets the value of the exceptionProtocol property.
     * 
     * @return
     *     possible object is
     *     {@link ExceptionProtocolType }
     *     
     */
    public ExceptionProtocolType getExceptionProtocol() {
        return exceptionProtocol;
    }

    /**
     * Sets the value of the exceptionProtocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExceptionProtocolType }
     *     
     */
    public void setExceptionProtocol(ExceptionProtocolType value) {
        this.exceptionProtocol = value;
    }

    /**
     * Gets the value of the appDetail property.
     * 
     * @return
     *     possible object is
     *     {@link AppDetailType }
     *     
     */
    public AppDetailType getAppDetail() {
        return appDetail;
    }

    /**
     * Sets the value of the appDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppDetailType }
     *     
     */
    public void setAppDetail(AppDetailType value) {
        this.appDetail = value;
    }

}
